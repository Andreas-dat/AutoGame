package GameLoop;

import Item.*;
import Units.Monster;
import Units.MonsterTypes;
import Units.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    Team t1;
    Team t2;
    Monster orc;
    Monster human;
    HashMap<Integer, Armor> amorMap;
    HashMap<Integer, Weapon> weaponMap;
    HashMap<Integer, Jewlery> jewleryMap;


    @BeforeEach
    void setUp() {
        HashMap<Integer, Monster> monsterMap = MonsterTypes.makeMonsters();
        amorMap = ArmorItems.makeAmor();
        weaponMap = WeaponItems.makeWeapons();
        jewleryMap = JewleryItems.makeJewlery();

        t1 = new Team("Andreas");
        t2 = new Team("Tanya");

        orc = monsterMap.get(0);
        human = monsterMap.get(1);

        t1.setCurrentMonster(orc);
        t2.setCurrentMonster(human);
    }

    @Test
    void teamTakeDamage() {
        orc.setJewlery(jewleryMap.get(1));

        int hpExpected = t2.getHp() - 10;

        Round round = new Round();
        round.fightLoop(t1,t2, 10L);

        int hpActual = t2.getHp();

        assertEquals(hpExpected, hpActual);
    }



}