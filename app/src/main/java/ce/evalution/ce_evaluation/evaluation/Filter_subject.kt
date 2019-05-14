package ce.evalution.ce_evaluation.evaluation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import ce.evalution.ce_evaluation.Filter.Year
import ce.evalution.ce_evaluation.R
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_filter_subject.*
import org.json.JSONArray

class Filter_subject : AppCompatActivity() {
    var Year = ArrayList<Year>()
    var requestQueue: RequestQueue? = null
    val TAG = "SERVICE_BOOK"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_subject)


        val url = "http://10.80.83.187:1234/get_year"
        val Year_data = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                val json = JSONArray(response)
                (0 until json.length()).mapTo(Year){
                    Year(json.getJSONObject(it).getString("rspAdY"))
                }

            },
            Response.ErrorListener {/* title.text = "That didn't work!" */}
        )
        Year_data.tag = TAG
        // Add the request to the RequestQueue.
        requestQueue?.add(Year_data)


    }
    override fun onStop() {
        super.onStop()
        requestQueue?.cancelAll(TAG)
    }
}
