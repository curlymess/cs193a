/*
 * Noor Fakih <nfakih@stanford.edu>
 * CS 193A, Winter 2019 (instructor: Marty Stepp)
 * Homework Assignment 3
 * MadLibs App - This app allows the user to select a story that will have words missing.
 * They will be taken to another screen where they will be prompted to enter the a word such
 * as a noun or adjective. It will then display their completed story.
 *
 * ShowStory Activity: User will be showed their completed story. If the story is too long, they
 * are able to scroll. A button that has a sound effect from soundbible.com is available to press
 * so they are taken back to MainActivity.
 */
package com.example.nfaki.cs193a_hw3_nfakih

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_show_story.*

class ShowStoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_story)
        val finishedStory = intent.getStringExtra("finishedStory")
        viewStory.text = finishedStory

    }

    /*              againButtonOnClick
     *  Plays sound effect when pressed. Takes user back to MainActivity
     */
    fun againButtonOnClick(view: View){
        val mp = MediaPlayer.create(this, R.raw.button)
        mp.start()

        val againIntent = Intent(this, MainActivity::class.java)
        startActivity(againIntent)
    }

}
