import GameLoop.Game;
import Units.Monster;
import Units.MonsterTypes;
import Units.Team;

import java.util.HashMap;

public class Main {

    public void main() {

        HashMap<Integer, Monster> map = MonsterTypes.makeMonsters();

        Team t1 = new Team("Andreas");
        t1.setCurrentMonster(map.get(0));
        Monster a = new Monster(map.get(0));
        Team t2 = new Team("Tanya");
        t2.setCurrentMonster(a);


        Game g = new Game();
        Game d = g.startGame(t1,t2);



        System.out.println(d.getWinner());

    }
}