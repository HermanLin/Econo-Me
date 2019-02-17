package com.example.econo_me;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Calendar;

public class Database {
    private static Long getWaitTime(){
        File file = new File("wait.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "604800000"; //time defaults to 1 week if file not found
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            line = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Long.parseLong(line);
    }

    private static void scanPending(){
        ArrayList<String> newPending = new ArrayList<>();
        ArrayList<String> newReady = new ArrayList<>();
        File pendingFile = new File("pending.csv");
        try {
            pendingFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(pendingFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                String[] item = line.split(",");
                String name = item[0];
                String desc = item[1];
                String timeStr = item[2];
                Long time = Long.parseLong(timeStr);
                Long currTime = Calendar.getInstance().getTime().getTime();
                currTime -= getWaitTime();
                if (time > currTime){
                    newReady.add(name + desc);
                }
                else{
                    newPending.add(name + desc + timeStr);
                }
            }
            PrintWriter pendingWriter = new PrintWriter(pendingFile);
            for (String writeLine: newPending){
                pendingWriter.print(writeLine);
            }
            File readyF = new File("ready.csv");
            try {
                readyF.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileWriter readyFile = new FileWriter("ready.csv", true);

            PrintWriter readyWriter = new PrintWriter(readyFile);
            for (String writeLine: newReady){
                readyWriter.print(writeLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Item> viewPending(){
        scanPending();

        ArrayList<Item> outList = new ArrayList<>();
        File pendingFile = new File("pending.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(pendingFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                String name = item[0];
                String desc = item[1];
                
                outList.add(new Item(name, desc));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outList;
    }

    public static ArrayList<Item> viewReady(){
        scanPending();

        ArrayList<Item> outList = new ArrayList<>();
        File readyFile = new File("ready.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(readyFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                String name = item[0];
                String desc = item[1];

                outList.add(new Item(name, desc));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outList;
    }

    public static ArrayList<Item> viewApproved(){
        ArrayList<Item> outList = new ArrayList<>();
        File approvedFile = new File("approved.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(approvedFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                String name = item[0];
                String desc = item[1];

                outList.add(new Item(name, desc));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outList;
    }

    public static void addItem(String name, String desc){
        try {
            File pendingF = new File("pending.csv");
            pendingF.createNewFile();

            FileWriter pendingFile = new FileWriter("pending.csv", true);
            PrintWriter pendingWriter = new PrintWriter(pendingFile);
            Long currTime = Calendar.getInstance().getTime().getTime();
            String time = currTime.toString();
            String line = name + "," + desc + "," + time;
            pendingWriter.print(line);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed1!!!!!!!!!");
        }
    }
}
