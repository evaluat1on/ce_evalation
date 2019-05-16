package ce.evalution.ce_evaluation.result

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ce.evalution.ce_evaluation.R
import kotlinx.android.synthetic.main.activity_choose_grade_subject.*

class Choose_grade_subject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_grade_subject)
        val actionbar = supportActionBar

        actionbar!!.setDisplayHomeAsUpEnabled(true)

        CardViewId_A.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
        CardViewId_Bplus.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
        CardViewId_B.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
        CardViewId_Cplus.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
        CardViewId_C.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
        CardViewId_Dplus.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
        CardViewId_D.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
        CardViewId_F.setOnClickListener {
            val intent = Intent(this, Report_subject::class.java)
            startActivity(intent)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
