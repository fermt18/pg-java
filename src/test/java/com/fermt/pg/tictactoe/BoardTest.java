package com.fermt.pg.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void create_board(){
        board = new Board();
    }

    @Test
    void test_board_get_cell_not_found_by_pos() {
        assertThrows(NullPointerException.class, () -> board.getCellByPos(3, 1));
    }

    @Test
    void test_board_get_cell_not_found() {
        assertFalse(board.nextMove(3, 1, State.CROSS));
    }

    @Test
    void test_board_next_move() {
        assertTrue(board.nextMove(1, 0, State.CIRCLE));
        assertEquals(State.CIRCLE, board.getCellByPos(1, 0).getState());
    }

    @Test
    void test_board_next_move_blank_cell() {
        assertTrue(board.nextMove(0, 2, State.CIRCLE));
        assertFalse(board.nextMove(0, 2, State.BLANK));
        assertEquals(State.CIRCLE, board.getCellByPos(0, 2).getState());
    }

    @Test
    void test_board_next_move_not_empty_cell() {
        assertTrue(board.nextMove(0, 0, State.CIRCLE));
        assertFalse(board.nextMove(0, 0, State.CROSS));
        assertEquals(State.CIRCLE, board.getCellByPos(0, 0).getState());
    }

    @Test
    void test_board_next_move_same_player(){
        assertTrue(board.nextMove(0, 0, State.CROSS));
        assertFalse(board.nextMove(0, 1, State.CROSS));
    }

    @Test
    void test_board_is_there_a_winner_left_vertical_row(){
        assertTrue(board.nextMove(0, 0, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 2, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_is_there_a_winner_middle_vertical_row(){
        assertTrue(board.nextMove(1, 0, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 2, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_is_there_a_winner_right_vertical_row(){
        assertTrue(board.nextMove(2, 0, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 2, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_is_there_a_winner_lower_horizontal_row(){
        assertTrue(board.nextMove(0, 0, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 0, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 2, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 0, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_is_there_a_winner_middle_horizontal_row(){
        assertTrue(board.nextMove(0, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 2, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 1, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_is_there_a_winner_upper_horizontal_row(){
        assertTrue(board.nextMove(0, 2, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 2, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 2, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_is_there_a_winner_upper_diagonal_row(){
        assertTrue(board.nextMove(0, 0, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 2, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_is_there_a_winner_lower_diagonal_row(){
        assertTrue(board.nextMove(0, 2, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 2, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 0, State.CROSS));
        assertEquals(State.CROSS, board.checkWinner());
    }

    @Test
    void test_board_nobody_wins(){
        assertTrue(board.nextMove(0, 0, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 1, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(0, 2, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(1, 2, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 1, State.CROSS));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.nextMove(2, 0, State.CIRCLE));
        assertEquals(State.BLANK, board.checkWinner());
        assertTrue(board.stillBlankCellsRemaining());
        assertTrue(board.nextMove(2, 2, State.CROSS));
        assertFalse(board.stillBlankCellsRemaining());
    }
}
