package ce.evalution.ce_evaluation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ce.evalution.ce_evaluation.Filter.Filter_report
import ce.evalution.ce_evaluation.Filter.Filter_subject
import kotlinx.android.synthetic.main.activity_menu_teacher.*

class Menu_teacher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_teacher)

        val actionbar = supportActionBar

        //set back button
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        CardViewId.setOnClickListener{
            val intent = Intent(this, Filter_subject::class.java)
            startActivity(intent)
        }
        // จริงแล้วก่อนไปหน้า Menu report ครรไปที่หน้า filter ก่อนอาจจะต้องสร้างใหม่มาอีกอัน
        CardViewId2.setOnClickListener{
            val intent = Intent(this, Filter_report::class.java)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
