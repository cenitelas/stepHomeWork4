package kz.education.stephomework4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var buttonSendMessagFriend: Button?  = null;
    var buttonRegistration : Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews();
        initializeListeners();
    }


    fun initializeViews(){
        buttonSendMessagFriend = findViewById(R.id.activity_main_button_send_message_friend)
        buttonRegistration = findViewById(R.id.activity_main_button_registration)
    }

    fun initializeListeners(){
        buttonSendMessagFriend?.setOnClickListener(View.OnClickListener {
            sendMessageWhatsAppFriend("77785490849","Приветик");
        })

        buttonRegistration?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        })
    }

    fun sendMessageWhatsAppFriend(number: String, message:String){
        val smsNumber = number
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.putExtra("jid", "$smsNumber@s.whatsapp.net")
        sendIntent.setPackage("com.whatsapp")
        startActivity(sendIntent)
    }
}