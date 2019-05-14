package ce.evalution.ce_evaluation.Filter

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.TextView
import ce.evalution.ce_evaluation.Api_controller
import ce.evalution.ce_evaluation.R
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import android.widget.ArrayAdapter
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.LinearLayout
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_filter_subject.*
import org.json.JSONObject
import android.widget.AdapterView







class Filter_subject : AppCompatActivity() {
    var Year = ArrayList<Year>()
    var term = ArrayList<term>()
    val jsonObject = JSONObject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_subject)


        val BaseUrl = Api_controller()
        val queue = Volley.newRequestQueue(this)
        val url = BaseUrl.BaseUrl+"/get_year"

        val Year_data = StringRequest(

            Request.Method.GET, url,
            Response.Listener<String> { response ->



                val json = JSONArray(response)
                (0 until json.length()).mapTo(Year){
                    Year(json.getJSONObject(it).getString("rspAdY"))
                }

                val list = ArrayList<String>()
                for (i in 0 until json.length()) {
                    list.add(json.getJSONObject(i).getString("rspAdY"))
                }
                println(list);
                val spinner = findViewById<Spinner>(R.id.spinnerYear)
                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
                spinner.adapter = arrayAdapter

                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                        val text = spinner.getSelectedItem().toString()
                        jsonObject.put("year_number",text)
                        get_term(text)

                    }
                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Another interface callback
                    }
                }
            },
            Response.ErrorListener {/* title.text = "That didn't work!" */}
        )
        queue.add(Year_data)


    }
    fun get_term(year:String){
        val BaseUrl = Api_controller()
        val queue = Volley.newRequestQueue(this)
        val url = BaseUrl.BaseUrl+"/get_term"

        val json = JSONObject()
        json.put("year_number",year)

        val term = JsonObjectRequest(

            Request.Method.PUT, url,json,
            Response.Listener<JSONObject> { response ->

                println("nithi atsiri")
            },
            Response.ErrorListener {
                println("12312312312312312312312312312")
            }
        )
        queue.add(term)
/*
        val list = ArrayList<String>()
        for (i in 0 until json.length()) {
            list.add(json.getJSONObject(i).getString("rspTmId"))
        }
        println(list);
        val spinner = findViewById<Spinner>(R.id.spinnerTerm)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                val text = spinner.getSelectedItem().toString()
                jsonObject.put("year_number",text)
                get_term(text)

            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }*/
    }
}
