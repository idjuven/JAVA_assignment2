package academy.learnprogramming;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;
/*The FootballRoster class uses a array (rosterArray) to maintain all the player instance.
it contains five different methods:
1. getPlayer: takes a parameter call index that represents an position in the rosterArray;
2. addPlayer: add instance of player into the rosterArray and update the array index;
3. getTotalNumberofPlayers: get the total number of players in the array;
4. SaveRosterToFile: save files with roster information (name, position, years, isdefensive);
5. loadRosterFromFile: load file that was saved by previous method.
* */

public class FootballRoster {
    final int arraySize = 1000; // size of rosterArray
    private int totalPlayers; // total number of players
    private Player [] rosterArray = new Player[arraySize]; // initialize array to store roster information

    // default constructor
    public FootballRoster(){
        totalPlayers = 0; //default number of player is zero
    }

    // getPlayer method: get the index information of player
    public Player getPlayer(int index){
        if(index < 0 || index >= totalPlayers){
            return null;  // return null if index is out of range
        }else{
            return rosterArray[index]; //return index of array
        }
    }

    //addplayer method: add player instance into the roster array
    public void addPlayer(Player newItem){
        if(newItem == null){
            System.out.println("Player not added.");
        } else {
            rosterArray[totalPlayers] = newItem; // update neItem and total players
            totalPlayers +=1;
        }
    }

    // get the number of total players
    public int getTotalNumberOfPlayers(){

        return totalPlayers;
    }

    //save roster instance into file
    public void saveRosterToFile(String fileName) {
        for(int x=0; x<totalPlayers; x++){ //for loop to iterate all players in the array
            Player newItem = getPlayer(x); // player instance get from the index "x"

            String name = newItem.getName(); // player name
            String position = newItem.getPosition();//player position
            double passingReceivingRushingYards = newItem.getPassingReceivingRushingYards();// player yards
            boolean isDefensive = newItem.hasDefensivePosition(); // player isdef

            try { // using printwriter class to write the inventory into a text file, append new instances
                PrintWriter output = new PrintWriter(new FileOutputStream(new File("output.txt"), true));
                output.printf("%s%n", name);
                output.printf("%s%n", position);
                output.printf("%f%n", passingReceivingRushingYards);
                output.printf("%b%n", isDefensive);
                output.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }

    }


    //load file
    public void loadRosterFromFile() {
        try {
            File file = new File("output.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
        } catch (Exception e) {

        }
    }
}
