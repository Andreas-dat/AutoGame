import GameLoop.Game;
import GameLoop.Round;
import Units.Monster;
import Units.MonsterTypes;
import Units.Team;

import java.util.HashMap;

public class Main {

    public void main() {
        HashMap<Integer, Monster> map = MonsterTypes.makeMonsters();
        Team t1 = new Team("A");
        t1.setCurrentMonster(map.get(0));
        Team t2 = new Team("B");
        t2.setCurrentMonster(map.get(1));

        Game g = new Game();
        Game a = g.startGame(t1,t2);

        System.out.println(a.getWinner());


    }


}