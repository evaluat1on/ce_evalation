package ce.evalution.ce_evaluation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var btn_dash: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_dash = findViewById(R.id.dashboard) as Button

        btn_dash!!.setOnClickListener{
            val intent = Intent(this,Dashboard::class.java)
            startActivity(intent)
        }
    }
}
