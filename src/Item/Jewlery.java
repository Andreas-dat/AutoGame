package Item;

public class Jewlery {
    private String name;
    private String description;
    private int critChance;
    private int dodgeChance;
    private int heal;
    private int ID;
    private static int IDCount = 0;


    public Jewlery(String name, String description, int critChance, int dodgeChance, int heal) {
        this.name = name;
        this.description = description;
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;
        this.heal = heal;
        this.ID = IDCount;
        IDCount++;
    }

    public int getID() {
        return ID;
    }

    public int getCritChance() {
        return critChance;
    }
}
