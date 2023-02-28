/*
Noor Fakih <nfakih@stanford.edu>
CS 193A, Winter 2019 (instructor: Mr. Marty Stepp)
Homework Assignment 1
Rock, Paper, Scissors!
Description: Play the classic game of rock, paper, scissors by selecting the image of the item you want and click PLAY. The computer
             will randomly select an object, and then the code will determine who wins (or if there was a tie)!
Image Citations
    rock:       https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjJi5CX4-vfAhUAJjQIHQaFBiwQjRx6BAgBEAU&url=https%3A%2F%2Fpngimage.net%2Fcartoon-rock-png-4%2F&psig=AOvVaw1QTsFU62aFvIGQ4Ot8_b-Y&ust=1547503840174006
    paper:      https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjmjf2t4-vfAhUCITQIHSgZDdIQjRx6BAgBEAU&url=https%3A%2F%2Fpngimage.net%2Fcartoon-paper-png-7%2F&psig=AOvVaw1_6Sler2QznfXrmCVCsLHh&ust=1547503887353191
    scissors:   https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjnko-64-vfAhVwIzQIHVKLCnQQjRx6BAgBEAU&url=https%3A%2F%2Fpngtree.com%2Fso%2Fcartoon-scissors&psig=AOvVaw1dbe_6VwZBhvZ514_OgziS&ust=1547503906863128
 */

package com.example.nfaki.cs93a_hw1_nfakih

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private var humanPoints = 0
    private var computerPoints = 0
    private var isRock = false
    private var isPaper = false
    private var isScissors = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //adjusts the user's selection, so that the current selection would be rock
    fun rockButtonClick(view: View) {
        isRock = true
        isPaper = false
        isScissors = false
    }

    //adjusts the user's selection, so that the current selection would be paper
    fun paperButtonClick(view: View) {
        isRock = false
        isPaper = true
        isScissors = false
    }

    //adjusts the user's selection, so that the current selection would be scissors
    fun scissorsButtonClick(view: View) {
        isRock = false
        isPaper = false
        isScissors = true
    }

    //checks to see if the user made a selection (if isRock, isPaper, and isScissors is false) and prompts them to if
    //they did not
    fun makeASelection(): Boolean {
        if(!(isRock || isPaper || isScissors)){
            Toast.makeText(this, "Make a Selection!", Toast.LENGTH_SHORT).show()
        }
        return (isRock || isPaper || isScissors)
    }

    //runs the game and checks to see who won when pressed
    fun playButtonClick(view: View) {
        //if the user made a selection, it will check to see who won, reset the choices, and update the score
        if(makeASelection()) {
            checkIfCorrect()
            reset()
            humanScore.text = Integer.toString(humanPoints)
            computerScore.text = Integer.toString(computerPoints)
        }
    }

    //resets isRock, isPaper, and isScissors to false after the round has been played so the user has to make a new
    //selection
    private fun reset() {
        isRock = false
        isPaper = false
        isScissors = false
    }

    //when checking to see who won, isTie will make sure there was not a tie so the score will be accurate
    private fun isTie(r: Int): Boolean{
        if((r == 1 && isRock) || (r == 2 && isPaper) || (r == 3 && isScissors)){

            Toast.makeText(this, "Tie!", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }

    //the function will increase the score of whoever has won (user or computer) if there was not a tie
    private fun checkIfCorrect() {
        //1: rock
        //2: paper
        //3: scissors
        val r = Random().nextInt(3)+1

        if(!isTie(r)){
            if(r == 1 && isPaper)
            {
                humanPoints++
                Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
            }
            else if(r ==2 && isScissors)
            {
                humanPoints++
                Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
            }
            else if(r ==3 && isRock)
            {
                humanPoints++
                Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show()
            }
            else{
                computerPoints++
                Toast.makeText(this, "You Lose!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
