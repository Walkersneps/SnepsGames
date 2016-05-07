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
class CheckColumns {

    static WinReport winOnColumn (TicTacToeBoard board) {
        WinReport r = new WinReport();

        if (winOnFirstColumn(board).isSomeoneWon()) {
            r.setSomeoneWon(true);
            r.setWinner(board.getBoard()[0]);
            return r;

        } else if (winOnSecondColumn(board).isSomeoneWon()) {
            r.setSomeoneWon(true);
            r.setWinner(board.getBoard()[1]);
            return r;

        } else if (winOnThirdColumn(board).isSomeoneWon()) {
            r.setSomeoneWon(true);
            r.setWinner(board.getBoard()[2]);
            return r;

        } else {
            r.setSomeoneWon(false);
            return r;
        }
    }




    private static WinReport winOnFirstColumn (TicTacToeBoard board) {
        byte[] column = board.getFirstColumn();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(column)) {
            report.setSomeoneWon(true);
            report.setWinner(column[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }

    private static WinReport winOnSecondColumn (TicTacToeBoard board) {
        byte[] column = board.getSecondColumn();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(column)) {
            report.setSomeoneWon(true);
            report.setWinner(column[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }

    private static WinReport winOnThirdColumn (TicTacToeBoard board) {
        byte[] column = board.getThirdColumn();
        WinReport report = new WinReport();

        if (ByteArrayCheck.areAllSame(column)) {
            report.setSomeoneWon(true);
            report.setWinner(column[1]);
            return report;

        } else {
            report.setSomeoneWon(false);
            return report;
        }
    }


} //end of class
