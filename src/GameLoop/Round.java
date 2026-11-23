package GameLoop;


import Units.Monster;
import Units.Team;
import Util.Text;

import java.util.Random;

public class Round {
    private Monster fast;
    private Monster slow;


    public Monster fightLoop(Team teamOne, Team teamTwo, Long seed) {
        determineAttackOrderBySpeed(teamOne.getCurrentMonster(), teamTwo.getCurrentMonster());
        Random random = new Random(seed);
        while(fast.getHp() > 0 && slow.getHp() > 0) {
            Long generate = random.nextLong();
            Text.showStatus(fast, slow);

            turn(fast,slow, generate);
            if(fast.hasWonVs(slow)) {
                return fast;
            }
            generate = random.nextLong();
            turn(slow,fast, generate);
        }
        return slow;

    }

    public void determineAttackOrderBySpeed(Monster a, Monster b) {
        if(a.getSpeed() > b.getSpeed()) {
            fast = a;
            slow = b;
            return;
        }
        if(a.getSpeed() == b.getSpeed()) {
            if((int) (Math.random() * 10) > 5) {
                fast = a;
                slow = b;
                return;
            }
        }
        fast = b;
        slow = a;
    }


   public void turn(Monster attacker, Monster defender, Long seed) {
       Text.combatText(attacker, defender);
       int damage = attacker.dealDmg(seed);
       attacker.attack(defender, damage);

   }

    public Monster getFast() {
        return fast;
    }
}



