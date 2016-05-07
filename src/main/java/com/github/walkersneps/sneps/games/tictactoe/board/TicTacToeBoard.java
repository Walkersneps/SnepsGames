package com.github.walkersneps.sneps.games.tictactoe.board;

/**
 * Created by Walkersneps on 02/05/16
 * in package com.github.walkersneps.sneps.games.tictactoe.board
 * for SnepsGames
 */


import me.walkersneps.sneps.utils.lazy.Aliases;

/**
 * @author Walkersneps
 */

/**
 * How the board positions are placed:
 *
 *  0|1|2
 *  -|-|-
 *  3|4|5
 *  -|-|-
 *  6|7|8
 *
 *
 *  An empty space is represented by value 0
 *  A circle is represented by value 1
 *  A cross is represented by value 2
 */
public class TicTacToeBoard {

    private byte[] board;

    private boolean matchEnded;

    private static final Aliases u = new Aliases();

    //constructor
    /**
     * Builds a Tic-Tac-Toe board
     */
    public TicTacToeBoard () {
        board = new byte[9];
        this.matchEnded = false;
    }



    /**
     * Writes a mark in the board
     *
     * @param position position of the space to write in
     * @see TicTacToeBoard
     * @param mark one of either 1 or 2: 1 is a circle, 2 is a cross
     * @return the updated board
     */
    public TicTacToeBoard write (byte position, byte mark) {
        if (0 <= position && position <= 8) {
            if (mark == 1 || mark == 2) {
                board[position] = mark;
            } else { //mark isn't 1 nor 2
                u.p("Error: mark must be either '1' or '2', where '1' represents a circle and '2' represents a cross!");
            }
        } else { //position is too big/small
            u.p("Error: position must be a value between 0 and 8, included!");
        }

        return this;
    }

    /**
     * Clears a space in the board, setting its value to '0'
     *
     * @param position position of the space to erase
     * @see TicTacToeBoard
     * @return the updated board
     */
    public TicTacToeBoard erase (byte position) {
        if (position >= 0 && position <= 8) {
            board[position] = 0;
        }
        return this;
    }

    /**
     * Resets the board, erasing every space in it
     *
     * @return the cleared board
     */
    public TicTacToeBoard resetBoard () {
        //clear the board
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
        }

        return this;
    }



    //checkers
    /**
     * Check if a space is empty
     *
     * @param position position of the space to check
     * @see TicTacToeBoard
     * @return true if the space is empty, false if it isn't
     */
    public boolean isEmpty (byte position) {
        return board[position] == 0;
    }

    /**
     * Check if a space has a mark written in it
     *
     * @param position position of the space to check
     * @see TicTacToeBoard
     * @return true if the space is already occupied by a mark, false if it's empty
     */
    public boolean isWritten (byte position) {
        return board[position] != 0;
    }

    public boolean isMatchEnded () {
        return matchEnded;
    }



    //getters
    public byte[] getBoard () {
        return board;
    }

    public byte[] getFirstRow () {

        byte[] firstRow = new byte[3];

        System.arraycopy(board, 0, firstRow, 0, 3);

        return firstRow;
    }

    public byte[] getSecondRow () {

        byte[] secondRow = new byte[3];

        System.arraycopy(board, 3, secondRow, 0, 3);

        return secondRow;
    }

    public byte[] getThirdRow () {

        byte[] thirdRow = new byte[3];

        System.arraycopy(board, 6, thirdRow, 0, 3);

        return thirdRow;
    }

    public byte[] getFirstColumn () {
        byte[] firstColumn = new byte[3];

        firstColumn[0] = board[0];
        firstColumn[1] = board[3];
        firstColumn[2] = board[6];

        return firstColumn;
    }

    public byte[] getSecondColumn () {
        byte[] secondColumn = new byte[3];

        secondColumn[0] = board[1];
        secondColumn[1] = board[4];
        secondColumn[2] = board[7];

        return secondColumn;
    }

    public byte[] getThirdColumn () {
        byte[] thirdColumn = new byte[3];

        thirdColumn[0] = board[2];
        thirdColumn[1] = board[5];
        thirdColumn[2] = board[8];

        return thirdColumn;
    }

    public byte[] getBackslashDiagonal () {
        byte[] backslashDiagonal = new byte[3];

        backslashDiagonal[0] = board[0];
        backslashDiagonal[1] = board[4];
        backslashDiagonal[2] = board[8];

        return backslashDiagonal;
    }

    public byte[] getForwardslashDiagonal () {
        byte[] forwardslashDiagonal = new byte[3];

        forwardslashDiagonal[0] = board[2];
        forwardslashDiagonal[1] = board [4];
        forwardslashDiagonal[2] = board[6];

        return forwardslashDiagonal;
    }


    public String[] getNiceBoard () {
        String[] nb = new String[5];

        //prepare first line
        StringBuilder firstLine = new StringBuilder();
        for (int i=0; i<3; i++) {
            firstLine.append(this.getFirstRow()[i]);
            if (i != 2) {
                firstLine.append("|");
            }
        }

        nb[0] = firstLine.toString(); //add first line to the array
        nb[1] = "-|-|-";

        //prepare second line
        StringBuilder secondLine = new StringBuilder();
        for (int i=0; i<3; i++) {
            secondLine.append(this.getSecondRow()[i]);
            if (i != 2) {
                secondLine.append("|");
            }
        }

        nb[2] = secondLine.toString(); //add second line to the array
        nb[3] = "-|-|-";

        //prepare third line
        StringBuilder thirdLine = new StringBuilder();
        for (int i=0; i<3; i++) {
            thirdLine.append(this.getThirdRow()[i]);
            if (i != 2) {
                thirdLine.append("|");
            }
        }

        nb[4] = thirdLine.toString(); //add third line to the array

        return nb;
    }


    //setters
    public void setBoard (byte[] board) {
        this.board = board;
    }

    public void setMatchEnded (boolean matchEnded) {
        this.matchEnded = matchEnded;
    }



} //end of class

    /*
     *  0|1|2
     *  -|-|-
     *  3|4|5
     *  -|-|-
     *  6|7|8
     */















