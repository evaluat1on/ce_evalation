package ce.evalution.ce_evaluation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    private  var username:EditText?=null
    private  var password:EditText?=null
    private  var login:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.input_user) as EditText
        password = findViewById(R.id.input_password) as EditText
        login = findViewById(R.id.btn_login) as Button

        login!!.setOnClickListener{
            if( username!!.text.toString() == "admin"){
                if(password!!.text.toString() == "1234"){
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            }
            if( username!!.text.toString() == "teacher"){
                if(password!!.text.toString() == "1234"){
                    val intent = Intent(this,Menu_teacher::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
