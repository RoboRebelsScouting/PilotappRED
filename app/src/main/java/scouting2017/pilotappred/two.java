package scouting2017.pilotappred;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import static scouting2017.pilotappred.R.attr.backgroundTint;

public class two extends AppCompatActivity {
    public static Variables myAppVariables;

    @Override
    public void onBackPressed () {
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        if (myAppVariables == null){
            myAppVariables = new Variables();
        }
        if (one.Redteam == false) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        }
        if (one.Redteam == true){
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
            }
        getSupportActionBar().setTitle(one.myAppVariables.color);

        /* Position 1
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
        */

        TextView Pilot1 = (TextView) findViewById(R.id.text1);
        Pilot1.setText(one.strPilot1);

        TextView Pilot2 = (TextView) findViewById(R.id.text2);
        Pilot2.setText(one.strPilot2);

        TextView Pilot1rope = (TextView) findViewById(R.id.text3);
        Pilot1rope.setText(one.strPilot1);

        TextView Pilot2rope = (TextView) findViewById(R.id.text4);
        Pilot2rope.setText(one.strPilot2);
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
        myAppVariables.gear = myAppVariables.gear + 1;
        TextView gears = (TextView) findViewById(R.id.gears);
        gears.setText(Integer.toString(myAppVariables.gear));
        findViewById(R.id.pos1go).setEnabled(false);
        findViewById(R.id.Pilot1Drop_1).setEnabled(true);
        findViewById(R.id.Pilot1Stop_1).setEnabled(true);
        findViewById(R.id.Pilot2Drop_1).setEnabled(true);
        findViewById(R.id.Pilot2Stop_1).setEnabled(true);
        findViewById(R.id.undo1).setEnabled(true);
        event position_1go = new event();
        position_1go.eventTime = System.currentTimeMillis();
        position_1go.eventTime = (position_1go.eventTime - one.myAppVariables.startTime)/1000;
        position_1go.eventType = "pos1go";
        one.myAppVariables.eventList.add(position_1go);
        // myAppVariables.pos1go = position_1go.eventTime;
    }
    public void position_1UNDO(View view){
        myAppVariables.gear = myAppVariables.gear - 1;
        TextView gears = (TextView) findViewById(R.id.gears);
        gears.setText(Integer.toString(myAppVariables.gear));
        findViewById(R.id.pos1go).setEnabled(true);
        findViewById(R.id.undo1).setEnabled(false);
        findViewById(R.id.Pilot1Drop_1).setEnabled(false);
        findViewById(R.id.Pilot1Stop_1).setEnabled(false);
        findViewById(R.id.Pilot2Drop_1).setEnabled(false);
        findViewById(R.id.Pilot2Stop_1).setEnabled(false);
    }
    public void P1position_1stop(View view){
        findViewById(R.id.pos1go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_1).setEnabled(false);
        findViewById(R.id.Pilot1Stop_1).setEnabled(false);
        findViewById(R.id.Pilot2Drop_1).setEnabled(false);
        findViewById(R.id.Pilot2Stop_1).setEnabled(false);
        findViewById(R.id.undo1).setEnabled(false);
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
        findViewById(R.id.undo1).setEnabled(false);
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
        findViewById(R.id.undo1).setEnabled(false);
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
        findViewById(R.id.undo1).setEnabled(false);
        event P2position_1drop = new event();
        P2position_1drop.eventTime = System.currentTimeMillis();
        P2position_1drop.eventTime = (P2position_1drop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_1drop.eventValue = one.strPilot2;
        P2position_1drop.eventType = "pos1drop";
        // P1position_1drop.eventTime = (myAppVariables.pos1go - P1position_1drop.eventTime);
        one.myAppVariables.eventList.add(P2position_1drop);
    }


    public void position_2go(View view){
        myAppVariables.gear = myAppVariables.gear + 1;
        TextView gears = (TextView) findViewById(R.id.gears);
        gears.setText(Integer.toString(myAppVariables.gear));
        findViewById(R.id.pos2go).setEnabled(false);
        findViewById(R.id.Pilot1Drop_2).setEnabled(true);
        findViewById(R.id.Pilot1Stop_2).setEnabled(true);
        findViewById(R.id.Pilot2Drop_2).setEnabled(true);
        findViewById(R.id.Pilot2Stop_2).setEnabled(true);
        findViewById(R.id.undo2).setEnabled(true);
        event position_2go = new event();
        position_2go.eventTime = System.currentTimeMillis();
        position_2go.eventTime = (position_2go.eventTime - one.myAppVariables.startTime)/1000;
        position_2go.eventType = "pos2go";
        one.myAppVariables.eventList.add(position_2go);
        // myAppVariables.pos2go = position_2go.eventTime;
    }
    public void position_2UNDO(View view){
        myAppVariables.gear = myAppVariables.gear - 1;
        TextView gears = (TextView) findViewById(R.id.gears);
        gears.setText(Integer.toString(myAppVariables.gear));
        findViewById(R.id.pos2go).setEnabled(true);
        findViewById(R.id.undo2).setEnabled(false);
        findViewById(R.id.Pilot1Drop_2).setEnabled(false);
        findViewById(R.id.Pilot1Stop_2).setEnabled(false);
        findViewById(R.id.Pilot2Drop_2).setEnabled(false);
        findViewById(R.id.Pilot2Stop_2).setEnabled(false);
    }
    public void P1position_2stop(View view){
        findViewById(R.id.pos2go).setEnabled(true);
        findViewById(R.id.Pilot1Drop_2).setEnabled(false);
        findViewById(R.id.Pilot1Stop_2).setEnabled(false);
        findViewById(R.id.Pilot2Drop_2).setEnabled(false);
        findViewById(R.id.Pilot2Stop_2).setEnabled(false);
        findViewById(R.id.undo2).setEnabled(false);
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
        findViewById(R.id.undo2).setEnabled(false);
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
        findViewById(R.id.undo2).setEnabled(false);
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
        findViewById(R.id.undo2).setEnabled(false);
        event P2position_2drop = new event();
        P2position_2drop.eventTime = System.currentTimeMillis();
        P2position_2drop.eventTime = (P2position_2drop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_2drop.eventValue = one.strPilot2;
        P2position_2drop.eventType = "pos2drop";
        // P1position_2drop.eventTime = (myAppVariables.pos2go - P1position_2drop.eventTime);
        one.myAppVariables.eventList.add(P2position_2drop);
    }


    public void position_3go(View view){
        myAppVariables.gear = myAppVariables.gear + 1;
        TextView gears = (TextView) findViewById(R.id.gears);
        gears.setText(Integer.toString(myAppVariables.gear));
        findViewById(R.id.pos3go).setEnabled(false);
        findViewById(R.id.Pilot1Drop_3).setEnabled(true);
        findViewById(R.id.Pilot1Stop_3).setEnabled(true);
        findViewById(R.id.Pilot2Drop_3).setEnabled(true);
        findViewById(R.id.Pilot2Stop_3).setEnabled(true);
        findViewById(R.id.undo3).setEnabled(true);
        event position_3go = new event();
        position_3go.eventTime = System.currentTimeMillis();
        position_3go.eventTime = (position_3go.eventTime - one.myAppVariables.startTime)/1000;
        position_3go.eventType = "pos3go";
        one.myAppVariables.eventList.add(position_3go);
        // myAppVariables.pos3go = position_3go.eventTime;
    }
    public void position_3UNDO(View view){
        myAppVariables.gear = myAppVariables.gear - 1;
        TextView gears = (TextView) findViewById(R.id.gears);
        gears.setText(Integer.toString(myAppVariables.gear));
        findViewById(R.id.pos3go).setEnabled(true);
        findViewById(R.id.undo3).setEnabled(false);
        findViewById(R.id.Pilot1Drop_3).setEnabled(false);
        findViewById(R.id.Pilot1Stop_3).setEnabled(false);
        findViewById(R.id.Pilot2Drop_3).setEnabled(false);
        findViewById(R.id.Pilot2Stop_3).setEnabled(false);
    }
    public void P1position_3stop(View view){
        findViewById(R.id.Pilot1Drop_3).setEnabled(false);
        findViewById(R.id.Pilot1Stop_3).setEnabled(false);
        findViewById(R.id.Pilot2Drop_3).setEnabled(false);
        findViewById(R.id.Pilot2Stop_3).setEnabled(false);
        findViewById(R.id.pos3go).setEnabled(true);
        findViewById(R.id.undo3).setEnabled(false);
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
        findViewById(R.id.undo3).setEnabled(false);
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
        findViewById(R.id.undo3).setEnabled(false);
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
        findViewById(R.id.undo3).setEnabled(false);
        event P2position_3drop = new event();
        P2position_3drop.eventTime = System.currentTimeMillis();
        P2position_3drop.eventTime = (P2position_3drop.eventTime - one.myAppVariables.startTime)/1000;
        P2position_3drop.eventValue = one.strPilot2;
        P2position_3drop.eventType = "pos3drop";
        // P1position_3drop.eventTime = (myAppVariables.pos3go - P1position_3drop.eventTime);
        one.myAppVariables.eventList.add(P2position_3drop);
    }

    public void alarm (View view){
        findViewById(R.id.alarm).setEnabled(false);
        findViewById(R.id.early1).setEnabled(false);
        findViewById(R.id.early2).setEnabled(false);
        findViewById(R.id.P1rope).setEnabled(true);
        findViewById(R.id.P1noRope).setEnabled(true);
        findViewById(R.id.P2rope).setEnabled(true);
        findViewById(R.id.P2noRope).setEnabled(true);
        event alarm = new event();
        alarm.eventTime = System.currentTimeMillis();
        alarm.eventTime = (alarm.eventTime - one.myAppVariables.startTime)/1000;
        alarm.eventType = "ropeGo";
        one.myAppVariables.eventList.add(alarm);
    }
    public void P1early (View view){
        myAppVariables.rope = myAppVariables.rope + 1;
        TextView ropes = (TextView) findViewById(R.id.ropes);
        ropes.setText(Integer.toString(myAppVariables.rope));
        event P1early = new event();
        P1early.eventTime = System.currentTimeMillis();
        P1early.eventTime = (P1early.eventTime - one.myAppVariables.startTime)/1000;
        P1early.eventType = "early";
        P1early.eventValue = one.strPilot1;
        one.myAppVariables.eventList.add(P1early);
    }
    public void P2early (View view){
        myAppVariables.rope = myAppVariables.rope + 1;
        TextView ropes = (TextView) findViewById(R.id.ropes);
        ropes.setText(Integer.toString(myAppVariables.rope));
        event P2early = new event();
        P2early.eventTime = System.currentTimeMillis();
        P2early.eventTime = (P2early.eventTime - one.myAppVariables.startTime)/1000;
        P2early.eventType = "early";
        P2early.eventValue = one.strPilot2;
        one.myAppVariables.eventList.add(P2early);
    }
    public void P1rope (View view){
        myAppVariables.rope = myAppVariables.rope + 1;
        TextView ropes = (TextView) findViewById(R.id.ropes);
        ropes.setText(Integer.toString(myAppVariables.rope));
        event P1rope = new event();
        P1rope.eventTime = System.currentTimeMillis();
        P1rope.eventTime = (P1rope.eventTime - one.myAppVariables.startTime)/1000;
        P1rope.eventType = "rope";
        P1rope.eventValue = one.strPilot1;
        one.myAppVariables.eventList.add(P1rope);
    }
    public void P2rope (View view){
        myAppVariables.rope = myAppVariables.rope + 1;
        TextView ropes = (TextView) findViewById(R.id.ropes);
        ropes.setText(Integer.toString(myAppVariables.rope));
        event P2rope = new event();
        P2rope.eventTime = System.currentTimeMillis();
        P2rope.eventTime = (P2rope.eventTime - one.myAppVariables.startTime)/1000;
        P2rope.eventType = "rope";
        P2rope.eventValue = one.strPilot2;
        one.myAppVariables.eventList.add(P2rope);
    }
    public void P1noRope (View view){
        event P1noRope = new event();
        P1noRope.eventTime = System.currentTimeMillis();
        P1noRope.eventTime = (P1noRope.eventTime - one.myAppVariables.startTime)/1000;
        P1noRope.eventType = "noRope";
        P1noRope.eventValue = one.strPilot1;
        one.myAppVariables.eventList.add(P1noRope);
    }
    public void P2noRope (View view){
        event P2noRope = new event();
        P2noRope.eventTime = System.currentTimeMillis();
        P2noRope.eventTime = (P2noRope.eventTime - one.myAppVariables.startTime)/1000;
        P2noRope.eventType = "noRope";
        P2noRope.eventValue = one.strPilot2;
        one.myAppVariables.eventList.add(P2noRope);
    }



    public void createCSV(View view){
        one.myAppVariables.csvCreate(this);
    }

    /* first set of rope buttons
    public void alarm (View view){
        findViewById(R.id.alarm).setEnabled(false);
        ImageButton Alarm = (ImageButton) findViewById(R.id.alarm);
        findViewById(R.id.P1rope).setEnabled(true);
        findViewById(R.id.P1noRope).setEnabled(true);
        findViewById(R.id.P2rope).setEnabled(true);
        findViewById(R.id.P2noRope).setEnabled(true);
        event ropes = new event();
        ropes.eventTime = System.currentTimeMillis();
        ropes.eventTime = (ropes.eventTime - one.myAppVariables.startTime)/1000;
        ropes.eventType = "ropeAlarm";
        one.myAppVariables.eventList.add(ropes);
    }
    public void P1rope (View view){
        event P1rope = new event();
        P1rope.eventTime = System.currentTimeMillis();
        P1rope.eventTime = (P1rope.eventTime - one.myAppVariables.startTime)/1000;
        P1rope.eventType = "P1rope";
        one.myAppVariables.eventList.add(P1rope);
    }
    public void P2rope (View view){
        event P2rope = new event();
        P2rope.eventTime = System.currentTimeMillis();
        P2rope.eventTime = (P2rope.eventTime - one.myAppVariables.startTime)/1000;
        P2rope.eventType = "P2rope";
        one.myAppVariables.eventList.add(P2rope);
    }

    public void P1noRope (View view){
        event P1noRope = new event();
        P1noRope.eventTime = System.currentTimeMillis();
        P1noRope.eventTime = (P1noRope.eventTime - one.myAppVariables.startTime)/1000;
        P1noRope.eventType = "P1noRope";
        one.myAppVariables.eventList.add(P1noRope);
    }
    public void P2noRope (View view){
        event P2noRope = new event();
        P2noRope.eventTime = System.currentTimeMillis();
        P2noRope.eventTime = (P2noRope.eventTime - one.myAppVariables.startTime)/1000;
        P2noRope.eventType = "P2noRope";
        one.myAppVariables.eventList.add(P2noRope);
    }
    */

    /* IMAGE BUTTONS SUCK
    public void alarm (View view){
        ImageButton Alarm = (ImageButton) findViewById(R.id.Alarm);
        Alarm.setImageResource(android.R.drawable.presence_online);
        Alarm.setClickable(false);
        event alarm = new event();
        alarm.eventTime = System.currentTimeMillis();
        alarm.eventTime = (alarm.eventTime - one.myAppVariables.startTime)/1000;
        alarm.eventType = "ropeGo";
        one.myAppVariables.eventList.add(alarm);
        findViewById(R.id.P1rope).setEnabled(true);
        findViewById(R.id.Pilot1noRope).setEnabled(true);
        findViewById(R.id.P2rope).setEnabled(true);
        findViewById(R.id.Pilot2noRope).setEnabled(true);
        findViewById(R.id.P1rope).setClickable(true);
        findViewById(R.id.Pilot1noRope).setClickable(true);
        findViewById(R.id.P2rope).setClickable(true);
        findViewById(R.id.Pilot2noRope).setClickable(true);
    }
    public void P1rope (View view){
        event P1rope = new event();
        P1rope.eventTime = System.currentTimeMillis();
        P1rope.eventTime = (P1rope.eventTime - one.myAppVariables.startTime)/1000;
        P1rope.eventType = "rope";
        P1rope.eventValue = one.strPilot1;
        one.myAppVariables.eventList.add(P1rope);
    }
    public void P2rope (View view){
        event P2rope = new event();
        P2rope.eventTime = System.currentTimeMillis();
        P2rope.eventTime = (P2rope.eventTime - one.myAppVariables.startTime)/1000;
        P2rope.eventType = "rope";
        P2rope.eventValue = one.strPilot2;
        one.myAppVariables.eventList.add(P2rope);
    }
    public void P1noRope (View view){
        ImageButton Pilot1noRope = (ImageButton) findViewById(R.id.Pilot1noRope);
        Pilot1noRope.setImageResource(android.R.drawable.presence_busy);
        Pilot1noRope.setClickable(false);
        event P1noRope = new event();
        P1noRope.eventTime = System.currentTimeMillis();
        P1noRope.eventTime = (P1noRope.eventTime - one.myAppVariables.startTime)/1000;
        P1noRope.eventType = "noRope";
        P1noRope.eventValue = one.strPilot1;
        one.myAppVariables.eventList.add(P1noRope);
    }
    public void P2noRope (View view){
        ImageButton Pilot2noRope = (ImageButton) findViewById(R.id.Pilot2noRope);
        Pilot2noRope.setImageResource(android.R.drawable.presence_busy);
        Pilot2noRope.setClickable(false);
        event P2noRope = new event();
        P2noRope.eventTime = System.currentTimeMillis();
        P2noRope.eventTime = (P2noRope.eventTime - one.myAppVariables.startTime)/1000;
        P2noRope.eventType = "noRope";
        P2noRope.eventValue = one.strPilot2;
        one.myAppVariables.eventList.add(P2noRope);
    }
    */

    public void P1rotor (View view){
        event P1rotor = new event();
        P1rotor.eventTime = System.currentTimeMillis();
        P1rotor.eventTime = (P1rotor.eventTime - one.myAppVariables.startTime)/1000;
        P1rotor.eventType = "noRotor";
        P1rotor.eventValue = one.strPilot1;
        one.myAppVariables.eventList.add(P1rotor);
    }
    public void P2rotor (View view){
        event P2rotor = new event();
        P2rotor.eventTime = System.currentTimeMillis();
        P2rotor.eventTime = (P2rotor.eventTime - one.myAppVariables.startTime)/1000;
        P2rotor.eventType = "noRotor";
        P2rotor.eventValue = one.strPilot2;
        one.myAppVariables.eventList.add(P2rotor);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = new Intent(this, one.class);
        String eventNameInfo = one.myAppVariables.eventName;
        Integer match = one.myAppVariables.match;
        one.myAppVariables.reset();
        one.myAppVariables.eventName = eventNameInfo;
        one.myAppVariables.match = match +1;
        startActivity(intent);
    }
}
