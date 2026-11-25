package Util;

import Units.Monster;

public class Text {

    public static void combatText(Monster a, Monster b) {
        System.out.println(a.getName() + " is attacking " + b.getName());
    }

    public static void showStatus(Monster a, Monster b) {
        System.out.println("Name: " + a.getName() + " Hp: " + a.getHp());
        System.out.println("Name: " + b.getName() + " Hp: " + b.getHp());
    }

    public static void attackMsg(Monster attacker, Monster targetMonster, int damage) {

        System.out.println(attacker.getName() + " delt " + damage + " to " + targetMonster.getName());
        System.out.println("Their ammor took " + targetMonster.calculateTotalDefense() + " of the Damage");
    }

    public static void dodgeMsg(Monster attacker, Monster targetMonster ) {
        System.out.println(targetMonster.getName() + " DODGED " + attacker.getName() + "'s Attack!");
    }

}
