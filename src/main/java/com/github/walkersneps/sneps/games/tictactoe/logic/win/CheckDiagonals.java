package com.github.walkersneps.sneps.games.tictactoe.logic.win;

/**
 * Created by Walkersneps on 02/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.logic.win
 * for SnepsGames
 */


import com.github.walkersneps.sneps.games.tictactoe.board.TicTacToeBoard;
import com.github.walkersneps.sneps.games.tictactoe.logic.WinReport;
import me.walkersneps.sneps.utils.check.duplicate.ByteArrayCheck;


/**
 * @author Walkersneps
 */
class CheckDiagonals {


    static WinReport winOnDiagonal (TicTacToeBoard board) {
        WinReport r = new WinReport();

        if (winOnForwardslashDiagonal(board).isSomeoneWon() || winOnBackslashDiagonal(board).isSomeoneWon()) {
            r.setSomeoneWon(true);
            r.setWinner(board.getBoard()[4]);
            return r;

        } else {
            r.setSomeoneWon(false);
            return r;
        }
    }









    private static WinReport winOnBackslashDiagonal (TicTacToeBoard board) {
        byte[] diagonal = board.getBackslashDiagonal();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(diagonal)) {
            report.setSomeoneWon(true);
            report.setWinner(diagonal[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }

    private static WinReport winOnForwardslashDiagonal (TicTacToeBoard board) {
        byte[] diagonal = board.getForwardslashDiagonal();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(diagonal)) {
            report.setSomeoneWon(true);
            report.setWinner(diagonal[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }



} //end of class
