package Units;
import Item.Amor;
import Item.Jewlery;
import Item.Weapon;
import Util.Text;

import java.util.Random;

//TODO: Stats should be calculated when amor is set not every attack


public class Monster {
    private final String name;
    private final int maxHp;
    private int currentHp;
    private final int damage;
    private final int crit;
    private final int speed;
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

    public int getMaxHp() {
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

    private int critMultiplier(Long seed) {
        Random random = new Random(seed);
        int crit = calculateTotalCrit();

        int roll = random.nextInt(10) + 1;
        if(crit >= roll) {
            return 2; //TODO: Should be critDamage in the future modifier etc
        }
        return 1;
    }

    public int calculateTotalCrit() {
        return jewlery.getCritChance() + crit;
    }

    public int calculateTotalDamage() {
        return weapon.getAttack() + this.damage;
    }

    public boolean hasWonVs(Monster b) {
        return b.currentHp <= 0;
    }

    public int attack(Monster targetMonster, Long seed) {

        if(!doesTargetDodge(targetMonster, seed)) {
            Text.attackMsg(this,targetMonster,damage);
            int damageToTarget = deltDamage(targetMonster, seed);
            if (damageToTarget <= 0) damageToTarget = 0;

            targetMonster.currentHp -= damageToTarget;

            return damageToTarget;
        }
        Text.dodgeMsg(this,targetMonster);
        return 0;

    }

    private int deltDamage(Monster targetMonster, Long seed) {
        return (this.calculateTotalDamage() * critMultiplier(seed)) - targetMonster.calculateTotalDefense();

    }

    private boolean doesTargetDodge(Monster targetMonster, Long seed) {
        Random random = new Random(seed + 1); //This is to make sure the random numbers arent the same for crit and doge
        int roll = random.nextInt(10) + 1;
        return targetMonster.calculateTotalDodge() >= roll;

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
