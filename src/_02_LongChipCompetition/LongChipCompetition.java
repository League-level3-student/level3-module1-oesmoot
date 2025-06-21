package _02_LongChipCompetition;

import java.util.ArrayList;
import java.util.Random;

public class LongChipCompetition {
    /*
     * The Beatles are eating lunch and playing a game to see who has the
     * longest chip. (In England, french fries are called "chips".)
     * Find the Beatle with the longest chip. You may not edit the Chip or
     * Beatle classes. Make sure to initialize The Beatles before you start
     * your search.
     */
    private ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

    public static void main(String[] args) {
        LongChipCompetition lcc = new LongChipCompetition();
        lcc.initializeBeatles();
        lcc.findLongestChip();
    }
    double GeorgeLongestChip = 0;
    double JohnLongestChip = 0;
    double PaulLongestChip = 0;
    double RingoLongestChip = 0;
    public void findLongestChip() {
    	for(int i = 0; i<theBeatles.size(); i++) {
    		for(int j = 0; j<theBeatles.get(i).getChips().size(); j++) {
    			if(i==0) {
    				if(theBeatles.get(i).getChips().get(j).getLength() > GeorgeLongestChip) {
    					GeorgeLongestChip = theBeatles.get(i).getChips().get(j).getLength(); 
    				}
    			}
    			else if(i==1) {
    				if(theBeatles.get(i).getChips().get(j).getLength() > JohnLongestChip) {
    					JohnLongestChip = theBeatles.get(i).getChips().get(j).getLength(); 
    				}
    			}
    			else if(i==2) {
    				if(theBeatles.get(i).getChips().get(j).getLength() > PaulLongestChip) {
    					PaulLongestChip = theBeatles.get(i).getChips().get(j).getLength(); 
    				}
    			}
    			else {
    				if(theBeatles.get(i).getChips().get(j).getLength() > RingoLongestChip) {
    					RingoLongestChip = theBeatles.get(i).getChips().get(j).getLength(); 
    				}
    			}
    		}
    	}
    	System.out.println(GeorgeLongestChip);
    	System.out.println(JohnLongestChip);
    	System.out.println(PaulLongestChip);
    	System.out.println(RingoLongestChip);
    	if(GeorgeLongestChip >JohnLongestChip && GeorgeLongestChip>PaulLongestChip &&GeorgeLongestChip>RingoLongestChip) {
    		System.out.println("George has the longest chip!");
    	}
    	else if(JohnLongestChip >GeorgeLongestChip && JohnLongestChip>PaulLongestChip &&JohnLongestChip>RingoLongestChip) {
    		System.out.println("John has the longest chip!");
    	}
    	else if(PaulLongestChip >JohnLongestChip && PaulLongestChip>GeorgeLongestChip &&GeorgeLongestChip>RingoLongestChip) {
    		System.out.println("Paul has the longest chip!");
    	}
    	else {
    		System.out.println("Ringo has the longest chip!");
    	}


    }
    
    private void initializeBeatles() {
        Beatle george = new Beatle("George");
        Beatle john = new Beatle("John");
        Beatle paul = new Beatle("Paul");
        Beatle ringo = new Beatle("Ringo");
        theBeatles.add(george);
        theBeatles.add(john);
        theBeatles.add(paul);
        theBeatles.add(ringo);
    }

    public ArrayList<Beatle> getTheBand(){
        return theBeatles;
    }
}

class Beatle {
    private String name;
    private ArrayList<Chip> chips = new ArrayList<Chip>();

    public Beatle(String name) {
        this.name = name;
        initializePlateOfChips();
    }

    private void initializePlateOfChips() {
        int numberOfChips = new Random().nextInt(100);
        for (int i = 0; i < numberOfChips; i++) {
            chips.add(new Chip(new Random().nextDouble() * 10));
        }
    }

    public ArrayList<Chip> getChips() {
        return this.chips;
    }

    public String getName() {
        return this.name;
    }
}

class Chip {
    private double length;

    public double getLength() {
        return length;
    }

    Chip(double d) {
        this.length = d;
    }
}
