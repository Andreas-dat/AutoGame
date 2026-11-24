package Item;

import java.util.HashMap;

public enum JewleryIteams {
    NECKLACE(new Jewlery("CritNecklace", "this thing makes your crit like crazy", 1,2,1));

    private Jewlery jewlery;

    JewleryIteams(Jewlery jewlery) {
        this.jewlery = jewlery;
    }


    public HashMap<Integer,Jewlery> makeJewlery() {

        HashMap<Integer, Jewlery> jewleryMap = new HashMap<>();
        for(JewleryIteams j : JewleryIteams.values()) {
            jewleryMap.put(j.jewlery.getID(), j.jewlery);
        }
        return jewleryMap;

    }
}
