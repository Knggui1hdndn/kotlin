package com.example.kotlin.MVP.View

import android.R
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.kotlin.MVP.Contract.ShowContract
import com.example.kotlin.MVP.Model.Friend
import com.example.kotlin.MVP.Model.User
import com.example.kotlin.MVP.Presenter.Main2Presenter
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity(), ShowContract.View {
    var lisF = mutableListOf<Friend>()
    var adapter: ArrayAdapter<Friend>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.kotlin.R.layout.activity_main2)
        val view = Main2Presenter(this)
        view.getInfoUsersLogin(intent.getIntExtra("id", 0))

        adapter = ArrayAdapter(this, R.layout.simple_list_item_1, lisF)
        addFriends.setOnClickListener {
            mLinearLayout.visibility =
                if (mLinearLayout.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            addFriends.setBackgroundColor(if (mLinearLayout.isVisible) Color.BLUE else Color.GRAY)
            if (edtName.text.isNotEmpty() && edtOld.text.isNotEmpty()) {
                view.addFriends(intent.getIntExtra("id", 0).toLong(),Friend(null,edtName.text.toString(), edtOld.text.toString().toInt()))
            }
        }
    }

    override fun addSuccess(friend: Friend) {
//        lisF.add(friend)
//        adapter?.notifyDataSetChanged()
    }

    override fun addError(mes: String) {
        Toast.makeText(this@MainActivity2, mes, Toast.LENGTH_SHORT).show()

    }

    override fun showContentSuccess(user: User) {
        user.apply {
            txtName.text = name
            txtEmail.text = email
            txtPassword.text = password
        }
        user.friends?.let { lisF.addAll(it) }
        ListFriend.adapter = adapter
    }

    override fun showContentError(id: String) {
        Log.d("aaaaaaaa", "ok" + id)

        Toast.makeText(this@MainActivity2, id, Toast.LENGTH_SHORT).show()
    }


}