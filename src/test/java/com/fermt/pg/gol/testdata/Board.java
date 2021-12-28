package com.fermt.pg.gol.testdata;

public class Board {

    private boolean[][] initialBoard;
    private boolean[][] nextBoard;

    public boolean[][] getInitialBoard() {return initialBoard;}
    public boolean[][] getNextBoard() {return nextBoard;}

    public Board(boolean[][] initialBoard, boolean[][] nextBoard){
        this.initialBoard = initialBoard;
        this.nextBoard = nextBoard;
    }
}
