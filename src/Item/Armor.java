package Item;

public class Armor {
    private String name;
    private String description;
    private int defense;
    private int ID;
    private static int IDcount = 0;

    public Armor(String name, String description, int defense) {
        this.name = name;
        this.description = description;
        this.defense = defense;
        this.ID = IDcount;
        IDcount++;
    }

    public int getDefense() {
        return defense;
    }

    public int getID() {
        return ID;
    }
}
