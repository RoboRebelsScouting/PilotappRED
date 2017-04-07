package scouting2017.pilotappred;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class three extends AppCompatActivity {

    boolean sendToServer = false;
    boolean saveFileOnly = false;

    @Override
    public void onBackPressed () {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        TextView Pilot1 = (TextView) findViewById(R.id.P1);
        Pilot1.setText(one.strPilot1);

        TextView Pilot2 = (TextView) findViewById(R.id.P2);
        Pilot2.setText(one.strPilot2);
    }

    public void P1card (View view){
        one.myAppVariables.card1 = one.myAppVariables.card1 + 1;
        TextView card = (TextView) findViewById(R.id.P1card);
        card.setText(Integer.toString(one.myAppVariables.card1));
        event P1card = new event();
        P1card.eventTime = System.currentTimeMillis();
        P1card.eventTime = (P1card.eventTime - one.myAppVariables.startTime)/1000;
        P1card.eventValue = one.strPilot1;
        P1card.eventType = "P1card";
        one.myAppVariables.eventList.add(P1card);
}
    public void P2card (View view){
        one.myAppVariables.card2 = one.myAppVariables.card2 + 1;
        TextView card = (TextView) findViewById(R.id.P2card);
        card.setText(Integer.toString(one.myAppVariables.card2));
        event P2card = new event();
        P2card.eventTime = System.currentTimeMillis();
        P2card.eventTime = (P2card.eventTime - one.myAppVariables.startTime)/1000;
        P2card.eventValue = one.strPilot2;
        P2card.eventType = "P2card";
        one.myAppVariables.eventList.add(P2card);
    }

    public void createCSV(View view){
        sendToServer = true;
        saveFileOnly = false;
        one.myAppVariables.csvCreate(this,sendToServer,saveFileOnly);
        startFirstActivity(view);
    }

    public void sendOtherPilot(View view) {
        sendToServer = false;
        saveFileOnly = false;
        one.myAppVariables.csvCreate(this,sendToServer,saveFileOnly);
    }

    public void saveOnly(View view) {
        sendToServer = false;
        saveFileOnly = true;
        one.myAppVariables.csvCreate(this,sendToServer,saveFileOnly);
        startFirstActivity(view);
    }

    protected void startFirstActivity(View view) {
        Intent intent = new Intent(this, one.class);
        String eventNameInfo = one.myAppVariables.eventName;
        Integer match = one.myAppVariables.match;
        one.myAppVariables.reset();
        one.myAppVariables.eventName = eventNameInfo;
        one.myAppVariables.match = match +1;
        one.myAppVariables.gear = 0;
        one.myAppVariables.card1 = 0;
        one.myAppVariables.card2 = 0;
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = new Intent(this, one.class);
        String eventNameInfo = one.myAppVariables.eventName;
        Integer match = one.myAppVariables.match;
        one.myAppVariables.reset();
        one.myAppVariables.eventName = eventNameInfo;
        one.myAppVariables.match = match +1;
        one.myAppVariables.gear = 0;
        one.myAppVariables.card1 = 0;
        one.myAppVariables.card2 = 0;
        startActivity(intent);
    }
}
