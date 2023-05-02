package com.example.kotlin.changeAcitivity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlin.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainF : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn1.setOnClickListener {


            findNavController().navigate(R.id.action_mainF_to_mainActivity)
        }
        btn2.setOnClickListener {
            findNavController().navigate(R.id.action_mainF_to_mainActivity2)

        }
        btn3.setOnClickListener {
            findNavController().navigate(R.id.action_mainF_to_mainActivity3)

        }
    }
 }