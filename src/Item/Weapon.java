package Item;

public class Weapon {
    private String name;
    private String description;
    private int attack;
    private int durability;
    private int ID;
    private static int IDCount;


    public Weapon(String name, String description, int attack, int durability) {
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.durability = durability;
        this.ID = IDCount;
        IDCount++;
    }


    public int getID() {
        return ID;
    }

    public int getAttack() {
        return attack;
    }
}
