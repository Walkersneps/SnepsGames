package com.github.walkersneps.sneps.games.tictactoe.board;

/**
 * Created by Walkersneps on 02/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.board
 * for SnepsGames
 */


/**
 * @author Walkersneps
 */
public class BoardSectionsConverters {

    public static byte[] firstColumnToBoard (byte[] firstColumn) {
        byte[] dBoard = new byte[9];

        dBoard[0] = firstColumn[0];
        dBoard[3] = firstColumn[1];
        dBoard[6] = firstColumn[2];

        return dBoard;
    }

    public static byte[] secondColumnToBoard (byte[] secondColumn) {
        byte[] dboard = new byte[9];

        dboard[1] = secondColumn[0];
        dboard[4] = secondColumn[1];
        dboard[7] = secondColumn[2];

        return dboard;
    }

    public static byte[] thirdColumnToBoard (byte[] thirdColumn) {
        byte[] dboard = new byte[9];

        dboard[2] = thirdColumn[0];
        dboard[5] = thirdColumn[1];
        dboard[8] = thirdColumn[2];

        return dboard;
    }

    public static byte[] backslashDiagonalToBoard (byte[] backslashDiagonal) {
        byte [] dboard = new byte[9];

        dboard[0] = backslashDiagonal[0];
        dboard[4] = backslashDiagonal[1];
        dboard[8] = backslashDiagonal[2];

        return dboard;
    }

    public static byte[] forwardslashDiagonalToBoard (byte[] forwardslashDiagonal) {
        byte [] dboard = new byte[9];

        dboard[2] = forwardslashDiagonal[0];
        dboard[4] = forwardslashDiagonal[1];
        dboard[6] = forwardslashDiagonal[2];

        return dboard;
    }


} //end of class




/*
 * A SAMPLE BOARD :)
 *
 *  0|1|2
 *  -|-|-
 *  3|4|5
 *  -|-|-
 *  6|7|8
 */

