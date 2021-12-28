package com.fermt.pg.tictactoe;

public enum State {

    BLANK {
        public String toString(){ return "-"; }
    },
    CIRCLE {
        public String toString(){ return "O"; }
    },
    CROSS {
        public String toString(){ return "X"; }
    }
}
