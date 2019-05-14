package ce.evalution.ce_evaluation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ce.evalution.ce_evaluation.evaluation.Filter_subject
import ce.evalution.ce_evaluation.result.Menu_report
import kotlinx.android.synthetic.main.activity_menu_teacher.*

class Menu_teacher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_teacher)

        CardViewId.setOnClickListener{
            val intent = Intent(this,Filter_subject::class.java)
            startActivity(intent)
        }
        CardView_estimate.setOnClickListener{
            val intent = Intent(this,Menu_report::class.java)
            startActivity(intent)
        }
    }


}
