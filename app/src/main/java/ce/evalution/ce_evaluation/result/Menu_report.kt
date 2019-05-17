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
        var intent = getIntent()
        var    year  =  intent.getStringExtra("year_number").toString()

        var term  =  intent.getStringExtra("term_number").toString()

        var stdy  =  intent.getStringExtra("study_year").toString()

        var curi  =  intent.getStringExtra("curId").toString()
        var coId  =  intent.getStringExtra("coId").toString()


        //รอเมย์ ทำ layout
      //  CardViewId.setOnClickListener{
      //      val intent = Intent(this, Report_student::class.java)
       //     startActivity(intent)
       // }

        CardViewId2.setOnClickListener{

            val intent = Intent(this, Choose_grade_subject::class.java)
            intent.putExtra("year_number",year )
            intent.putExtra("term_number",term )
            intent.putExtra("study_year",stdy )
            intent.putExtra("curId", curi)
            intent.putExtra("coId", coId)
            startActivity(intent)


        }
    }
}
