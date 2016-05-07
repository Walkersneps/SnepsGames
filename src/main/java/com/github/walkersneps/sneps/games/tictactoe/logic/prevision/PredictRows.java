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

/*
 *  0|1|2
 *  -|-|-
 *  3|4|5
 *  -|-|-
 *  6|7|8
 *
 *  An empty space is represented by value 0
 *  A circle is represented by value 1
 *  A cross is represented by value 2
 */

/**
 * Checks if there are 2 marks of the same type in a row
 */
class PredictRows {


    /**
     * Check if the enemy can win on next turn by completing a row
     * @param board the board to analyze
     * @return information on how to defend
     */
    static PossibleStrike predictPossibleRowStrike (TicTacToeBoard board) {

        if (predictFirstRow(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictFirstRow(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(board.getBoard()[predictFirstRow(board)]);
            return ps;

        } else if (predictSecondRow(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictSecondRow(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(board.getBoard()[predictSecondRow(board)]);
            return ps;

        } else if (predictThirdRow(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictThirdRow(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(board.getBoard()[predictThirdRow(board)]);
            return ps;

        } else {
            PossibleStrike ps = new PossibleStrike();
            ps.setIAmInDanger(false);

            return ps;
        }

    }




    /**
     * Checks if the enemy could win in next turn by placing a mark on first row
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the row index where to put a mark to avoid loosing
     */
    private static byte predictFirstRow (TicTacToeBoard board) {
        byte[] fr = board.getBoard();

        for (byte j = 0; j < 3; j++) {
            for (int k = j+1; k < 3; k++) {
                if (k!=j && fr[k] == fr[j] && fr[k]!=0) { //oh, we noticed someone could perform a tris!
                    byte almostWinner = fr[k]; //let's see who - crosses or circles?
                    for (byte aFr : fr) { //let's find the spot where we can put our mark and stop him!
                        if (aFr != almostWinner) {
                            return aFr;
                        }
                    }
                }
            }
        }

        return 10;
    }

    /**
     * Checks if the enemy could win in next turn by placing a mark on second row
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the row index where to put a mark to avoid loosing
     */
    private static byte predictSecondRow (TicTacToeBoard board) {
        byte[] sr = board.getBoard();

        for (byte j = 3; j < 6; j++) {
            for (int k = j+1; k < 6; k++) {
                if (k!=j && sr[k] == sr[j] && sr[k]!=0) { //oh, we noticed someone could perform a tris!
                    byte almostWinner = sr[k]; //let's see who - crosses or circles?
                    for (byte aSr : sr) { //let's find the spot where we can put our mark and stop him!
                        if (aSr != almostWinner) {
                            return aSr;
                        }
                    }
                }
            }
        }

        return 10;
    }

    /**
     * Checks if the enemy could win in next turn by placing a mark on third row
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the row index where to put a mark to avoid loosing
     */
    private static byte predictThirdRow (TicTacToeBoard board) {
        byte[] tr = board.getBoard();

        for (byte j = 6; j < 9; j++) {
            for (int k = j+1; k < 9; k++) {
                if (k!=j && tr[k] == tr[j] && tr[k]!=0) { //oh, we noticed someone could perform a tris!
                    byte almostWinner = tr[k]; //let's see who - crosses or circles?
                    for (byte aTr : tr) { //let's find the spot where we can put our mark and stop him!
                        if (aTr != almostWinner) {
                            return aTr;
                        }
                    }
                }
            }
        }

        return 10;
    }



























} //end of class
