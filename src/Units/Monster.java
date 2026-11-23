package Units;

import java.util.Random;

public class Monster {
    private String name;
    private int hp;
    private int damage;
    private int crit;
    private int speed;


    public Monster(String name, int crit, int damage, int hp, int speed) {
        this.name = name;
        this.crit = crit;
        this.damage = damage;
        this.hp = hp;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getCrit() {
        return crit;
    }

    public int getSpeed() {
        return speed;
    }

    public int dealDmg(Long seed) {
        Random random = new Random(seed);
        int roll = random.nextInt(10) + 1;
        if(crit >= roll) {
            return damage *2;
        }
        return damage;
    }
    public boolean hasWonVs(Monster b) {
        if (b.hp <= 0) {
            return true;
        }
        return false;
    }

    public void attack(Monster monster, int damage) {
        System.out.println(this.getName() + " delt " + damage + " to " + monster.getName());
        monster.hp -= damage;
    }

}
