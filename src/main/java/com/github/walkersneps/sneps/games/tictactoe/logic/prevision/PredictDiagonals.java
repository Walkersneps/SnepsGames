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
class PredictDiagonals {


    /**
     * Check if the enemy can win on next turn by completing a diagonal
     * @param board the board to analyze
     * @return information on how to defend
     */
    static PossibleStrike predictPossibleDiagonalStrike (TicTacToeBoard board) {

        if (predictForwardslashDiagonal(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictForwardslashDiagonal(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(board.getBoard()[predictForwardslashDiagonal(board)]);
            return ps;

        } else if (predictBackslashDiagonal(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictBackslashDiagonal(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(board.getBoard()[predictBackslashDiagonal(board)]);
            return ps;

        } else {
            PossibleStrike ps = new PossibleStrike();
            ps.setIAmInDanger(false);

            return ps;
        }


    }







    /**
     * Checks if the enemy could win in next turn by placing a mark on forwardslash diagonal
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the board index where to put a mark to avoid loosing
     */
    private static byte predictForwardslashDiagonal (TicTacToeBoard board) {
        byte[] fd = board.getForwardslashDiagonal();

        for (byte j = 0; j < 3; j++) {
            for (int k = j + 1; k < 3; k++) {
                if (k != j && fd[k] == fd[j] && k!=0) { //oh, we noticed someone could perform a tris!
                    byte position = 10;
                    byte whereToBlock = 10;

                    for (byte c = 0; c < fd.length; c++) {
                        if (fd[c] == 0) {
                            whereToBlock = c;
                        }
                    }

                    if (whereToBlock == 0) {
                        position = 0;
                    } else if (whereToBlock == 1) {
                        position = 4;
                    } else if (whereToBlock == 2) {
                        position = 8;
                    }

                    return position;
                }
            }
        }

        return 10;
    }

    /**
     * Checks if the enemy could win in next turn by placing a mark on backslash diagonal
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the board index where to put a mark to avoid loosing
     */
    private static byte predictBackslashDiagonal (TicTacToeBoard board) {
        byte[] bd = board.getForwardslashDiagonal();

        for (byte j = 0; j < 3; j++) {
            for (int k = j + 1; k < 3; k++) {
                if (k != j && bd[k] == bd[j] && k!=0) { //oh, we noticed someone could perform a tris!
                    byte position = 10;
                    byte whereToBlock = 10;

                    for (byte c = 0; c < bd.length; c++) {
                        if (bd[c] == 0) {
                            whereToBlock = c;
                        }
                    }

                    if (whereToBlock == 0) {
                        position = 2;
                    } else if (whereToBlock == 1) {
                        position = 4;
                    } else if (whereToBlock == 2) {
                        position = 6;
                    }

                    return position;
                }
            }
        }

        return 10;
    }


} //end of class

/*
        *  0|1|2
        *  -|-|-
        *  3|4|5
        *  -|-|-
        *  6|7|8
        */
