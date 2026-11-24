package Item;

public class Jewlery {
    private String name;
    private String description;
    private int critChance;
    private int dodgeChance;
    private int heal;


    public Jewlery(String name, String description, int critChance, int dodgeChance, int heal) {
        this.name = name;
        this.description = description;
        this.critChance = critChance;
        this.dodgeChance = dodgeChance;
        this.heal = heal;
    }
}
