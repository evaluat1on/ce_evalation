package ce.evalution.ce_evaluation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.RequestQueue
import org.json.JSONArray
import android.support.v7.widget.LinearLayoutManager
import android.util.Log

import com.android.volley.Request

import com.android.volley.Response
import com.android.volley.toolbox.*

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
        requestQueue = RequestQueue(cache, network).apply {
            start()
        }
        requestQueue = Volley.newRequestQueue(this)
        val url = "http://192.168.1.4:1235/get_year"
        Log.i("test1150", url)
        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url, Response.Listener {
                response ->
                // Display the first 500 characters of the response string.
                val json = JSONArray(response)
                Log.i("test1150", json.toString())
                (0 until json.length()).mapTo(BookList){
                    Student_dash(json.getJSONObject(it).getString("rspAdY"))
                }
                textView.text = "Response is: ${
                BookList[0].rspAdY
                }"

                // recycler_list.layoutManager = LinearLayoutManager(this)
                //  recycler_list.adapter = Adapter(this,BookList)


            },
            Response.ErrorListener { response -> println("Error :" + response) }
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
