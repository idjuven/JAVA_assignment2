package academy.learnprogramming;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/* The TeamRosterTracker Interface Class creates an instance of football roster and talk to the user to perform actions.
this is the class that has the main method.

Author: Lei Shen
Date: 12/4/2020

 */

public class TeamRosterTrackerInterface {

    public static void main(String[] args) {
		FootballRoster roster1 = new FootballRoster();  //Reference for FootballRoster Class
		Scanner scnr = new Scanner(System.in);
		int option = 0; // user menu options

		//display a menu to the user and allow them to enter a choice
		while (option >=0 && option <=4) {
			System.out.println("1. Add a new player to the roster");
			System.out.println("2. Get a player info based on index position in the array");
			System.out.println("3. Save Roster to File");
			System.out.println("4. Load Roster from File");
			System.out.println("5. Exit");
			System.out.println("Please Enter your option:");
			option = scnr.nextInt();

		//Switch structure with 5 different options
			switch (option) {
				case 1:
					System.out.println("Name?");
					String name = scnr.nextLine(); //Input player name
					System.out.println("Position?");
					String position = scnr.nextLine(); //Input player position
					System.out.println("Total Yards?");
					double passingReceivingRushingYards = scnr.nextDouble();//Input player yards
					System.out.println("Is Defensive?(true or false)");
					boolean isDefensive = scnr.nextBoolean(); // Input player def
					Player player1 = new Player(name, position, passingReceivingRushingYards, isDefensive); // new instance of player
					roster1.addPlayer(player1); // add player into roster array
					break;
				case 2:
					System.out.println("Player Index?");
					int index = scnr.nextInt();
					System.out.println(roster1.getPlayer(index).getName()); //get player name based on its index in roster array
					System.out.println(roster1.getPlayer(index).getPosition());//get player position based on its index in roster array
					System.out.println(roster1.getPlayer(index).getPassingReceivingRushingYards());//get player yard based on its index in roster array
					System.out.println(roster1.getPlayer(index).hasDefensivePosition());//get player def based on its index in roster array
					System.out.println(roster1.getTotalNumberOfPlayers());//get total number of players based on its index in roster array
					break;
				case 3:
					roster1.saveRosterToFile("output.txt"); // write all player info into a new file "output.txt"
					break;
				case 4:
					roster1.loadRosterFromFile(); // read file "output.txt"
					break;
				case 5:
					break;
			}

		}
    }
}
