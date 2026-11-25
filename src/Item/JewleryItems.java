package Item;

import java.util.HashMap;

public enum JewleryItems {
    NECKLACE(new Jewlery("CritNecklace", "this thing makes your crit like crazy", 1,2,1)),
    DODGERING(new Jewlery("RING OF DODGE", "This is doding you", 0,10,0));

    private Jewlery jewlery;

    JewleryItems(Jewlery jewlery) {
        this.jewlery = jewlery;
    }


    public static HashMap<Integer,Jewlery> makeJewlery() {
        int count = 0;

        HashMap<Integer, Jewlery> jewleryMap = new HashMap<>();
        for(JewleryItems j : JewleryItems.values()) {
            jewleryMap.put(count, j.jewlery);
            count++;
        }
        return jewleryMap;

    }
}
