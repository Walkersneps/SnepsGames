package com.github.walkersneps.sneps.games.tictactoe.player;

/**
 * Created by Walkersneps on 02/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.logic
 * for SnepsGames
 */


import com.github.walkersneps.sneps.games.tictactoe.board.TicTacToeBoard;
import com.github.walkersneps.sneps.games.tictactoe.logic.PossibleStrike;
import com.github.walkersneps.sneps.games.tictactoe.logic.prevision.PredictAll;
import com.github.walkersneps.sneps.games.tictactoe.logic.win.CheckAll;
import me.walkersneps.sneps.utils.convert.PrimitiveConverter;
import me.walkersneps.sneps.utils.random.Randomizer;

import java.io.IOException;

/**
 * @author Walkersneps
 */
public class Play {

    /**
     * Does the logic and executes a move
     *
     * @param board the board where to play
     * @param whoAmI either 1 or 2: 1 if computer is playing circles, 2 if computer is playing crosses
     * @return the board after the computer's move
     */
    public TicTacToeBoard nextMove (TicTacToeBoard board, byte whoAmI) {

        //check if we gave good arguments
        if (whoAmI != 1 && whoAmI != 2) {
            try {
                throw new IOException("Argument whoAmI must be of value 1 or 2");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PossibleStrike strike = PredictAll.predict(board);

        //check if someone has won
        if (CheckAll.checkAll(board).isSomeoneWon()) {
            board.setMatchEnded(true);
            return board;

        } else if (strike.amIInDanger()) { //the enemy or me (aka the computer) is close to win

            byte whereToMark = strike.getHowToStop(); //let's see where we should put our mark to stop the enemy -- or to win ;)

            board.write(whereToMark, whoAmI); //let's do it!
            return board;

        } else { //nothing much is going on

            byte whereToMark = PrimitiveConverter.intToByte(Randomizer.randomNumber(10));
            board.write(whereToMark, whoAmI);
            return board;
        }

    }














} //end of class
