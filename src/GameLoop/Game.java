package GameLoop;
import Units.Team;

import javax.xml.namespace.QName;
import java.util.ArrayList;

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
        while(teamOne.getHp() > 0 && teamTwo.getHp() > 0 ) {
            Round round = new Round();
            rounds.add(round.fightLoop(teamOne,teamTwo, 10L));
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

}



