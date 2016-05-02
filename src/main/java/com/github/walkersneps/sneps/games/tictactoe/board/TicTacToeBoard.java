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

    private static final Aliases u = new Aliases();

    //constructor
    /**
     * Builds a Tic-Tac-Toe board
     */
    public TicTacToeBoard () {
        board = new byte[9];
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


    //setters
    public void setBoard (byte[] board) {
        this.board = board;
    }








} //end of class
