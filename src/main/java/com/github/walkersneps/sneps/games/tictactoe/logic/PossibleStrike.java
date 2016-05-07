package com.github.walkersneps.sneps.games.tictactoe.logic;

/**
 * Created by Walkersneps on 02/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.logic
 * for SnepsGames
 */


/**
 * @author Walkersneps
 */
public class PossibleStrike {

    private byte whoCouldWin;
    private byte howToStop;
    private boolean IAmInDanger;


    //default empty constructor
    public PossibleStrike (){}

    //alternative constructor
    public  PossibleStrike (boolean isInDanger) {
        this.setIAmInDanger(isInDanger);
    }


    //getters
    public byte getHowToStop () {
        return howToStop;
    }

    public byte getWhoCouldWin () {
        return whoCouldWin;
    }

    public boolean amIInDanger () {
        return IAmInDanger;
    }


    //setters
    public void setHowToStop (byte howToStop) {
        this.howToStop = howToStop;
    }

    public void setWhoCouldWin (byte whoCouldWin) {
        this.whoCouldWin = whoCouldWin;
    }

    public void setIAmInDanger (boolean amIInDanger) {
        this.IAmInDanger = amIInDanger;
    }






} //end of class
