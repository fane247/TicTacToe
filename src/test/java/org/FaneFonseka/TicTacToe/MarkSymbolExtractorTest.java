package org.FaneFonseka.TicTacToe;

import org.junit.Test;
import sun.plugin.javascript.navig.LinkArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Fane on 23/01/2017.
 */
public class MarkSymbolExtractorTest {


    @Test
    public void whenGivenAListOfMarksReturnsListOfMarkSymbols() {

        MarkSymbolExtractor markSymbolExtractor = new MarkSymbolExtractor();

        List<Mark> marks = Arrays.asList(new Mark(MarkSymbol.X), new Mark(MarkSymbol.X), new Mark(MarkSymbol.X));

        List<MarkSymbol> actualMarkSymbolsList = markSymbolExtractor.getMarkSymbolsList(marks);

        List<MarkSymbol> expectedMarkSymbols = Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.X);

        assert actualMarkSymbolsList.equals(expectedMarkSymbols);

    }

    @Test
    public void whenGivenAListOfListMarksReturnsListOfMarkSymbols() {

        MarkSymbolExtractor markSymbolExtractor = new MarkSymbolExtractor();

        List<Mark> marks = Arrays.asList(new Mark(MarkSymbol.X), new Mark(MarkSymbol.X), new Mark(MarkSymbol.X));
        List<Mark> marks2 = Arrays.asList(new Mark(MarkSymbol.X), new Mark(MarkSymbol.X), new Mark(MarkSymbol.X));
        List<Mark> marks3 = Arrays.asList(new Mark(MarkSymbol.X), new Mark(MarkSymbol.X), new Mark(MarkSymbol.X));

        List<List<Mark>> listsMark = Arrays.asList(marks, marks2, marks3);

        List<MarkSymbol> markSymbols = Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.X);
        List<MarkSymbol> markSymbols2 = Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.X);
        List<MarkSymbol> markSymbols3 = Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.X);

        List<List<MarkSymbol>> expectedMarkSymbol = Arrays.asList(markSymbols, markSymbols2, markSymbols3);

        List<List<MarkSymbol>> actualMarkSymbolsLists = markSymbolExtractor.getMarkSymbolsLists(listsMark);

        assert actualMarkSymbolsLists.equals(expectedMarkSymbol);

    }

}