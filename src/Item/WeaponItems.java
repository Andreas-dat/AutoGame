package Item;

import java.util.HashMap;

public enum WeaponItems {
    BASIC_IRON_SWORD(new Weapon("Basic iron sword", "A basic iron sword", 2, 100)),
    LONG_SWORD(new Weapon("Long sword", "A reaaaaaly long sword", 3, 100));

    private Weapon weapon;

    WeaponItems(Weapon weapon) {
        this.weapon = weapon;
    }


    public static HashMap<Integer, Weapon> makeWeapons() {
        HashMap<Integer, Weapon> weaponMap = new HashMap<>();

        int count = 0;
        for(WeaponItems w : WeaponItems.values()) {
            weaponMap.put(count, w.weapon);
            count++;
        }

        return weaponMap;


    }
}
