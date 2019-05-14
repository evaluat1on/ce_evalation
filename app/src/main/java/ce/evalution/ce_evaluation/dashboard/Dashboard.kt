package ce.evalution.ce_evaluation.dashboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ce.evalution.ce_evaluation.Api_controller
import com.android.volley.RequestQueue
import org.json.JSONArray
import ce.evalution.ce_evaluation.R

import com.android.volley.Request

import com.android.volley.Response
import com.android.volley.toolbox.*


class Dashboard : AppCompatActivity() {
    val TAG = "SERVICE_BOOK"
    var requestQueue: RequestQueue? = null
    var BookList = ArrayList<Student_dash>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var Baseurl = Api_controller()

        val textView = findViewById<TextView>(R.id.sample)

        // Instantiate the cache
        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
// Set up the network to use HttpURLConnection as the HTTP client.
        val network = BasicNetwork(HurlStack())
// Instantiate the RequestQueue with the cache and network. Start the queue.
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }
      //  val queue = Volley.newRequestQueue(this)
        val url = "http://10.80.76.113:7777/get_all"
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->

                textView.text = "test"
                // recycler_list.layoutManager = LinearLayoutManager(this)
                //  recycler_list.adapter = Adapter(this,BookList)
            },
            Response.ErrorListener {textView.text = "That didn't work!"}
        )
        stringRequest.tag = TAG
        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest)
    }

    override fun onStop() {
        super.onStop()
        requestQueue?.cancelAll(TAG)
    }

}
