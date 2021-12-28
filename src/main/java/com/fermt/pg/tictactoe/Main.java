package com.fermt.pg.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Board board = new Board();
        State nextMove = State.BLANK;
        while(board.checkWinner() == State.BLANK && board.stillBlankCellsRemaining()) {
            if( nextMove == State.CROSS ) nextMove = State.CIRCLE;
            else if( nextMove == State.CIRCLE) nextMove = State.CROSS;
            else nextMove = State.CROSS;
            System.out.println("Next Move : " + nextMove.toString());
            while(!board.nextMove(promptUser(), promptUser(), nextMove));
            board.print();
        }
        System.out.println("Game finished");
    }

    private static int promptUser(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
