package ce.evalution.ce_evaluation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.CardView
import ce.evalution.ce_evaluation.dashboard.Dashboard


class MainActivity : AppCompatActivity() {
    private  var dash:CardView?=null
    var actionbar: ActionBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //actionbar
        actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "เจ้าหน้าที่"

        dash = findViewById(R.id.CardView_dashboard) as CardView
        dash!!.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}
