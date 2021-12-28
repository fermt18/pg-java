package com.fermt.pg.tictactoe;

public class Cell {

    private int xPos;
    private int yPos;
    private State state;

    int getxPos() { return xPos; }
    int getyPos() { return yPos; }
    public State getState(){ return state; }
    void setState(State state) { this.state = state; }

    Cell(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.state = State.BLANK;
    }
}
