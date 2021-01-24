package academy.learnprogramming;

/* the Player class maintains information about particular item. one instance is  one item.
there are four methods:
1. getName(): return name of player;
2. getPosition(): return position of player;
3. getPassingReceivingRushingYards(): get yards of player;
4. hasDefensivePosition(): get isdefensive info of player;

 */
public class Player {
    private String name; //player name
    private String position;//player position
    private double passingReceivingRushingYards;//player yards
    private boolean isDefensive;//true or false? is player defensive?

    private Player(){//default constructor
        name = "noName";//default name: noName indicate name was not set
        position = "noPosition";//default position: not set
        passingReceivingRushingYards = -1.0;//default yard: not set
        isDefensive = false; //Default boolean: not set
    }

    //constructor
    public Player(String name,String position, double passingReceivingRushingYards, boolean isDefensive){
        this.name = name;// implicit parameter
        this.position = position;// implicit parameter
        this.passingReceivingRushingYards = passingReceivingRushingYards;
        this.isDefensive = isDefensive;
    }

    public String getName() {

        return name; // get player name
    }

    public String getPosition() {

        return position; // get player position
    }

    public double getPassingReceivingRushingYards() {

        return passingReceivingRushingYards; // get player yard
    }

    public boolean hasDefensivePosition(){

        return isDefensive; // get player defensive
    }

    public boolean hasOffensivePosition(){

        return !isDefensive;// get player NOT defensive
    }
}
