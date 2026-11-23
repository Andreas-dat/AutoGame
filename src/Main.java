import GameLoop.Round;
import Units.Monster;
import Units.MonsterTypes;
import Units.Team;

import java.util.HashMap;

public class Main {

    public void main() {
        HashMap<Integer, Monster> map = MonsterTypes.makeMonsters();
        Round f = new Round();
        Team t1 = new Team("A");
        t1.setCurrentMonster(map.get(0));
        Team t2 = new Team("B");

        t2.setCurrentMonster(map.get(1));


       Monster winner = f.fightLoop(t1,t2, 10L);
       System.out.println(winner.getName());
    }


}