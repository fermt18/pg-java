package com.fermt.pg.gol.testdata;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.*;
import java.util.stream.Stream;

public class BoardProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return provideBoards().stream();
    }

    private List<Arguments> provideBoards(){
        List<Arguments> arguments = new ArrayList<>();
        Board board;
        Iterator it = buildBoardMap().entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            board = new Board((boolean[][])pair.getKey(), (boolean[][])pair.getValue());
            arguments.add(Arguments.of(board));
        }
        return arguments;
    }

    private Map<boolean[][], boolean[][]> buildBoardMap(){
        Map<boolean[][], boolean[][]> boardMap = new HashMap<>();
        boardMap.put(
                new boolean[][] {
                        {false, false, false}},
                new boolean[][] {
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {false, true, false}},
                new boolean[][]{
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {true, true, false}},
                new boolean[][]{
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {false, true, true}},
                new boolean[][]{
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {true, true, true}},
                new boolean[][]{
                        {false, true, false}});
        boardMap.put(
                new boolean[][]{
                        {true, true, true, true}},
                new boolean[][]{
                        {false, true, true, false}});
        boardMap.put(
                new boolean[][]{
                        {false, true, false},
                        {false, true, false},
                        {false, true, false}},
                new boolean[][]{
                        {false, false, false},
                        {true, true, true},
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {false, false, false},
                        {true, true, true},
                        {false, false, false}},
                new boolean[][]{
                        {false, true, false},
                        {false, true, false},
                        {false, true, false}});
        boardMap.put(
                new boolean[][]{
                        {true, false, false},
                        {false, true, false},
                        {false, false, true}},
                new boolean[][]{
                        {false, false, false},
                        {false, true, false},
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {true, false, false},
                        {true, true, false},
                        {false, false, false}},
                new boolean[][]{
                        {true, true, false},
                        {true, true, false},
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {true, false, false},
                        {false, false, false},
                        {false, false, true}},
                new boolean[][]{
                        {false, false, false},
                        {false, false, false},
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {true, true, false},
                        {false, false, false},
                        {false, true, true}},
                new boolean[][]{
                        {false, false, false},
                        {true, false, true},
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {true, true, false},
                        {false, true, false},
                        {false, true, true}},
                new boolean[][]{
                        {true, true, false},
                        {false, false, false},
                        {false, true, true}});
        boardMap.put(
                new boolean[][]{
                        {true, true, true},
                        {false, true, false},
                        {false, false, false}},
                new boolean[][]{
                        {true, true, true},
                        {true, true, true},
                        {false, false, false}});
        boardMap.put(
                new boolean[][]{
                        {true, true, true},
                        {true, true, true},
                        {true, true, true}},
                new boolean[][]{
                        {true, false, true},
                        {false, false, false},
                        {true, false, true}});
        boardMap.put(
                new boolean[][]{
                        {true, true, false, false},
                        {false, false, true, false},
                        {true, true, false, false},
                        {false, false, false, false}},
                new boolean[][]{
                        {false, true, false, false},
                        {false, false, true, false},
                        {false, true, false, false},
                        {false, false, false, false}});
        return boardMap;
    }
}
