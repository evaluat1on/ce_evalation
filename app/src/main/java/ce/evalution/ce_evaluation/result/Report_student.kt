package ce.evalution.ce_evaluation.result

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import ce.evalution.ce_evaluation.Api_controller
import ce.evalution.ce_evaluation.R
import ce.evalution.ce_evaluation.VolleySingleton
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_report_student.*
import kotlinx.android.synthetic.main.activity_report_subject.*
import org.json.JSONArray

class Report_student : AppCompatActivity() {
    var StudentReport = ArrayList<StudentReport>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_student)

        var intent = getIntent()
        var year  =  intent.getStringExtra("year_number").toString()
        var term  =  intent.getStringExtra("term_number").toString()
        var stdy  =  intent.getStringExtra("study_year").toString()
        var curi  =  intent.getStringExtra("curId").toString()
        var Grade  =  intent.getStringExtra("grade").toString()
        val BaseUrl = Api_controller()
        val url = BaseUrl.BaseUrl+"/get_score_student_by_grade"

        val JsonRequest = object : StringRequest(Request.Method.POST,url,
            Response.Listener { response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(StudentReport){
                    StudentReport(json.getJSONObject(it).getString("stdCode"),
                        json.getJSONObject(it).getString("pfName"),
                        json.getJSONObject(it).getString("stdName"),
                        json.getJSONObject(it).getString("stdSurname"),
                        json.getJSONObject(it).getString("number_grade"))
                }


                report_student_list.layoutManager = LinearLayoutManager(this)
                report_student_list.adapter = RecyclerAdapterstdReport(this,StudentReport)

            }, Response.ErrorListener { e ->

            })  {
            override fun getParams():HashMap<String,String>{
                println(year);
                println(term);
                println(stdy);
                println(curi);
                println(Grade);

                val params = HashMap<String, String>()
                params["year_number"] = year;
                params["term_number"] = term;
                params["study_year"] = stdy;
                params["curId"] = curi;
                params["grade"] = Grade;

                return params
            }
        }
        VolleySingleton.getInstance(this).addToRequestQueue(JsonRequest)


    }
}
