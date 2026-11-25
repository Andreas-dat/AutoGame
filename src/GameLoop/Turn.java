package GameLoop;

import Units.Monster;
import Util.Text;

import java.util.ArrayList;

public class Turn {
    private Monster attacker;
    private Monster defender;
    private int damage;
    private int health;
    private static boolean hasCrit;
    private int turnNumber;
    private int turnID;
    private int turnIDCount = 0;

    public Turn(Monster attacker, Monster defender, int damage, int health, boolean hasCrit, int turnNumber) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
        this.health = health;
        this.hasCrit = hasCrit;
        this.turnNumber = turnNumber;
        this.turnID = turnIDCount;
        turnIDCount++;

    }


    protected static Turn turn(Monster attacker, Monster defender, Long turnSeed, int turnNumber) {
        Text.combatText(attacker, defender);
        int damage = attacker.dealDmg(turnSeed);
        attacker.attack(defender, damage,turnSeed);
        if(damage > attacker.getDamage()) {
            hasCrit = true;
        }
        return new Turn(attacker,defender,damage,defender.getHp(), hasCrit, turnNumber);
    }

}
