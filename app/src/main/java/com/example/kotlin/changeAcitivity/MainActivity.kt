package com.example.kotlin.changeAcitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.btn2

class MainActivity  :Fragment(R.layout.activity_main3){
 val fragment : MainActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("sssssa", "onCreate")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         btn2.setOnClickListener {
            findNavController().navigate(R.id.action_mainActivity_to_mainActivity2)

        }
    }


}