package ce.evalution.ce_evaluation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import ce.evalution.ce_evaluation.Filter.Year
import ce.evalution.ce_evaluation.evaluation.List_subject
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Update_Grade : AppCompatActivity() {
    var Year = ArrayList<Year>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update__grade)

        val actionbar = supportActionBar

        //set back button
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        var intent = getIntent()
        var coId  =  intent.getStringExtra("coId").toString()

        val btn = findViewById<Button>(R.id.button)
        btn!!.setOnClickListener{

            val BaseUrl = Api_controller()
            val url = BaseUrl.BaseUrl+"/update_Sumscore"
            val ss_grade = findViewById<EditText>(R.id.grade)
              var test =   ss_grade.text.toString()
            val stringRequest = object : StringRequest(Request.Method.POST, url,
                Response.Listener { response ->


                }, Response.ErrorListener { e ->
                    // Your error code here
                }) {
                override fun getParams(): Map<String, String> = mapOf("ss_id" to coId,"ss_grade" to test)
            }
            VolleySingleton.getInstance(this).addToRequestQueue(stringRequest)




        }





    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
