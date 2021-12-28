package com.fermt.pg.gol;

import java.util.stream.IntStream;

public class GameOfLife {

    private boolean[][] board;

    public GameOfLife(boolean[][] board){ this.board = board; }

    public boolean[][] getBoard(){
        return board;
    }

    public void nextGen(){
        boolean[][] nextBoard = new boolean[board.length][board[0].length];
        //for(int posY=0; posY<board.length; posY++) {
        IntStream.range(0, board.length).forEach(posY -> {
            //for (int posX = 0; posX < board[posY].length; posX++) {
            IntStream.range(0, board[posY].length).forEach(posX -> {
                nextBoard[posY][posX] = isCellAlive(posY, posX);
            });
        });
        board = nextBoard;
    }

    private boolean isCellAlive(int posY, int posX){
        int surroundingLivingCells = 0;
        if(isSurroundingCellAlive(posY, posX-1))
            surroundingLivingCells++;
        if(isSurroundingCellAlive(posY, posX+1))
            surroundingLivingCells++;
        if(isSurroundingCellAlive(posY-1, posX))
            surroundingLivingCells++;
        if(isSurroundingCellAlive(posY+1, posX))
            surroundingLivingCells++;
        if(isSurroundingCellAlive(posY-1, posX-1))
            surroundingLivingCells++;
        if(isSurroundingCellAlive(posY+1, posX-1))
            surroundingLivingCells++;
        if(isSurroundingCellAlive(posY-1, posX+1))
            surroundingLivingCells++;
        if(isSurroundingCellAlive(posY+1, posX+1))
            surroundingLivingCells++;

        if(board[posY][posX]) {
            if (surroundingLivingCells == 2 || surroundingLivingCells == 3)
                return true;
        }
        else{
            if(surroundingLivingCells == 3)
                return true;
        }
        return false;
    }

    private boolean isSurroundingCellAlive(int posY, int posX){
        try{
            return board[posY][posX];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
}
