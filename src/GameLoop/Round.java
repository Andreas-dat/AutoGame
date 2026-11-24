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


        while (fast.getCurrentHp() > 0 && slow.getCurrentHp() > 0) {
            Text.showStatus(fast, slow);
            turnSeed = random.nextLong();
            turnLog.add(Turn.turn(fast, slow, turnSeed, roundCount));
            roundCount++;

            if (fast.hasWonVs(slow)) {
                winner = fast;
                continue;
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


    public Monster[] determineOrderBySpeed(Monster monsterOne, Monster monsterTwo, Random random) {
        Monster[] monsterArray = new Monster[2];
        if (monsterOne.getSpeed() > monsterTwo.getSpeed()) {
            monsterArray[0] = monsterOne;
            monsterArray[1] = monsterTwo;
            return monsterArray;
        }
        if (monsterOne.getSpeed() == monsterTwo.getSpeed()) {

            int randomStarter = random.nextInt(2) + 1;
            if (2 == randomStarter) {
                monsterArray[0] = monsterOne;
                monsterArray[1] = monsterTwo;
                return monsterArray;
            }
        }
        monsterArray[0] = monsterTwo;
        monsterArray[1] = monsterOne;
        return monsterArray;
    }

    public ArrayList<Turn> getTurnLog() {
        return turnLog;
    }
}

