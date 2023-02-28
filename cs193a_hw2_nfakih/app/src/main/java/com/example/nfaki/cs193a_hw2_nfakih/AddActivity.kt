//                  Homework 2: To Do List App
// By Noor Fakih, CS193A, Prof Marty Stepp, Wednesday Section
// Screen 2~ additional feature which utilizes startActivityForResult
// and displays a screen dedicated to getting a new task from the user
// and then sends it back to the first activity so it can add it to the list

package com.example.nfaki.cs193a_hw2_nfakih

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }

    //gets the new task the user entered and sends it to the main activity
    fun doneOnClick(view: View){
        val taskText = newTaskText.getText().toString()
        val myIntent = Intent()
        myIntent.putExtra("task", taskText)
        setResult(RESULT_OK, myIntent)
        finish()
    }
}
