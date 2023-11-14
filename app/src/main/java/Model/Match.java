package Model;

import java.util.ArrayList;

public class Match {
    private ArrayList<Set> sets;
    private Player P1;
    private Player P2;

    public Match(){
        this.sets = new ArrayList<Set>();
    }

    public ArrayList<Set> getSets(){return sets;}
    public void addSet(Set set){this.sets.add(set);}
    public Player getP1(){return this.P1;}
    public Player getP2(){return this.P2;}
    
}
