package ce.evalution.ce_evaluation.dashboard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import ce.evalution.ce_evaluation.Api_controller
import ce.evalution.ce_evaluation.Filter.Course
import ce.evalution.ce_evaluation.Filter.Student
import ce.evalution.ce_evaluation.Filter.Year
import com.android.volley.RequestQueue
import org.json.JSONArray
import ce.evalution.ce_evaluation.R

import com.android.volley.Request

import com.android.volley.Response
import com.android.volley.toolbox.*
import kotlinx.android.synthetic.main.activity_filter_subject.*
import kotlinx.android.synthetic.main.activity_filter_subject.view.*


class Dashboard : AppCompatActivity() {
    var Year = ArrayList<Year>()
    var Student = ArrayList<Student>()
    var Course = ArrayList<Course>()
    private  var teacher: TextView?=null
    private  var student: TextView?=null
    private  var course: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val BaseUrl = Api_controller()
        val queue = Volley.newRequestQueue(this)
        val url = BaseUrl.BaseUrl+"/get_teacher"

        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Dashboard"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        teacher = findViewById(R.id.textViewCardTeacher) as TextView
        student = findViewById(R.id.textViewCardStudent) as TextView
        course = findViewById(R.id.textViewSubject) as TextView
        val Year_data = StringRequest(

            Request.Method.GET, url,
            Response.Listener<String> { response ->



                val json = JSONArray(response)
                (0 until json.length()).mapTo(Year){
                    Year(json.getJSONObject(it).getString("person"))
                }
                println(Year[0].year)
                teacher!!.text=Year[0].year+" คน"

            },
            Response.ErrorListener { println("testsetsesetstestset")}

        )
        queue.add(Year_data)


        val url02 = BaseUrl.BaseUrl+"/get_student_all_year"
        val student_data = StringRequest(

            Request.Method.GET, url02,
            Response.Listener<String> { response ->



                val json = JSONArray(response)
                (0 until json.length()).mapTo(Student){
                    Student(json.getJSONObject(it).getString("count_std"))
                }
                println(Student[0].student)
                student!!.text=Student[0].student+" คน"

            },
            Response.ErrorListener { println("testsetsesetstestset")}

        )
        queue.add(student_data)


        val url03 = BaseUrl.BaseUrl+"/get_count_coid"
        val course_data = StringRequest(

            Request.Method.GET, url03,
            Response.Listener<String> { response ->



                val json = JSONArray(response)
                (0 until json.length()).mapTo(Course){
                    Course(json.getJSONObject(it).getString("sum"))
                }
                println(Course[0].course)
                course!!.text=Course[0].course+" วิชา"

            },
            Response.ErrorListener { println("testsetsesetstestset")}

        )
        queue.add(course_data)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
