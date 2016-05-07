package com.github.walkersneps.sneps.games.tictactoe.logic.prevision;

/**
 * Created by Walkersneps on 02/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.logic.prevision
 * for SnepsGames
 */


import com.github.walkersneps.sneps.games.tictactoe.board.TicTacToeBoard;
import com.github.walkersneps.sneps.games.tictactoe.logic.PossibleStrike;

/**
 * @author Walkersneps
 */
public class PredictAll {


    /**
     * Predict if the enemy could win on next turn
     *
     * @param board the board to analyze
     * @return information on how to defend
     */
    public static PossibleStrike predict (TicTacToeBoard board) {

        if (PredictRows.predictPossibleRowStrike(board).amIInDanger()) { //a row strike could happen
            return PredictRows.predictPossibleRowStrike(board);

        } else if (PredictColumns.predictPossibleColumnStrike(board).amIInDanger()) { //a column strike could happen
            return PredictColumns.predictPossibleColumnStrike(board);

        } else if (PredictDiagonals.predictPossibleDiagonalStrike(board).amIInDanger()) { //a diagonal strike could happen
            return PredictDiagonals.predictPossibleDiagonalStrike(board);

        } else {
            return new PossibleStrike(false);

        }
    }






} //end of class
