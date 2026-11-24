package Item;

import java.util.HashMap;

public enum AmorItems {
    BARECHEST(new Amor("Bare chest", "Litteraly just your chest", 0)),
    GOLDHEALM(new Amor("Andreas", "2", 10)),
    DARKHEALM(new Amor("Helmet of Darkness", "A helmet made from the darkness", 6));



    private Amor amor;

    AmorItems(Amor amor) {
        this.amor = amor;
    }


    public HashMap<Integer, Amor> makeAmor() {
        HashMap<Integer, Amor> amorMap = new HashMap<>();

        for(AmorItems a : AmorItems.values()) {
            amorMap.put(a.amor.getID(),a.amor);
        }
        return amorMap;

    }

    public Amor getAmor() {
        return amor;
    }
}
