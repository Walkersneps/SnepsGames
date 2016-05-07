package com.github.walkersneps.sneps.games.tictactoe.logic;

/**
 * Created by Walkersneps on 07/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.logic
 * for SnepsGames
 */


/**
 * @author Walkersneps
 */
public class WinReport {

    private byte winner;
    private boolean someoneWon;


    //default constructor
    public WinReport () {}

    //alternative contrusctor
    public WinReport (boolean hasSomeoneWon) {
        this.setSomeoneWon(hasSomeoneWon);
    }


    //getters
    public boolean isSomeoneWon () {
        return someoneWon;
    }

    public byte getWinner () {
        return winner;
    }


    //setters
    public void setSomeoneWon (boolean someoneWon) {
        this.someoneWon = someoneWon;
    }

    public void setWinner (byte winner) {
        this.winner = winner;
    }
} //end of class
