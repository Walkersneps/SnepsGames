package com.github.walkersneps.sneps.games.tictactoe.marks;

/**
 * Created by Walkersneps on 02/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.marks
 * for SnepsGames
 */


import me.walkersneps.sneps.utils.lazy.aliases.PrintAlias;

/**
 * @author Walkersneps
 */
public class Marks {

    private static final byte circle = 1;
    private static final byte cross = 2;

    private byte currentMark;


    public void setMark (byte mark) {
        if (mark == 1 || mark == 2) {
            this.currentMark = mark;
        } else {
            PrintAlias.eprint("Error: enter '1' for circle or '2' for cross.");
        }
    }

    /**
     *
     * @return 1 for circle, 2 for cross, 0 for null
     */
    public byte getCurrentMark () {
        return currentMark;
    }


} //end of class
