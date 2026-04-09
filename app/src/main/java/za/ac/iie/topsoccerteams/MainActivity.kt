package za.ac.iie.topsoccerteams

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    //created array to holf top 5 soccer teams
    //global variable
    val teams = arrayOf<String>("Mam Sundowns FC","Orlando Pirates","Bidvest wits",
        "Stellenbosch FC","Sek United FC")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val teamsTxt = findViewById<TextView>(R.id.TeamsDisplayID)



        //long way
        //variable to hold all teams to display
      /*  var teamsDisplay = ""
        teamsDisplay += "${teams[0]}\n"
        teamsDisplay += "${teams[1]}\n"
        teamsDisplay += "${teams[2]}\n"
        teamsDisplay += "${teams[3]}\n"
        teamsDisplay += "${teams[4]}\n"
        //displaying top 5 teams in text view on ui
        //+= means concatenated
        teamsTxt.text = teamsDisplay*/


        var teamsDisplay = ""
        var count = 0

        //reassigning position 0 of the teams array
        teams[0] = "Mam Sundowns FC :)"
        //while loop to iterate through the teams array and display
        while(count < teams.count()){
            teamsDisplay += "${teams[count]}\n"
             count++
}

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}