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
import kotlinx.android.synthetic.main.activity_report_subject.*
import org.json.JSONArray

class Report_subject : AppCompatActivity() {
    var Subjectcount = ArrayList<Subjectcount>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_subject)

        var intent = getIntent()
        var year  =  intent.getStringExtra("year_number").toString()
        var term  =  intent.getStringExtra("term_number").toString()
        var stdy  =  intent.getStringExtra("study_year").toString()
        var curi  =  intent.getStringExtra("curId").toString()
        var Grade  =  intent.getStringExtra("grade").toString()


        val BaseUrl = Api_controller()
        val url = BaseUrl.BaseUrl+"/get_subject_grade"

        val JsonRequest = object : StringRequest(Request.Method.POST,url,
            Response.Listener { response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(Subjectcount){
                    Subjectcount(json.getJSONObject(it).getString("coId"),
                        json.getJSONObject(it).getString("crsCode"),
                        json.getJSONObject(it).getString("crsName"),
                        json.getJSONObject(it).getString("number_grade"))
                }


                report_subject_list.layoutManager = LinearLayoutManager(this)
                report_subject_list.adapter = RecycleAdapterOnSubject(this,Subjectcount)

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
