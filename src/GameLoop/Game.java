package GameLoop;
import Units.Monster;
import Units.MonsterTypes;
import Units.Team;

import java.util.HashMap;
import java.util.Random;

public class Game {


    public void startGame() {
        Random random = new Random();
        HashMap<Integer, Monster> map = MonsterTypes.makeMonsters();

        Round r = new Round();
        Team t1 = new Team("Andreas");
        Team t2 = new Team("Jonas");
        t1.setCurrentMonster(map.get(1));
        t2.setCurrentMonster(map.get(2));
        r.fightLoop(t1,t2, random.nextLong());

    }



}
