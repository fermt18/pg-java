package com.fermt.pg.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    private Cell cell;

    @BeforeEach
    void create_cell(){
        cell = new Cell(0, 0);
    }

    @Test
    void test_cell_state_at_creation(){
        assertEquals(State.BLANK, cell.getState());
    }

    @ParameterizedTest
    @EnumSource(State.class)
    void test_cell_set_state(State state) {
        cell.setState(state);
        assertEquals(state, cell.getState());
    }
}
