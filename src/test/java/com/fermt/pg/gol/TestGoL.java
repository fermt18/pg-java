package com.fermt.pg.gol;

import com.fermt.pg.gol.testdata.Board;
import com.fermt.pg.gol.testdata.BoardProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestGoL {

    @Test
    void init_empty_board(){
        GameOfLife gameOfLife = new GameOfLife(new boolean[][]{});
        assertArrayEquals(new boolean[][]{}, gameOfLife.getBoard());
    }

    @Test
    void init_non_empty_board(){
        boolean[][] board = {
                {false, false, false},
                {false, true, false},
                {false, false, false}};
        GameOfLife gameOfLife = new GameOfLife(board);
        assertArrayEquals(board, gameOfLife.getBoard());
    }

    @ParameterizedTest
    @ArgumentsSource(BoardProvider.class)
    void test_life_rules(Board board){
        System.out.println("Initial Board:");
        printBoard(board.getInitialBoard());
        System.out.println("Next Board:");
        printBoard(board.getNextBoard());
        GameOfLife gameOfLife = new GameOfLife(board.getInitialBoard());
        gameOfLife.nextGen();
        assertArrayEquals(board.getNextBoard(), gameOfLife.getBoard());
    }


    private void printBoard(boolean[][] board){
        for(int i=0; i<board.length; i++){
            System.out.println();
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + ", ");
            }
        }
        System.out.println();
    }

    @Test
    void test_iteration(){
        boolean[][] board = new boolean[][]{
                {true, false, false, true},
                {true, true, false, false},
                {true, true, true, false},
                {false, false, false, true}};

        GameOfLife gameOfLife = new GameOfLife(board);
        for(int i=0; i<10; i++) {
            gameOfLife.nextGen();
            printBoard(gameOfLife.getBoard());
        }
    }
}
