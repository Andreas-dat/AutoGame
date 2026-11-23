package Units;

import java.util.HashMap;

public enum MonsterTypes {
    ORC(new Monster("Orc", 5,20,100,2)),
    HUMAN(new Monster("Human,",3,30,100, 4));


    private Monster monster;

    MonsterTypes(Monster monster) {
        this.monster = monster;

    }


    public static HashMap<Integer, Monster> makeMonsters() {
        HashMap<Integer, Monster> map = new HashMap<>();
        int id = 0;

        for (MonsterTypes m : MonsterTypes.values()) {
            map.put(id, m.monster);
            id++;
        }
        return map;
    }

    public Monster getMonster() {
        return monster;
    }
}
