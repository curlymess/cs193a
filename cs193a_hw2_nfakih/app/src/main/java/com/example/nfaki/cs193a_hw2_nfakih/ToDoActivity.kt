//                  Homework #2: To Do App
// By Noor Fakih    Class: CS193A   Instructor: Marty Stepp  Section Wednesdays
// To Do list app which allows you to press a floating action button so you can go
// into another screen and write your new task. If there enough items on the list
// then you can scroll to see all of them. You simply press on a task to so it goes
// to the top of the list. To delete you have to long press.

package com.example.nfaki.cs193a_hw2_nfakih

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListAdapter

import kotlinx.android.synthetic.main.activity_to_do.*
import kotlinx.android.synthetic.main.content_to_do.*

class ToDoActivity : AppCompatActivity() {
    private val REQ_CODE = 123

    private val taskList = ArrayList<String>()
    private lateinit var myAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

        fab.setOnClickListener {
            addNewTask()
        }

        //long click to delete a task
        toDoList.setOnItemLongClickListener{_,_, index, _ ->
            taskList.remove(taskList[index])
            myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList)
            toDoList.adapter = myAdapter
            return@setOnItemLongClickListener true
        }

        //simple click to take selected task to the top
        toDoList.setOnItemClickListener{_,_, index, _ ->
            val lastTask = taskList[index]
            taskList.remove(lastTask)
            taskList.add(0, lastTask)
            myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList)
            toDoList.adapter = myAdapter
        }

    }

    //takes user to the second activity AddActivity
    private fun addNewTask(){
        val addIntent = Intent(this, AddActivity::class.java)
        startActivityForResult(addIntent, REQ_CODE)
    }


    //gets the new task from the second activity
    override fun onActivityResult(requestCode: Int, resultCode: Int, myIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, myIntent)
        if(requestCode == REQ_CODE){
            if(myIntent != null){
                val newAddTask = myIntent.getStringExtra("task")
                taskList.add(newAddTask)
                myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskList)
                toDoList.adapter = myAdapter
            }
        }
    }

}
