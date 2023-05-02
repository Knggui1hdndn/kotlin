package com.example.kotlin.MVP.View

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.kotlin.MVP.Contract.LoginContract
import com.example.kotlin.MVP.Model.User
import com.example.kotlin.MVP.Presenter.LoginPresenter
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import java.net.URL


class MainActivity : AppCompatActivity(), LoginContract.View {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
runBlocking {
    
}
        //Dispatchers.Main cho biết rằng tác vụ hiển thị ảnh phải được thực hiện trên luồng giao diện người dùng
        val scope = CoroutineScope(Dispatchers.Main).launch {
            val bytes =
                downloadFile("https://img.vn/uploads/thuvien/vdh1-jpg-20230103144115hXVI1bdkxh.jpg")
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            a.setImageBitmap(bitmap)
        }
        val a = LoginPresenter(this)
        login.setOnClickListener {
            a.login(User(
                name = name.text.toString(),
                password = password.text.toString(),
                id = null,
                email = null,
                friends = null ))
         }
        changeText(name)
        changeText(password)
    }

    private fun changeText(text: EditText?) {
        text?.addTextChangedListener(
            onTextChanged = { t, start, before, count ->
                text.error = null
            }
        )
    }

    //Tải tệp từ internet
    private suspend fun downloadFile(url: String): ByteArray {
        return withContext(Dispatchers.IO) {
            URL(url).readBytes()
        }
    }

    override fun loginSuccess(  id: Int) {
        Toast.makeText(this@MainActivity, "Thành công", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
    }

    override fun loginError(message: String) {
        when (message) {
            "Không bỏ trống" -> {
                name.error = "$message name"
                password.error = "$message password"
            }

            "Không bỏ trống name" -> {
                name.error = message
            }
            "Không bỏ trống password" -> {
                password.error = message
            }
            else -> {
            }
        }
    }

}