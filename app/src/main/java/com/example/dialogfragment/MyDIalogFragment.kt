package com.example.dialogfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class MyDIalogFragment : DialogFragment() {

    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var cancel: Button
    lateinit var ok: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_my_dialog,container,false)
        // Inflate the layout for this fragment

        name = view.findViewById(R.id.editTextName)
        age = view.findViewById(R.id.editTextAge)
        cancel = view.findViewById(R.id.buttonCancel)
        ok = view.findViewById(R.id.buttonOk)

        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        ok.setOnClickListener {

            val userName: String = name.text.toString()
            val userAge: Int = age.text.toString().toInt()
            val mainActivity: MainActivity = activity as MainActivity

            mainActivity.getUserData(userName,userAge)

            dialog!!.dismiss()
        }

        cancel.setOnClickListener {

            dialog!!.dismiss()

        }

        return view
    }


}