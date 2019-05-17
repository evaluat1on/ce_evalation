package ce.evalution.ce_evaluation.result

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ce.evalution.ce_evaluation.R
import kotlinx.android.synthetic.main.activity_choose_grade_subject.*

class Choose_grade_student : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_grade_student)
        var intent = getIntent()
        var year  =  intent.getStringExtra("year_number").toString()
        var term  =  intent.getStringExtra("term_number").toString()
        var stdy  =  intent.getStringExtra("study_year").toString()
        var curi  =  intent.getStringExtra("curId").toString()



        val actionbar = supportActionBar

        actionbar!!.setDisplayHomeAsUpEnabled(true)
        CardViewId_A.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "4")
            startActivity(intent)
        }
        CardViewId_Bplus.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "3.5")
            startActivity(intent)

        }
        CardViewId_B.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "3")
            startActivity(intent)

        }
        CardViewId_Cplus.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "2.5")
            startActivity(intent)

        }
        CardViewId_C.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "2")
            startActivity(intent)
        }
        CardViewId_Dplus.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "1.5")
            startActivity(intent)
        }
        CardViewId_D.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "1")
            startActivity(intent)

        }
        CardViewId_F.setOnClickListener {
            val intent = Intent(this, Report_student::class.java)
            intent.putExtra("year_number", year)
            intent.putExtra("term_number", term)
            intent.putExtra("study_year", stdy)
            intent.putExtra("curId", curi)
            intent.putExtra("grade", "0")
            startActivity(intent)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}