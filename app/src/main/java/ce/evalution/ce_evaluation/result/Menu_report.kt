package ce.evalution.ce_evaluation.result

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ce.evalution.ce_evaluation.Filter.Filter_subject
import ce.evalution.ce_evaluation.R
import kotlinx.android.synthetic.main.activity_menu_teacher.*

class Menu_report : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_report)

        //รอเมย์ ทำ layout
      //  CardViewId.setOnClickListener{
      //      val intent = Intent(this, Report_student::class.java)
       //     startActivity(intent)
       // }

        CardViewId2.setOnClickListener{
            val intent = Intent(this, Choose_grade_subject::class.java)
            startActivity(intent)
        }
    }
}
