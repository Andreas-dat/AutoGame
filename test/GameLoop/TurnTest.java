package GameLoop;

import Units.Monster;
import Units.MonsterTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    Monster m1;
    Monster m2;
    @BeforeEach
    void setUp() {
        HashMap<Integer, Monster> monsterMap = MonsterTypes.makeMonsters();

        m1 = monsterMap.get(0);
         m2 = monsterMap.get(1);

    }

    @Test
    void turn() {
        setUp();
        int hp = m2.getHp();
        Turn.turn(m1,m2,10L,4);

        assertNotEquals(hp,m2.getCurrentHp());
    }


    @Test
    void dmg() {
        setUp();
        int damage = m1.dealDmg(10L);
        int normal = m1.getDamage() * 2;

        assertEquals(damage, normal);
    }


    @Test
    void takeDamage() {
        setUp();

        int damage = m1.dealDmg(10L);

        m1.attack(m2, damage);

        assertEquals(m2.getHp() - damage, m2.getCurrentHp());


    }


}