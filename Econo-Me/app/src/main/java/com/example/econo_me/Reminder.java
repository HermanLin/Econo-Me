package com.example.econo_me;
/*
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException

public class Reminder {
    private Timer timer;
    private Item item;

    public Reminder(int seconds, Item item) {
        timer = new Timer();
        this.item = item;
        timer.schedule(new Notif(), seconds*1000);
    }

    class Notif extends TimerTask {
        public void run() {
            //push item to ready.csv
            String fileName = "ready.csv";

            try{
                File file = new File(fileName);
                file.createNewFile();
            }
            catch(IOException e){

            }
            try {
                PrintWriter writer = new PrintWriter("ready.csv", "UTF-8");
                writer.println(item.getName() + "," + item.getDesc());
            }
            catch (FileNotFoundException e){

            }
            catch (UnsupportedEncodingException e){

            }


            timer.cancel(); //Terminate the timer thread
        }
    }
}
*/

import android.app.Notification;
import android.support.v4.app.NotificationCompat;

import androidx.core.*;
import java.util.Timer;
import java.util.TimerTask;


public class Reminder {

    public static void testing(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // task to run goes here
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "id")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("My notification")
                        .setContentText("Much longer text that cannot fit one line...")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Much longer text that cannot fit one line..."))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long intervalPeriod = 1 * 1000;

        // schedules the task to be run in an interval
        timer.scheduleAtFixedRate(task, delay,
                intervalPeriod);
    }

    public static void main(String[] args) {


    } // end of main
}
