package Item;

public class Amor {
    private String name;
    private String description;
    private int defense;
    private int ID;
    private static int IDcount;

    public Amor(String name, String description, int defense) {
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
