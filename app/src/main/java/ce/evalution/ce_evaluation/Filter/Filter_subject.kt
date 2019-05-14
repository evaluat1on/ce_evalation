package ce.evalution.ce_evaluation.Filter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import ce.evalution.ce_evaluation.R
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONArray

class Filter_subject : AppCompatActivity() {
    var Year = ArrayList<Year>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_subject)
        val spinner  = findViewById<Spinner>(R.id.spinnerYear)



        val url = "http://10.80.79.210:1235/get_year"
        val Year_data = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> {
                    response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(Year){
                    Year(json.getJSONObject(it).getString("rspAdY"))
                }

            },
            Response.ErrorListener {  "That didn't work!" }
        )
       // println(Year_data)



    }
}
