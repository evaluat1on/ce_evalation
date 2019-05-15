package ce.evalution.ce_evaluation.Filter

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import ce.evalution.ce_evaluation.Api_controller
import ce.evalution.ce_evaluation.R
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import android.widget.AdapterView.OnItemSelectedListener
import ce.evalution.ce_evaluation.MainActivity
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_filter_subject.*
import org.json.JSONObject
import ce.evalution.ce_evaluation.VolleySingleton
import ce.evalution.ce_evaluation.evaluation.List_subject


class Filter_subject : AppCompatActivity() {
    var Year = ArrayList<Year>()
    var term = ArrayList<term>()
    var Subject = ArrayList<Subject>()

   var btn_sub:Button?=null
    val jsonObject = JSONObject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_subject)

        val actionbar = supportActionBar

        //set back button
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        btn_sub = findViewById(R.id.get_sub) as Button

/*
            val BaseUrl = Api_controller()
            val url = BaseUrl.BaseUrl+"/get_table_subject"

            val stringRequest = object : StringRequest(Request.Method.POST, url,
                Response.Listener { response ->

                    println(response)
                    val json = JSONArray(response)
                    (0 until json.length()).mapTo(Subject){
                        Subject(json.getJSONObject(it).getString("crsCode"),
                            json.getJSONObject(it).getString("crsName"),
                            json.getJSONObject(it).getString("sgId"),
                            json.getJSONObject(it).getString("sum"),
                            json.getJSONObject(it).getString("coId")
                            )
                    }

                    println(Subject[0].crsCode)


                }, Response.ErrorListener { e ->
                    // Your error code here
                }) {
                override fun getParams(): Map<String, String> = mapOf("year_number" to "2560","term_number" to "1","study_year" to "4","curId" to "2")
            }
            VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)



*/


//
//
//          startActivity(intent)

        btn_sub!!.setOnClickListener{
            val intent = Intent(this, List_subject::class.java)
            intent.putExtra("year_number", jsonObject["year_number"].toString())
            intent.putExtra("term_number", jsonObject["term_number"].toString())
            intent.putExtra("study_year", jsonObject["study_year"].toString())
            intent.putExtra("curId", jsonObject["curId"].toString())
            startActivity(intent)

        }





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
        val url = BaseUrl.BaseUrl+"/get_term"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(Year){
                    Year(json.getJSONObject(it).getString("rspTmId"))
                }

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
                        jsonObject.put("term_number",text)
                        get_yearstd(text)

                    }
                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Another interface callback
                    }
                }
        }, Response.ErrorListener { e ->
            // Your error code here
        }) {
            override fun getParams(): Map<String, String> = mapOf("year_number" to year)
        }
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)

    }
    fun get_yearstd(term:String){
        val BaseUrl = Api_controller()
        val url = BaseUrl.BaseUrl+"/get_studentYear"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(Year){
                    Year(json.getJSONObject(it).getString("rspSyId"))
                }

                val list = ArrayList<String>()
                for (i in 0 until json.length()) {
                    list.add(json.getJSONObject(i).getString("rspSyId"))
                }
                println(list);
                val spinner = findViewById<Spinner>(R.id.spinnerLevel)


                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
                spinner.adapter = arrayAdapter


                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                        val text = spinner.getSelectedItem().toString()
                        jsonObject.put("study_year",text)
                        get_cur(text)

                    }
                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Another interface callback
                    }
                }
            }, Response.ErrorListener { e ->
                // Your error code here
            }) {
            override fun getParams(): Map<String, String> = mapOf("term_number" to term)
        }
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)


    }
    fun get_cur(stdy:String){
        val BaseUrl = Api_controller()
        val url = BaseUrl.BaseUrl+"/get_cur"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(term){
                    term(json.getJSONObject(it).getString("curId"),
                        json.getJSONObject(it).getString("curName")
                        )
                }

                val list = ArrayList<String>()
                for (i in 0 until json.length()) {
                    list.add(json.getJSONObject(i).getString("curName"))
                }
                println(list);
                val spinner = findViewById<Spinner>(R.id.spinnerCuri)


                val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
                spinner.adapter = arrayAdapter



                spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                        //val text = spinner.getSelectedItem().toString()
                        jsonObject.put("curId",2)


                    }
                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Another interface callback
                    }
                }
            }, Response.ErrorListener { e ->
                // Your error code here
            }) {
            override fun getParams(): Map<String, String> = mapOf("study_year" to stdy)
        }
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
