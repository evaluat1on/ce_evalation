package ce.evalution.ce_evaluation.evaluation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ce.evalution.ce_evaluation.Api_controller
import ce.evalution.ce_evaluation.Filter.Student_re
import ce.evalution.ce_evaluation.R
import ce.evalution.ce_evaluation.VolleySingleton
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_list_subject.*
import org.json.JSONArray

class List_component : AppCompatActivity() {
    var Student_re = ArrayList<Student_re>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_component)
        val actionbar = supportActionBar

        //set back button
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        var intent = getIntent()
       var coId  =  intent.getStringExtra("coId").toString()

        val BaseUrl = Api_controller()
        val url = BaseUrl.BaseUrl+"/get_student_list"

        val stringRequest = object : StringRequest(Request.Method.POST, url,
            Response.Listener { response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(Student_re){
                    Student_re(json.getJSONObject(it).getString("stdCode"),
                        json.getJSONObject(it).getString("full_name"),
                        json.getJSONObject(it).getString("ss_id"),
                        json.getJSONObject(it).getString("ss_grade")
                    )
                }

                recycle_list.layoutManager = LinearLayoutManager(this)
                recycle_list.adapter = Recyclestudent(this,Student_re)


            }, Response.ErrorListener { e ->
                // Your error code here
            }) {
            override fun getParams(): Map<String, String> = mapOf("coId" to coId)
        }
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
