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
class CheckRows {

    static WinReport winOnRow (TicTacToeBoard board) {
        WinReport r = new WinReport();

        if (winOnFirstRow(board).isSomeoneWon()) {
            r.setSomeoneWon(true);
            r.setWinner(board.getBoard()[0]);
            return r;

        } else if (winOnSecondRow(board).isSomeoneWon()) {
            r.setSomeoneWon(true);
            r.setWinner(board.getBoard()[3]);
            return r;

        } else if (winOnThirdRow(board).isSomeoneWon()) {
            r.setSomeoneWon(true);
            r.setWinner(board.getBoard()[6]);
            return r;

        } else {
            r.setSomeoneWon(false);
            return r;
        }
    }




    private static WinReport winOnFirstRow (TicTacToeBoard board) {
        byte[] row = board.getFirstRow();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(row)) {
            report.setSomeoneWon(true);
            report.setWinner(row[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }

    private static WinReport winOnSecondRow (TicTacToeBoard board) {
        byte[] row = board.getSecondRow();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(row)) {
            report.setSomeoneWon(true);
            report.setWinner(row[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }

    private static WinReport winOnThirdRow (TicTacToeBoard board) {
        byte[] row = board.getThirdRow();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(row)) {
            report.setSomeoneWon(true);
            report.setWinner(row[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }


} //end of class
