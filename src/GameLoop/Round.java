package GameLoop;


import Units.Monster;
import Units.Team;
import Util.Text;

import java.util.ArrayList;
import java.util.Random;

public class Round {
    private Monster winner;
    private ArrayList<Turn> turnLog;
    private int roundID;
    private static int roundIDCount;

    public Round(Monster winner, ArrayList<Turn> turnLog) {
        this.winner = winner;
        this.turnLog = turnLog;
        this.roundID = roundIDCount;
        roundIDCount++;
    }

    public Round() {}


    public Round fightLoop(Team teamOne, Team teamTwo, Long roundSeed) {
        turnLog = new ArrayList<>();

        int roundCount = 0;
        Random random = new Random(roundSeed);
        Long turnSeed;
        Monster[] monsterArray = determineOrderBySpeed(teamOne.getCurrentMonster(), teamTwo.getCurrentMonster(), random);
        for(Monster m : monsterArray) {
            m.fullHeal();
        }
        Monster fast = monsterArray[0]; //REMINDER: 0 = fast;
        Monster slow = monsterArray[1]; //REMINDER 1 = slow;


        while (fast.getHp() > 0 && slow.getHp() > 0) {
            Text.showStatus(fast, slow);
            turnSeed = random.nextLong();
            turnLog.add(Turn.turn(fast, slow, turnSeed, roundCount));
            roundCount++;

            if (fast.hasWonVs(slow)) {
                winner = fast;
            }
            turnSeed = random.nextLong();
            turnLog.add(Turn.turn(slow, fast, turnSeed, roundCount));
            winner = slow;
        }
        return endRound(winner, teamOne, teamTwo);
    }


    public Round endRound(Monster winner, Team teamOne, Team teamTwo) {
        if (teamTwo.getCurrentMonster().getName().equals(winner.getName())) {
            teamOne.loseRound(10); //TODO: Make algorithm for how much health a team should loose
        } else {
            teamTwo.loseRound(10);
        }
        return new Round(winner, turnLog);
    }


    public Monster[] determineOrderBySpeed(Monster a, Monster b, Random random) {
        Monster[] monsterArray = new Monster[2];
        if (a.getSpeed() > b.getSpeed()) {
            monsterArray[0] = a;
            monsterArray[1] = b;
            return monsterArray;
        }
        if (a.getSpeed() == b.getSpeed()) {

            int randomStarter = random.nextInt(2) + 1;
            if (2 == randomStarter) {
                monsterArray[0] = a;
                monsterArray[1] = b;
                return monsterArray;
            }
        }
        monsterArray[0] = b;
        monsterArray[1] = a;
        return monsterArray;
    }
}

