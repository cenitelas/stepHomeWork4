package kz.education.stephomework4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegistrationActivity : AppCompatActivity() {

    var buttonSend:Button? = null
    var editTextLogin:EditText? = null
    var editTextPassword:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        initializeView()
        initializeListener()
    }

    fun initializeView(){
        buttonSend = findViewById(R.id.activity_registration_button_send)
        editTextLogin = findViewById(R.id.activity_registration_edit_text_login)
        editTextPassword = findViewById(R.id.activity_registration_edit_text_password)
    }

    fun initializeListener(){
        buttonSend?.setOnClickListener(View.OnClickListener {
            if(editTextLogin!!.text.isNotEmpty() && editTextLogin!!.text.isNotEmpty()){
                sendMessageWhatsApp("User:${editTextLogin?.text} password:${editTextPassword?.text}")
            }
        })
    }

    fun sendMessageWhatsApp(message:String){
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.type = "text/plain"
        sendIntent.setPackage("com.whatsapp")
        startActivity(sendIntent)
    }
}