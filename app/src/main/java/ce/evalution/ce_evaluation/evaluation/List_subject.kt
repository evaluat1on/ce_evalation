package ce.evalution.ce_evaluation.evaluation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import ce.evalution.ce_evaluation.Api_controller
import ce.evalution.ce_evaluation.Filter.Subject
import ce.evalution.ce_evaluation.R
import com.android.volley.toolbox.StringRequest

import com.android.volley.Request
import com.android.volley.Response

import com.android.volley.toolbox.Volley
import org.json.JSONArray
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import ce.evalution.ce_evaluation.MainActivity
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_filter_subject.*
import org.json.JSONObject
import ce.evalution.ce_evaluation.VolleySingleton
import ce.evalution.ce_evaluation.evaluation.List_subject
import kotlinx.android.synthetic.main.activity_list_subject.*


class List_subject : AppCompatActivity() {
     var textView: TextView? = null
     var textView2: TextView? = null
     var textView3: TextView? = null
    //  var year : String? = null
    //  var term : String? = null
   //  var stdy : String? = null
     // lateinit var curi : String? = null
    var recy : RecyclerView? = null
    var Subject = ArrayList<Subject>()
    var Subject1 = ArrayList<Subject>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_subject)

        val actionbar = supportActionBar

        //set back button
        actionbar!!.setDisplayHomeAsUpEnabled(true)


        var intent = getIntent()
    var    year  =  intent.getStringExtra("year_number").toString()

       var term  =  intent.getStringExtra("term_number").toString()

        var stdy  =  intent.getStringExtra("study_year").toString()

        var curi  =  intent.getStringExtra("curId").toString()

        val BaseUrl = Api_controller()
        val url = BaseUrl.BaseUrl+"/get_table_subject"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->


                val json = JSONArray(response)
                (0 until json.length()).mapTo(Subject){
                    Subject(json.getJSONObject(it).getString("crsCode"),
                        json.getJSONObject(it).getString("crsName"),
                        json.getJSONObject(it).getString("sgId"),
                        json.getJSONObject(it).getString("sum"),
                        json.getJSONObject(it).getString("coId")
                    )
                }
                recycle_list.layoutManager = LinearLayoutManager(this)
                recycle_list.adapter = RecycleAdapter(this,Subject)

            }, Response.ErrorListener { e ->
                // Your error code here
            }) {

            override fun getParams(): Map<String, String> = mapOf("year_number" to year,"term_number" to term,"study_year" to stdy,"curId" to curi)
        }

       // println("55555555555555555555555555555555555555555555555555555555"+Subject)
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}