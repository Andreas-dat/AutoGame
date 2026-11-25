package GameLoop;
import Units.Team;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Round> rounds;
    private Team winner;

    public Game() {
        rounds = new ArrayList<>();
    }

    public Game(Team winner, ArrayList<Round> rounds) {
        this.winner = winner;
        this.rounds = rounds;
    }


    public Game startGame(Team teamOne, Team teamTwo) {
        Random random = new Random();
        while(teamOne.getHp() > 0 && teamTwo.getHp() > 0 ) {
            Round round = new Round();
            rounds.add(round.fightLoop(teamOne,teamTwo, random.nextLong() ));
        }
        if(teamOne.getHp() > 0) {
            winner = teamOne;
        }
        else {
            winner = teamTwo;
        }
        return new Game(winner, rounds);

    }


    public Team getWinner() {
        return winner;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }
}



