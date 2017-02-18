package scouting2017.pilotappred;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class two extends AppCompatActivity {
    public static Variables myAppVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        if (one.Redteam == false) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        }
        if (one.Redteam == true){
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
            }

        //Position 1
        TextView Pilot1_pos1 = (TextView) findViewById(R.id.pos1pilot1);
        Pilot1_pos1.setText(one.strPilot1);

        TextView Pilot2_pos1 = (TextView) findViewById(R.id.pos1pilot2);
        Pilot2_pos1.setText(one.strPilot2);

        //Position 2
        TextView Pilot1_pos2 = (TextView) findViewById(R.id.pos2pilot1);
        Pilot1_pos2.setText(one.strPilot1);

        TextView Pilot2_pos2 = (TextView) findViewById(R.id.pos2pilot2);
        Pilot2_pos2.setText(one.strPilot2);

        //Position 3
        TextView Pilot1_pos3 = (TextView) findViewById(R.id.pos3pilot1);
        Pilot1_pos3.setText(one.strPilot1);

        TextView Pilot2_pos3 = (TextView) findViewById(R.id.pos3pilot2);
        Pilot2_pos3.setText(one.strPilot2);


    }

    /* public void setBar(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.redTeam:
                if (checked){
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
                }
                else {
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                    break;
                }
        }
    } */

    public void position_1go(View view){
        findViewById(R.id.pos1go).setEnabled(false);
        findViewById(R.id.Pilot1Drop_1).setEnabled(true);
        findViewById(R.id.Pilot1Stop_1).setEnabled(true);
        findViewById(R.id.Pilot2Drop_1).setEnabled(true);
        findViewById(R.id.Pilot2Stop_1).setEnabled(true);
        event position_1go = new event();
        position_1go.eventTime = System.currentTimeMillis();
        position_1go.eventTime = (position_1go.eventTime - one.myAppVariables.startTime)/1000;
        position_1go.eventType = "pos1go";
        one.myAppVariables.eventList.add(position_1go);
        // myAppVariables.pos1go = position_1go.eventTime;
    }
    public void P1position_1stop(View view){
        findViewById(R.id.pos1go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_1).setEnabled(false);
        findViewById(R.id.Pilot1Stop_1).setEnabled(false);
        findViewById(R.id.Pilot2Drop_1).setEnabled(false);
        findViewById(R.id.Pilot2Stop_1).setEnabled(false);
        event P1position_1stop = new event();
        P1position_1stop.eventTime = System.currentTimeMillis();
        P1position_1stop.eventTime = (P1position_1stop.eventTime - one.myAppVariables.startTime)/1000;
        P1position_1stop.eventValue = one.strPilot1;
        P1position_1stop.eventType = "pos1stop";
        // P1position_1stop.eventTime = (myAppVariables.pos1go - P1position_1stop.eventTime);
        one.myAppVariables.eventList.add(P1position_1stop);
    }
    public void P1position_1drop(View view){
        findViewById(R.id.pos1go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_1).setEnabled(false);
        findViewById(R.id.Pilot1Stop_1).setEnabled(false);
        findViewById(R.id.Pilot2Drop_1).setEnabled(false);
        findViewById(R.id.Pilot2Stop_1).setEnabled(false);
        event P1position_1drop = new event();
        P1position_1drop.eventTime = System.currentTimeMillis();
        P1position_1drop.eventTime = (P1position_1drop.eventTime - one.myAppVariables.startTime)/1000;
        P1position_1drop.eventValue = one.strPilot1;
        P1position_1drop.eventType = "pos1drop";
        // P1position_1drop.eventTime = (myAppVariables.pos1go - P1position_1drop.eventTime);
        one.myAppVariables.eventList.add(P1position_1drop);
    }
    public void P2position_1stop(View view){
        findViewById(R.id.pos1go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_1).setEnabled(false);
        findViewById(R.id.Pilot1Stop_1).setEnabled(false);
        findViewById(R.id.Pilot2Drop_1).setEnabled(false);
        findViewById(R.id.Pilot2Stop_1).setEnabled(false);
        event P2position_1stop = new event();
        P2position_1stop.eventTime = System.currentTimeMillis();
        P2position_1stop.eventTime = (P2position_1stop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_1stop.eventValue = one.strPilot2;
        P2position_1stop.eventType = "pos1stop";
        // P1position_1stop.eventTime = (myAppVariables.pos1go - P1position_1stop.eventTime);
        one.myAppVariables.eventList.add(P2position_1stop);
    }
    public void P2position_1drop(View view){
        findViewById(R.id.pos1go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_1).setEnabled(false);
        findViewById(R.id.Pilot1Stop_1).setEnabled(false);
        findViewById(R.id.Pilot2Drop_1).setEnabled(false);
        findViewById(R.id.Pilot2Stop_1).setEnabled(false);
        event P2position_1drop = new event();
        P2position_1drop.eventTime = System.currentTimeMillis();
        P2position_1drop.eventTime = (P2position_1drop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_1drop.eventValue = one.strPilot2;
        P2position_1drop.eventType = "pos1drop";
        // P1position_1drop.eventTime = (myAppVariables.pos1go - P1position_1drop.eventTime);
        one.myAppVariables.eventList.add(P2position_1drop);
    }



    public void position_2go(View view){
        findViewById(R.id.pos2go).setEnabled(false);
        findViewById(R.id.Pilot1Drop_2).setEnabled(true);
        findViewById(R.id.Pilot1Stop_2).setEnabled(true);
        findViewById(R.id.Pilot2Drop_2).setEnabled(true);
        findViewById(R.id.Pilot2Stop_2).setEnabled(true);
        event position_2go = new event();
        position_2go.eventTime = System.currentTimeMillis();
        position_2go.eventTime = (position_2go.eventTime - one.myAppVariables.startTime)/1000;
        position_2go.eventType = "pos2go";
        one.myAppVariables.eventList.add(position_2go);
        // myAppVariables.pos2go = position_2go.eventTime;
    }
    public void P1position_2stop(View view){
        findViewById(R.id.pos2go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_2).setEnabled(false);
        findViewById(R.id.Pilot1Stop_2).setEnabled(false);
        findViewById(R.id.Pilot2Drop_2).setEnabled(false);
        findViewById(R.id.Pilot2Stop_2).setEnabled(false);
        event P1position_2stop = new event();
        P1position_2stop.eventTime = System.currentTimeMillis();
        P1position_2stop.eventTime = (P1position_2stop.eventTime - one.myAppVariables.startTime)/1000;
        P1position_2stop.eventValue = one.strPilot1;
        P1position_2stop.eventType = "pos2stop";
        // P1position_2stop.eventTime = (myAppVariables.pos2go - P1position_2stop.eventTime);
        one.myAppVariables.eventList.add(P1position_2stop);
    }
    public void P1position_2drop(View view){
        findViewById(R.id.pos2go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_2).setEnabled(false);
        findViewById(R.id.Pilot1Stop_2).setEnabled(false);
        findViewById(R.id.Pilot2Drop_2).setEnabled(false);
        findViewById(R.id.Pilot2Stop_2).setEnabled(false);
        event P1position_2drop = new event();
        P1position_2drop.eventTime = System.currentTimeMillis();
        P1position_2drop.eventTime = (P1position_2drop.eventTime - one.myAppVariables.startTime)/1000;
        P1position_2drop.eventValue = one.strPilot1;
        P1position_2drop.eventType = "pos2drop";
        // P1position_2drop.eventTime = (myAppVariables.pos2go - P1position_2drop.eventTime);
        one.myAppVariables.eventList.add(P1position_2drop);
    }
    public void P2position_2stop(View view){
        findViewById(R.id.pos2go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_2).setEnabled(false);
        findViewById(R.id.Pilot1Stop_2).setEnabled(false);
        findViewById(R.id.Pilot2Drop_2).setEnabled(false);
        findViewById(R.id.Pilot2Stop_2).setEnabled(false);
        event P2position_2stop = new event();
        P2position_2stop.eventTime = System.currentTimeMillis();
        P2position_2stop.eventTime = (P2position_2stop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_2stop.eventValue = one.strPilot2;
        P2position_2stop.eventType = "pos2stop";
        // P1position_2stop.eventTime = (myAppVariables.pos2go - P1position_2stop.eventTime);
        one.myAppVariables.eventList.add(P2position_2stop);
    }
    public void P2position_2drop(View view){
        findViewById(R.id.pos2go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_2).setEnabled(false);
        findViewById(R.id.Pilot1Stop_2).setEnabled(false);
        findViewById(R.id.Pilot2Drop_2).setEnabled(false);
        findViewById(R.id.Pilot2Stop_2).setEnabled(false);
        event P2position_2drop = new event();
        P2position_2drop.eventTime = System.currentTimeMillis();
        P2position_2drop.eventTime = (P2position_2drop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_2drop.eventValue = one.strPilot2;
        P2position_2drop.eventType = "pos2drop";
        // P1position_2drop.eventTime = (myAppVariables.pos2go - P1position_2drop.eventTime);
        one.myAppVariables.eventList.add(P2position_2drop);
    }



    public void position_3go(View view){
        findViewById(R.id.pos3go).setEnabled(false);
        findViewById(R.id.Pilot1Drop_3).setEnabled(true);
        findViewById(R.id.Pilot1Stop_3).setEnabled(true);
        findViewById(R.id.Pilot2Drop_3).setEnabled(true);
        findViewById(R.id.Pilot2Stop_3).setEnabled(true);
        event position_3go = new event();
        position_3go.eventTime = System.currentTimeMillis();
        position_3go.eventTime = (position_3go.eventTime - one.myAppVariables.startTime)/1000;
        position_3go.eventType = "pos3go";
        one.myAppVariables.eventList.add(position_3go);
        // myAppVariables.pos3go = position_3go.eventTime;
    }
    public void P1position_3stop(View view){
        findViewById(R.id.Pilot1Drop_3).setEnabled(false);
        findViewById(R.id.Pilot1Stop_3).setEnabled(false);
        findViewById(R.id.Pilot2Drop_3).setEnabled(false);
        findViewById(R.id.Pilot2Stop_3).setEnabled(false);
        findViewById(R.id.pos3go).setEnabled(true);
        event P1position_3stop = new event();
        P1position_3stop.eventTime = System.currentTimeMillis();
        P1position_3stop.eventTime = (P1position_3stop.eventTime - one.myAppVariables.startTime)/1000;
        P1position_3stop.eventValue = one.strPilot1;
        P1position_3stop.eventType = "pos3stop";
        // P1position_3stop.eventTime = (myAppVariables.pos1go - P1position_3stop.eventTime);
        one.myAppVariables.eventList.add(P1position_3stop);
    }
    public void P1position_3drop(View view){
        findViewById(R.id.Pilot1Drop_3).setEnabled(false);
        findViewById(R.id.Pilot1Stop_3).setEnabled(false);
        findViewById(R.id.Pilot2Drop_3).setEnabled(false);
        findViewById(R.id.Pilot2Stop_3).setEnabled(false);
        findViewById(R.id.pos3go).setEnabled(true);
        event P1position_3drop = new event();
        P1position_3drop.eventTime = System.currentTimeMillis();
        P1position_3drop.eventTime = (P1position_3drop.eventTime - one.myAppVariables.startTime)/1000;
        P1position_3drop.eventValue = one.strPilot1;
        P1position_3drop.eventType = "pos3drop";
        // P1position_3drop.eventTime = (myAppVariables.pos3go - P1position_3drop.eventTime);
        one.myAppVariables.eventList.add(P1position_3drop);
    }
    public void P2position_3stop(View view){
        findViewById(R.id.pos3go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_3).setEnabled(false);
        findViewById(R.id.Pilot1Stop_3).setEnabled(false);
        findViewById(R.id.Pilot2Drop_3).setEnabled(false);
        findViewById(R.id.Pilot2Stop_3).setEnabled(false);
        event P2position_3stop = new event();
        P2position_3stop.eventTime = System.currentTimeMillis();
        P2position_3stop.eventTime = (P2position_3stop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_3stop.eventValue = one.strPilot2;
        P2position_3stop.eventType = "pos3stop";
        // P1position_3stop.eventTime = (myAppVariables.pos1go - P1position_3stop.eventTime);
        one.myAppVariables.eventList.add(P2position_3stop);
    }
    public void P2position_3drop(View view){
        findViewById(R.id.pos3go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_3).setEnabled(false);
        findViewById(R.id.Pilot1Stop_3).setEnabled(false);
        findViewById(R.id.Pilot2Drop_3).setEnabled(false);
        findViewById(R.id.Pilot2Stop_3).setEnabled(false);
        event P2position_3drop = new event();
        P2position_3drop.eventTime = System.currentTimeMillis();
        P2position_3drop.eventTime = (P2position_3drop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_3drop.eventValue = one.strPilot2;
        P2position_3drop.eventType = "pos3drop";
        // P1position_3drop.eventTime = (myAppVariables.pos3go - P1position_3drop.eventTime);
        one.myAppVariables.eventList.add(P2position_3drop);
    }


    public void createCSV(View view){
        one.myAppVariables.csvCreate(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = new Intent(this, one.class);
        String eventNameInfo = one.myAppVariables.eventName;
        one.myAppVariables.reset();
        one.myAppVariables.eventName = eventNameInfo;
        startActivity(intent);
    }
}
