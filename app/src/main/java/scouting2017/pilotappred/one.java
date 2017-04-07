package scouting2017.pilotappred;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import static scouting2017.pilotappred.R.id.Match;

public class one extends AppCompatActivity {
    public static String strPilot1;
    public static String strPilot2;
    public static String strEvent;
    public static Variables myAppVariables = new Variables();
    public static boolean Redteam;


    @Override
    public void onBackPressed () {
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        EditText match = (EditText) findViewById(Match);
        match.setText(Integer.toString(myAppVariables.match));

        if (myAppVariables == null) {
            myAppVariables = new Variables () ;
        }

        myAppVariables.startBluetooth(this);
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
        if (myAppVariables.color == ""){
            Toast.makeText(getApplicationContext(), "Pick an Alliance", Toast.LENGTH_LONG).show();
            return;
        }
        EditText Pilot1 = (EditText)findViewById(R.id.Pilot1);
        strPilot1 = Pilot1.getText().toString();
        EditText Pilot2 = (EditText)findViewById(R.id.Pilot2);
        strPilot2 = Pilot2.getText().toString();
        //EditText Event = (EditText)findViewById(R.id.Event);
        //strEvent = Event.getText().toString();
        TextView Event = (TextView)findViewById(R.id.Event);
        strEvent = Event.getText().toString();
        TextView Match = (TextView)findViewById(R.id.Match);
        myAppVariables.match = Integer.parseInt(Match.getText().toString());


        myAppVariables.startTime = System.currentTimeMillis();
        myAppVariables.eventName = strEvent;

        Intent intent = new Intent(this, two.class);
        startActivity(intent);
    }
}
