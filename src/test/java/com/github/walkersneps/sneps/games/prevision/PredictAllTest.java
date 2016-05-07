package com.github.walkersneps.sneps.games.prevision;

/**
 * Created by Walkersneps on 07/05/16
 * in package com.github.walkersneps.sneps.games.prevision
 * for SnepsGames
 */


import com.github.walkersneps.sneps.games.tictactoe.board.TicTacToeBoard;
import com.github.walkersneps.sneps.games.tictactoe.logic.prevision.PredictAll;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Walkersneps
 */
public class PredictAllTest {

    private final TicTacToeBoard board = new TicTacToeBoard();

    private static final byte[] ALMOST_COLUMN_STRIKE =   {1, 0, 2,
                                                          0, 2, 0,
                                                          1, 1, 0};

    private static final byte[] ALMOST_ROW_STRIKE =      {0, 2, 1,
                                                          2, 0, 2,
                                                          1, 0, 0};

    private static final byte[] ALMOST_DIAGONAL_STRIKE = {1, 1, 2,
                                                          2, 1, 0,
                                                          0, 2, 0};

    private static final byte[] NOTHING_MUCH =           {0, 1, 2,
                                                          2, 0, 1,
                                                          0, 0, 0};


    @Test
    public void predictTest () {
        System.out.println("Starting testing of method 'predict()' in class PredictAll");


        board.setBoard(ALMOST_COLUMN_STRIKE);
        System.out.println("Board is: ");
        for (int i=0; i<board.getNiceBoard().length; i++) {
            System.out.println(board.getNiceBoard()[i]);
        }
        System.out.println();
        assertEquals(PredictAll.predict(board).getHowToStop(), 3);

        board.setBoard(ALMOST_ROW_STRIKE);
        System.out.println("Board is: ");
        for (int i=0; i<board.getNiceBoard().length; i++) {
            System.out.println(board.getNiceBoard()[i]);
        }
        System.out.println();
        assertEquals(PredictAll.predict(board).getHowToStop(), 4);

        board.setBoard(ALMOST_DIAGONAL_STRIKE);
        System.out.println("Board is: ");
        for (int i=0; i<board.getNiceBoard().length; i++) {
            System.out.println(board.getNiceBoard()[i]);
        }
        System.out.println();
        assertEquals(PredictAll.predict(board).getHowToStop(), 8);

        board.setBoard(NOTHING_MUCH);
        System.out.println("Board is: ");
        for (int i=0; i<board.getNiceBoard().length; i++) {
            System.out.println(board.getNiceBoard()[i]);
        }
        System.out.println();
        assertEquals(PredictAll.predict(board).amIInDanger(), false);


        System.out.println("Done!");
        System.out.println();
    }






    /*
     *  0|1|2
     *  -|-|-
     *  3|4|5
     *  -|-|-
     *  6|7|8
     */


} //end of class
