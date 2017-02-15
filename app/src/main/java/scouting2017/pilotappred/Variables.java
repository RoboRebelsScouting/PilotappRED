package scouting2017.pilotappred;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1153 on 2/7/2017.
 */
public class Variables {
    public long pos1go;
    public long pos2go;
    public long pos3go;
    public String color;
    public String match = one.strMatch;
    public long startTime;
    public String eventName;
    public List<event> eventList;

    public Variables (){
        reset();
    }


    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    public File getAlbumStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {
            Log.e("ERROR", "Directory NOT Created");
        }
        return file;
    }

    public void reset(){
        pos1go = 0;
        pos2go = 0;
        pos3go = 0;
        match = new String();
        eventList = new ArrayList<event>();
        eventName = new String();
    }

    void csvCreate(Activity theActivity) {
        String fileName= one.myAppVariables.eventName.trim() + "-" +
                one.myAppVariables.match + "-" +
                one.myAppVariables.color + "-pilot.csv";

        File directory = getAlbumStorageDir("/FRC2017");
        File file = new File(directory,fileName);
        try {
            FileWriter writer = new FileWriter(file);
            String lineOne = one.myAppVariables.eventName.trim() + "," +
                    one.myAppVariables.match + "," +
                    one.myAppVariables.color;



            writer.write(lineOne + "\n");


            for (int c = 0; c < eventList.size(); c++) {
                String output = "";

                output = one.myAppVariables.eventList.get(c).eventTime + "," +
                        one.myAppVariables.eventList.get(c).eventType + "," +
                        one.myAppVariables.eventList.get(c).eventValue;

                writer.write(output + "\n");

            }

            writer.close();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            theActivity.startActivityForResult(intent,0);
        } catch (IOException e) {
            Log.e("ERROR","File NOT Created",e);
        }
    }
}
