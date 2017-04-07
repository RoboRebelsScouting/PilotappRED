package scouting2017.pilotappred;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by 1153 on 2/7/2017.
 */
public class Variables {
    public long pos1go;
    public long pos2go;
    public long pos3go;
    public int gear;
    public int card1;
    public int card2;
    public int rope;
    public String color;
    public int match;
    public long startTime;
    public String eventName;
    public List<event> eventList;

    public BluetoothClient btClient;
    public boolean btClientSendOnStart = false;
    public String[] btClientFileName = new String[2];
    public String[] btClientMessageString = new String[2];
    public Activity btClientActivity;

    // create arrays - because we either send our own match to the other pilot or
    // we get both files from the file system and send them both to the bluetooth server
    public String[] fileNameBase = new String[2];
    public String[] fileString = new String[2];

    public Variables (){
        reset();
    }

    public void startBluetoothWithFiles(Activity theActivity, String[] fileString, String[] fileNameBase) {

        btClientSendOnStart = true;
        btClientFileName[0] = btClient.fname[0] =  String.format("%50s",fileNameBase[0]);
        btClientMessageString[0] = fileString[0];
        btClientActivity = theActivity;

        if (!fileNameBase[1].equalsIgnoreCase("")) {
            btClientFileName[1] = btClient.fname[1] =  String.format("%50s",fileNameBase[1]);
            btClientMessageString[1] = fileString[1];
        }
        btClient = startBluetooth(theActivity);
    }
    public BluetoothClient startBluetooth(Activity theActivity) {
        // create bluetooth client and send file
        int REQUEST_ENABLE_BT = 1;
        BluetoothAdapter mBluetoothAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(theActivity.getApplicationContext(), "No Bluetooth", Toast.LENGTH_LONG).show();
        }
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE);
            theActivity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        // bluetooth enabled
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address

                if (deviceName.equalsIgnoreCase("Pit2")) {
                    // create the client, set the file namd and message string, start the thread to send it
                    btClient = new BluetoothClient(mBluetoothAdapter,device);

                    if (btClientSendOnStart) {
                        btClient.sendOnStart = btClientSendOnStart;
                        btClient.launchActivity = btClientActivity;
                        btClient.fname = btClientFileName;
                        btClient.messageString = btClientMessageString;
                    }
                    btClient.start();
                    return btClient;
                }
            }
        }
        return null;
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

    public File getAlbumDownloadsDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), albumName);
        if (!file.mkdirs()) {
            Log.e("ERROR", "Directory NOT Created");
        }
        return file;
    }
    public void reset(){
        gear = 0;
        rope = 0;
        pos1go = 0;
        pos2go = 0;
        pos3go = 0;
        match = 1;
        card1 = 0;
        card2 = 0;
        eventList = new ArrayList<event>();
        eventName = new String();
        color = "";
    }

    void csvCreate(Activity theActivity, boolean sendToServer, boolean saveFileOnly) {

        String[] fileNameBase = new String[2];
        fileNameBase[0] = one.myAppVariables.eventName.trim() + "-" +
                one.myAppVariables.match + "-" +
                one.myAppVariables.color + "-pilot";
        String fileName = fileNameBase[0] + ".csv";

        fileNameBase[1] = "";

        fileString[0] = "";
        fileString[1] = "";

        File directory = getAlbumStorageDir("/FRC2017");
        File file = new File(directory,fileName);
        try {
            FileWriter writer = new FileWriter(file);
            String lineOne = one.myAppVariables.eventName.trim() + "," +
                    one.myAppVariables.match + "," +
                    one.myAppVariables.color;


            fileString[0] = fileString[0] + lineOne + "\n";
            writer.write(lineOne + "\n");


            for (int c = 0; c < eventList.size(); c++) {
                String output = "";

                output = one.myAppVariables.eventList.get(c).eventTime + "," +
                        one.myAppVariables.eventList.get(c).eventType + "," +
                        one.myAppVariables.eventList.get(c).eventValue;

                fileString[0] = fileString[0] + output + "\n";
                writer.write(output + "\n");

            }

            writer.close();

            // if sendToServer is false, send to other pilot
            if (!saveFileOnly) {
                if (!sendToServer) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                    theActivity.startActivityForResult(intent, 0);
                } else {
                    // send to bluetooth server

                    // look for other file and get it's data
                    File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "");

                    String pathName = folder.getAbsolutePath();
                    String[] listOfFiles = folder.list();
                    for (int c = 0; c < listOfFiles.length; c++) {
                        if (listOfFiles[c].startsWith(one.myAppVariables.eventName.trim() + "-" +
                                one.myAppVariables.match)) {

                            // get the "other" file that doesn't match the one we are sending
                            if (!listOfFiles[c].equalsIgnoreCase(fileName)) {
                                // read the file into fileString[1]
                                String baseFile = listOfFiles[c].substring(0, (listOfFiles[c].length() - 4));
                                try {
                                    BufferedReader br = new BufferedReader(new FileReader(file));
                                    String line;

                                    fileString[1] = "";
                                    while ((line = br.readLine()) != null) {
                                        fileString[1] = fileString[1] + line;
                                    }

                                    fileNameBase[1] = baseFile;
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                    if (btClient != null) {
                        btClient.fname[0] = String.format("%50s", fileNameBase[0]);
                        btClient.messageString[0] = fileString[0];
                        btClient.launchActivity = theActivity;

                        // if not connected
                        if (!btClient.mmSocket.isConnected()) {
                            btClient.cancel();

                            // send both files
                            this.startBluetoothWithFiles(theActivity, fileString, fileNameBase);
                        } else {
                            btClient.btSend(fileString[0], btClient.fname[0]);

                            // try to send second file
                            if (!fileNameBase[1].equalsIgnoreCase("")) {
                                btClient.fname[1] = String.format("%50s", fileNameBase[1]);

                                btClient.btSend(fileString[1], btClient.fname[1]);
                            }
                        }
                    }
                }
            }
        }catch(IOException e){
            Log.e("ERROR", "File NOT Created", e);
        }
    }
}
