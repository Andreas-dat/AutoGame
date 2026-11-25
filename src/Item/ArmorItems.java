package Item;

import java.util.HashMap;

public enum ArmorItems {
    BARECHEST(new Armor("Bare chest", "Litteraly just your chest", 0)),
    GOLDHEALM(new Armor("Andreas", "2", 10)),
    DARKHEALM(new Armor("Helmet of Darkness", "A helmet made from the darkness", 6));



    private Armor armor;

    ArmorItems(Armor armor) {
        this.armor = armor;
    }


    public static HashMap<Integer, Armor> makeAmor() {
        HashMap<Integer, Armor> amorMap = new HashMap<>();

        int count = 0;
        for(ArmorItems a : ArmorItems.values()) {
            amorMap.put(count,a.armor);
            count++;
        }
        return amorMap;

    }

    public Armor getAmor() {
        return armor;
    }
}
