/*
 * Noor Fakih <nfakih@stanford.edu>
 * CS 193A, Winter 2019 (instructor: Marty Stepp)
 * Homework Assignment 3
 * MadLibs App - This app allows the user to select a story that will have words missing.
 * They will be taken to another screen where they will be prompted to enter the a word such
 * as a noun or adjective. It will then display their completed story.
 *
 * FillInWords Activity: User will be prompted to enter the particular form of speech so their words
 * can replace the placeholders in the txt file they have choosen to play. Sound effects are
 * included for the OK button, taken from soundbible.com
 */

package com.example.nfaki.cs193a_hw3_nfakih

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_fill_in_words.*

class FillInWordsActivity : AppCompatActivity() {
    private var pCount = 0
    private var index = 0
    private var storyPicked = ""
    private var story = Story()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_in_words)

        //data retrived from mainActivity
        storyPicked = intent.getStringExtra("selectedStory")
        val textID = resources.getIdentifier(storyPicked.toLowerCase(), "raw", this.packageName)
        story.read(this, textID)
        pCount = story.placeholderCount
        setUpScreen()
    }

    /*              setUpScreen()
     * Updates the screen with number of placeholders left to replace and the part of speech the word should be
     */
    private fun setUpScreen(){
        wordsLeft.text = pCount.toString() + " word(s) left"
        wordType.text = "please enter " + story.aVsAn(index) + " " + story.placeholders[index].toLowerCase()
    }

    /*              okButtonOnClick
     * Replaces the current placeholder with the user inputted word. Once all placeholders are replaced
     * it then sends the completed story to ShowStoryActivity, and switches screens to that activity
     */
    fun okButtonOnClick(view: View){
        val mp = MediaPlayer.create(this, R.raw.button)
        mp.start()

        val placeHolder = newWord.getText().toString()
        newWord.setText("")
        story.fillPlaceholder(index, placeHolder)

        if(pCount != 1){
            pCount--
            index++
            setUpScreen()
        }
        else{

            val finishedStory = story.toString()
            val okIntent = Intent(this, ShowStoryActivity::class.java)

            okIntent.putExtra("finishedStory", finishedStory)
            startActivity(okIntent)
        }

    }


}
