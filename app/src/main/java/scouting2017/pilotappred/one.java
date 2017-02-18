package scouting2017.pilotappred;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class one extends AppCompatActivity {
    public static String strPilot1;
    public static String strPilot2;
    public static String strEvent;
    public static String strMatch;
    public static Variables myAppVariables;
    public static boolean Redteam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        myAppVariables = new Variables();

    }

    public void pickBlue(View view){
        CheckBox redCheck = (CheckBox)findViewById(R.id.redTeam);
        redCheck.setChecked(false);
        myAppVariables.color = "blue";
        Redteam = false; //blue is not red

    }
    public void pickRed(View view){
        CheckBox blueCheck = (CheckBox)findViewById(R.id.blueTeam);
        blueCheck.setChecked(false);
        myAppVariables.color = "red";
        Redteam = true; // red is red
    }

    public void toPage2(View view){
        EditText Pilot1 = (EditText)findViewById(R.id.Pilot1);
        strPilot1 = Pilot1.getText().toString();
        EditText Pilot2 = (EditText)findViewById(R.id.Pilot2);
        strPilot2 = Pilot2.getText().toString();

        EditText Event = (EditText)findViewById(R.id.Event);
        strEvent = Event.getText().toString();
        EditText Match = (EditText)findViewById(R.id.Match);
        strMatch = Match.getText().toString();

        myAppVariables.startTime = System.currentTimeMillis();
        myAppVariables.eventName = strEvent;
        myAppVariables.match = strMatch;

        Intent intent = new Intent(this, two.class);
        startActivity(intent);
    }
}
