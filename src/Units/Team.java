package Units;

import java.util.ArrayList;

public class Team {
    private String name;
    private int hp;
    private int wins;
    private Monster currentMonster;
    private ArrayList<Monster> monsters;


    public Team(String name) {
        this.name = name;
    }


    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public void setCurrentMonster(Monster monster) {
        currentMonster = monster;
    }
}
