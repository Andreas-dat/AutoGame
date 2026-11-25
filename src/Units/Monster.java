package Units;
import Item.Amor;
import Item.Jewlery;
import Item.Weapon;
import Util.Text;

import java.util.Random;

//TODO: Stats should be calculated when amor is set not every attack


public class Monster {
    private String name;
    private int maxHp;
    private int currentHp;
    private int damage;
    private int crit;
    private int speed;
    private int dodge;

    private Amor amor;
    private Weapon weapon;
    private Jewlery jewlery;


    public Monster(String name, int crit, int damage, int hp, int speed) {
        this.name = name;
        this.crit = crit;
        this.damage = damage;
        this.maxHp = hp;
        this.currentHp = hp;
        this.speed = speed;
        this.amor = new Amor("BareChest", "This is your bare chest", 0);
        this.weapon = new Weapon("BareHands", "Litteraly just your bare hands", 0, 10000);
        this.jewlery = new Jewlery("Family jewel", "does nothing", 0,0,0);
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return maxHp;
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
        int crit = calculateTotalCrit();
        int damage = calculateTotalDamage();

        int roll = random.nextInt(10) + 1;
        if(crit >= roll) {
            return damage * 2;
        }
        return damage;
    }

    public int calculateTotalCrit() {
        return jewlery.getCritChance() + crit;
    }

    public int calculateTotalDamage() {
        return weapon.getAttack() + this.damage;
    }

    public boolean hasWonVs(Monster b) {
        if (b.currentHp <= 0) {
            return true;
        }
        return false;
    }

    public void attack(Monster targetMonster, int damage, Long seed) {

        if(!doesTargetDodge(targetMonster, seed)) {
            int defense = targetMonster.calculateTotalDefense();
            Text.attackMsg(this,targetMonster,damage);

            targetMonster.currentHp -= damage - defense;
            return;
        }
        Text.dodgeMsg(this,targetMonster);

    }

    public boolean doesTargetDodge(Monster targetMonster, Long seed) {
        Random random = new Random(seed + 1); //This is to make sure the random numbers arent the same for crit and doge
        int roll = random.nextInt(10) + 1;
        if(targetMonster.calculateTotalDodge() >= roll) {
            return true;
        }
        return false;

    }

    public void fullHeal() {
        this.currentHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public Amor getAmor() {
        return amor;
    }

    public int calculateTotalDefense() {
        return amor.getDefense();
    }

    public int calculateTotalDodge() { //TODO: Further changes will be made to the dodge mecanic.
        return jewlery.getDodgeChance();
    }

    public void setAmor(Amor amor) {
        this.amor = amor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setJewlery(Jewlery jewlery) {
        this.jewlery = jewlery;
    }
}
