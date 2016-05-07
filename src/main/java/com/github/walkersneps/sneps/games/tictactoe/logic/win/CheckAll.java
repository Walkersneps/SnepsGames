package com.github.walkersneps.sneps.games.tictactoe.logic.win;

/**
 * Created by Walkersneps on 07/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.logic.win
 * for SnepsGames
 */


import com.github.walkersneps.sneps.games.tictactoe.board.TicTacToeBoard;
import com.github.walkersneps.sneps.games.tictactoe.logic.WinReport;

/**
 * @author Walkersneps
 */
public class CheckAll {

    public static WinReport checkAll (TicTacToeBoard board) {

        if (CheckDiagonals.winOnDiagonal(board).isSomeoneWon()) { //someone won by a diagonal strike
            return CheckDiagonals.winOnDiagonal(board);

        } else if (CheckRows.winOnRow(board).isSomeoneWon()) { //someone won by a row strike
            return CheckRows.winOnRow(board);

        } else if (CheckColumns.winOnColumn(board).isSomeoneWon()) { //someone won by a column strike
            return CheckColumns.winOnColumn(board);

        } else {
            return new WinReport(false);
        }
    }






} //end of class
