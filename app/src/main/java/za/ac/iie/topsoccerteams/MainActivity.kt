package za.ac.iie.topsoccerteams

import android.os.Bundle
import android.os.LimitExceededException
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays
import kotlin.math.log

//created function to display array values in terminal
fun logArrayValues(arr: Array<String>, limit: Int) {
    if (limit == 0) {
        //logs the content of an array of strings
        Log.v("Array Values:", Arrays.toString(arr))
    }
    else {
        Log.v("Array Values:", Arrays.toString(arr.sliceArray(0..limit -1) ))
    }
}

//create function for longest display here
fun getLongestString(arr: Array<String>):String {
    var longestLength = 0
    var longestElement = ""
    for (element in arr) {
        if (element.count() > longestLength) {
            longestLength = element.count()
            longestElement = element
        }
    }
    return longestElement
}

class MainActivity : AppCompatActivity() {
    //global variable
    //created array to hold top 5 soccer teams
    val teams = arrayOf<String>("Mam Sundowns FC","Orlando Pirates","Bidvest wits",
        "Stellenbosch FC","Sek United FC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        /* longer method
        variable to hold all teams to display
        var teamsDisplay = ""
        teamsDisplay += "${teams[0]}\n"
        teamsDisplay += "${teams[1]}\n"
        teamsDisplay += "${teams[2]}\n"
        teamsDisplay += "${teams[3]}\n"
        teamsDisplay += "${teams[4]}\n"
        //displaying top 5 teams in text view on ui
        //+= means concatenated
        teamsTxt.text = teamsDisplay*/

        val teamsTxt = findViewById<TextView>(R.id.TeamsDisplayID)
        var teamsDisplay = ""
        var count = 0

        //value inside () called arguments
        logArrayValues(teams)
        logArrayValues(teams,4)

        //call longest string function here
    var longestName = getLongestString(teams)
    Log.v("Longest name",longestName)

        //reassigning position 0 of the teams array
        teams[0] = "Mam Sundowns FC :)"

        /*while loop to iterate through the teams array and display
          while(count < teams.count()){
          teamsDisplay += "${teams[count]}\n"
          count++ */

        //for loop to iterate through the teams array and display
        for (team in teams ){
            teamsDisplay += "${teams[count]}\n"
        }
        teamsTxt.text = teamsDisplay


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}