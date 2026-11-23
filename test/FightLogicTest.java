import GameLoop.Round;
import Units.Monster;
import Units.MonsterTypes;
import Units.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FightLogicTest {
    HashMap<Integer, Monster> monsterMap;
    Team t1;
    Team t2;


    @BeforeEach
    void beforeEach() {
         monsterMap = MonsterTypes.makeMonsters();
         t1 = new Team("Andreas");
         t2 = new Team("Jonas");
         t1.setCurrentMonster(monsterMap.get(0));
         t2.setCurrentMonster(monsterMap.get(1));


     }

    @Test
    void checkFastWork() {
        Round f = new Round();

        f.determineAttackOrderBySpeed(monsterMap.get(0),monsterMap.get(1));
        assertEquals(f.getFast().getName(), monsterMap.get(1).getName());
    }


    @Test
    void checkWinner() {
        Round f = new Round();
            Monster winner =  f.fightLoop(t1, t2, 2L);
       assertEquals(winner, t1.getCurrentMonster());

    }



    }
