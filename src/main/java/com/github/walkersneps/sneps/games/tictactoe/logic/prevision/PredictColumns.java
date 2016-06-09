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
class PredictColumns {

    private static byte whoCouldWin;


    /**
     * Check if the enemy can win on next turn by completing a column
     * @param board the board to analyze
     * @return information on how to defend
     */
    static PossibleStrike predictPossibleColumnStrike (TicTacToeBoard board) {

        if (predictFirstColumn(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictFirstColumn(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(whoCouldWin);

            return ps;
        } else if (predictSecondColumn(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictSecondColumn(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(whoCouldWin);

            return ps;
        } else if (predictThirdColumn(board) < 9) { //possible strike on first row
            PossibleStrike ps = new PossibleStrike();
            ps.setHowToStop(predictThirdColumn(board));
            ps.setIAmInDanger(true);
            ps.setWhoCouldWin(whoCouldWin);

            return ps;
        } else {
            PossibleStrike ps = new PossibleStrike();
            ps.setIAmInDanger(false);

            return ps;
        }


    }


    /**
     * Checks if the enemy could win in next turn by placing a mark on first column
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the board index where to put a mark to avoid loosing
     */
    private static byte predictFirstColumn (TicTacToeBoard board) {
        byte[] fc = board.getFirstColumn();

        for (byte j = 0; j < 3; j++) {
            for (int k = j+1; k < 3; k++) {
                if (k!=j && fc[k] == fc[j] && fc[k]!=0) { //oh, we noticed someone could perform a tris!
                    whoCouldWin = fc[k];
                    byte position = 10;
                    byte whereToBlock = 10;

                    for (byte c=0; c < fc.length; c++) {
                        if (fc[c] == 0) {
                            whereToBlock = c;
                        }
                    }

                    if (whereToBlock == 0) {
                        position = 0;
                    } else if (whereToBlock == 1) {
                        position = 3;
                    } else if (whereToBlock == 2) {
                        position = 6;
                    }

                    return position;
                }
            }
        }

        return 10;
    }

    /**
     * Checks if the enemy could win in next turn by placing a mark on second column
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the board index where to put a mark to avoid loosing
     */
    private static byte predictSecondColumn (TicTacToeBoard board) {
        byte[] sc = board.getSecondColumn();

        for (byte j = 0; j < 3; j++) {
            for (int k = j+1; k < 3; k++) {
                if (k!=j && sc[k] == sc[j] && sc[k]!=0) { //oh, we noticed someone could perform a tris!
                    whoCouldWin = sc[k];
                    byte position = 10;
                    byte whereToBlock = 10;

                    for (byte c=0; c < sc.length; c++) {
                        if (sc[c] == 0) {
                            whereToBlock = c;
                        }
                    }

                    if (whereToBlock == 0) {
                        position = 1;
                    } else if (whereToBlock == 1) {
                        position = 4;
                    } else if (whereToBlock == 2) {
                        position = 7;
                    }
                    return position;
                }
            }
        }

        return 10;
    }

    /**
     * Checks if the enemy could win in next turn by placing a mark on third column
     *
     * @param board the board to check
     * @return '10' if there's no danger, or the board index where to put a mark to avoid loosing
     */
    private static byte predictThirdColumn (TicTacToeBoard board) {
        byte[] tc = board.getSecondColumn();

        for (byte j = 0; j < 3; j++) {
            for (int k = j+1; k < 3; k++) {
                if (k!=j && tc[k] == tc[j] && tc[k]!=0) { //oh, we noticed someone could perform a tris!
                    whoCouldWin = tc[k];
                    byte position = 10;
                    byte whereToBlock = 10;

                    for (byte c=0; c < tc.length; c++) {
                        if (tc[c] == 0) {
                            whereToBlock = c;
                        }
                    }

                    if (whereToBlock == 0) {
                        position = 2;
                    } else if (whereToBlock == 1) {
                        position = 5;
                    } else if (whereToBlock == 2) {
                        position = 8;
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

