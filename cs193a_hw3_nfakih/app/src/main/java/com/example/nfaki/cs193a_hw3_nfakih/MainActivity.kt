/*
 * Noor Fakih <nfakih@stanford.edu>
 * CS 193A, Winter 2019 (instructor: Marty Stepp)
 * Homework Assignment 3
 * MadLibs App - This app allows the user to select a story that will have words missing.
 * They will be taken to another screen where they will be prompted to enter the a word such
 * as a noun or adjective. It will then display their completed story.
 *
 * Main Activity functions as a welcome screen where the user can read the instructions to learn
 * how MadLibs works and select their MadLib story. Sound effects are included for every button
 * that you can press in the app. All sounds effects were taken from soundbible.com
 */

package com.example.nfaki.cs193a_hw3_nfakih

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    /*              startButtonOnClick
     * Once the User presses the Start button, their selected story from the
     * spinner will be sent to the next activity, FillInWordsActivity, and the
     * app will switch screens to that activity.
     */
    fun startButtonOnClick(view: View){
        val mp = MediaPlayer.create(this, R.raw.start)
        mp.start()
        val startIntent = Intent(this, FillInWordsActivity::class.java)
        val selectedStory = storySpinner.getSelectedItem().toString()
        startIntent.putExtra("selectedStory", selectedStory)
        Toast.makeText(this, "you selected $selectedStory", Toast.LENGTH_SHORT).show()
        startActivity(startIntent)
    }


}
