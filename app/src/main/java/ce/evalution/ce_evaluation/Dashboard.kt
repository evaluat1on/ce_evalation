package ce.evalution.ce_evaluation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import org.json.JSONArray
import android.support.v7.widget.LinearLayoutManager

import com.android.volley.Request

import com.android.volley.Response

import com.android.volley.toolbox.StringRequest
import kotlinx.android.synthetic.main.activity_main.*


class Dashboard : AppCompatActivity() {
    val TAG = "SERVICE_BOOK"
    var requestQueue: RequestQueue? = null
    var BookList = ArrayList<Student_dash>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val textView = findViewById<TextView>(R.id.sample)

        // Instantiate the cache
        val cache = DiskBasedCache(cacheDir, 1024 * 1024) // 1MB cap
// Set up the network to use HttpURLConnection as the HTTP client.
        val network = BasicNetwork(HurlStack())
// Instantiate the RequestQueue with the cache and network. Start the queue.
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }

        val url = "http://10.80.39.17/TSP59/School/index.php/srp/eval/Dashboard/student_ajax"
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                val json = JSONArray(response)
                (0 until json.length()).mapTo(BookList){
                    Student_dash(json.getJSONObject(it).getString("count_std"))
                }
                textView.text = "Response is: ${
                BookList[0].author
                }"

                // recycler_list.layoutManager = LinearLayoutManager(this)
                //  recycler_list.adapter = Adapter(this,BookList)


            },
            Response.ErrorListener {/* title.text = "That didn't work!" */}
        )
        stringRequest.tag = TAG
        // Add the request to the RequestQueue.
        requestQueue?.add(stringRequest)
    }

    override fun onStop() {
        super.onStop()
        requestQueue?.cancelAll(TAG)
    }

}
