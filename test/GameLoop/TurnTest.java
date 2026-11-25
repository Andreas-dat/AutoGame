package GameLoop;

import Units.Monster;
import Units.MonsterTypes;
import Units.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {
    Team t1;
    Team t2;
    Monster orc;
    Monster human;
    Round r;
    Game g;


    @BeforeEach
    void setUp() {
        HashMap<Integer, Monster> monsterMap = MonsterTypes.makeMonsters();

        t1 = new Team("Andreas");
        t2 = new Team("Tanya");

        orc = monsterMap.get(0);
        human = monsterMap.get(1);

        r = new Round();
        g = new Game();

        t1.setCurrentMonster(orc);
        t2.setCurrentMonster(human);

    }

    @Test
    void turn() {
        int hp = human.getMaxHp();
        Turn.turn(orc,human,10L,4);

        assertNotEquals(hp,human.getCurrentHp());
    }
    @Test
    void dmg() {
        int damage = orc.attack(human, 10L);
        int normal = orc.getDamage() * 2;

        assertEquals(damage, normal);
    }


    @Test
    void takeDamage() {
        int damage = orc.attack(human, 10L);

        assertEquals(human.getMaxHp() - damage, human.getCurrentHp());

    }

    @Test
    void orderTest() {
       Monster[] array = r.determineOrderBySpeed(human,orc,new Random());

       assertEquals(array[0].getName(), human.getName());
    }

    @Test
    void turnArray() {
        setUp();
        Round q = r.fightLoop(t1,t2,10L);

        Game z = g.startGame(t1,t2);

        assertEquals(z.getRounds().getFirst().getTurnLog().size(), q.getTurnLog().size());






    }





}