package ce.evalution.ce_evaluation.dashboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ce.evalution.ce_evaluation.Api_controller
import com.android.volley.RequestQueue
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import org.json.JSONArray
import ce.evalution.ce_evaluation.R

import com.android.volley.Request

import com.android.volley.Response

import com.android.volley.toolbox.StringRequest


class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

    }

}
