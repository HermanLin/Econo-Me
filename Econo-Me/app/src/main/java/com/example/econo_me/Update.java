package com.example.econo_me;
import android.annotation.SuppressLint;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update {
    public static Long getWaitTime(){
        File file = new File("wait.txt");
        String line = "604800000"; //time defaults to 1 week if file not found
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            line = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Long time = Long.parseLong(line);
        return time;
    }

    public static void scanPending(){
        File file = new File("pending.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] item = line.split(",");
                //String name = item[0];
                //String desc = item[1];
                String timeStr = item[2];
                Long time = Long.parseLong(timeStr);
                Long currDate = Calendar.getInstance().getTime().getTime();
                currDate -= getWaitTime();
                if (time > currDate){

                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        try{
            FileReader reader = new FileReader(file);
        }
        catch(FileNotFoundException e){
             try{
                 file.createNewFile();
             }
             catch (IOException e2){
                 System.out.println("something broke");
             }
        }
        */

    }

    public static ArrayList<Item> viewPending(){
        scanPending();

        ArrayList<Item> outlst = new ArrayList<Item>();
        return outlst;
    }

    public static ArrayList<Item> viewReady(){
        scanPending();

        ArrayList<Item> outlst = new ArrayList<Item>();
        return outlst;
    }

    public static ArrayList<Item> viewApproved(){
        ArrayList<Item> outlst = new ArrayList<Item>();
        return outlst;
    }
}
