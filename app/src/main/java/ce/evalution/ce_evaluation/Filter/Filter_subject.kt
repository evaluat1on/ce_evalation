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


              //  val linearLayout = findViewById<LinearLayout>(R.id.rootContainer)

             //   val spinner = Spinner(this)
              //  spinner.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

                val spinner = findViewById<Spinner>(R.id.spinnerTerm)

//
                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
                spinner.adapter = arrayAdapter

                val text = spinner.getSelectedItem().toString()
                println(text)


                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                        println("82312837123781232721823728")
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Another interface callback
                    }
                }





            },
            Response.ErrorListener {/* title.text = "That didn't work!" */}
        )
        queue.add(Year_data)
         // get_term("2560");

    }

    fun get_term(year:String){
        val jsonObject = JSONObject()
        jsonObject.put("year_number",2560)
        jsonObject.put("term_number",1)
        jsonObject.put("study_year",4)
        jsonObject.put("curId",2)

        // Volley post request with parameters
      //  val request = JsonObjectRequest(Request.Method.POST,url,jsonObject,
      //      Response.Listener { response ->

         //   }, Response.ErrorListener{

            //})
        //queue.add(request)
    }
}
