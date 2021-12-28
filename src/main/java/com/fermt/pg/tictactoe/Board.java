package com.fermt.pg.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Board {

    private static final Logger logger = LoggerFactory.getLogger(Board.class);

    private List<Cell> cellList;
    private State lastStatePlayed;

    public Board(){
        initBoard();
        lastStatePlayed = null;
    }

    public boolean nextMove(int xPos, int yPos, State state) {
        if(xPos > 2 || yPos > 2){
            logger.warn("Cell position out of range");
            return false;}

        if(state == null || state == State.BLANK) {
            logger.warn("Cell state cannot be set to null or blank");
            return false;}

        if( lastStatePlayed != null && lastStatePlayed == state ) {
            logger.warn("Is not your turn");
            return false;}

        if(getCellByPos(xPos, yPos).getState() != State.BLANK) {
            logger.warn("Cell state already set");
            return false;}

        getCellByPos(xPos, yPos).setState(state);
        lastStatePlayed = state;
        return true;
    }

    public void print(){
        for(int y=0; y<3; y++) {
            String line = "";
            for(int x=0; x<3; x++) {
                line = line.concat(getCellByPos(x, y).getState().toString() + "  ");
            }
            logger.info(line);
        }
    }

    public boolean stillBlankCellsRemaining(){
        if(cellList.stream()
                .noneMatch((cell) -> cell.getState() == State.BLANK)){
            logger.warn("No blank cells remaining - nobody wins");
            return false;
        }
        return true;
    }

    public Cell getCellByPos(int xPos, int yPos){
        return Objects.requireNonNull(cellList.stream()
                .filter((cell) -> cell.getxPos() == xPos)
                .filter((cell) -> cell.getyPos() == yPos)
                .findFirst()
                .orElse(null));
    }

    public State checkWinner() {
        if (checkHorizontal(0, 0)) {
            logger.info(getCellByPos(0, 0).getState().toString() + " won - top horizontal row");
            return getCellByPos(0, 0).getState();
        }
        else if (checkHorizontal(0, 1)) {
            logger.info(getCellByPos(0, 1).getState().toString() + " won - middle horizontal row");
            return getCellByPos(0, 1).getState();
        }
        else if (checkHorizontal(0, 2)) {
            logger.info(getCellByPos(0, 2).getState().toString() + " won - bottom horizontal row");
            return getCellByPos(0, 2).getState();
        }
        else if (checkLeftDiagonal()) {
            logger.info(getCellByPos(0, 0).getState().toString() + " won - left diagonal row");
            return getCellByPos(0, 0).getState();
        }
        else if (checkVertical(0, 0)) {
            logger.info(getCellByPos(0, 0).getState().toString() + " won - left vertical row");
            return getCellByPos(0, 0).getState();
        }
        else if (checkVertical(1, 0)) {
            logger.info(getCellByPos(1, 0).getState().toString() + " won - middle vertical row");
            return getCellByPos(1, 0).getState();
        }
        else if (checkVertical(2, 0)) {
            logger.info(getCellByPos(2, 0).getState().toString() + " won - right vertical row");
            return getCellByPos(2, 0).getState();
        }
        else if (checkRightDiagonal()) {
            logger.info(getCellByPos(2, 0).getState().toString() + " won - right diagonal row");
            return getCellByPos(2, 0).getState();
        }
        return State.BLANK;
    }

    private boolean checkHorizontal(int x, int y) {
        if(getCellByPos(x,y).getState() == State.BLANK) return false;
        return (getCellByPos(x, y).getState() == getCellByPos(x + 1, y).getState() &&
                getCellByPos(x, y).getState() == getCellByPos(x + 2, y).getState());
    }

    private boolean checkLeftDiagonal() {
        if(getCellByPos(0,0).getState() == State.BLANK) return false;
        return (getCellByPos(0, 0).getState() == getCellByPos(1, 1).getState() &&
                getCellByPos(0, 0).getState() == getCellByPos(2, 2).getState());
    }

    private boolean checkVertical(int x, int y) {
        if(getCellByPos(x,y).getState() == State.BLANK) return false;
        return (getCellByPos(x, y).getState() == getCellByPos(x, y + 1).getState() &&
                getCellByPos(x, y).getState() == getCellByPos(x, y + 2).getState());
    }

    private boolean checkRightDiagonal() {
        if(getCellByPos(2,0).getState() == State.BLANK) return false;
        return (getCellByPos(2, 0).getState() == getCellByPos(1, 1).getState() &&
                getCellByPos(2, 0).getState() == getCellByPos(0, 2).getState());
    }

    private void initBoard(){
        cellList = new ArrayList<>();
        IntStream.range(0, 3).forEach(i ->
                IntStream.range(0, 3).forEach(j ->
                        cellList.add(new Cell(i, j))));
        logger.info("Init Board - New game ready");
    }
}
