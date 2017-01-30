package org.FaneFonseka.TicTacToe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fane on 17/01/2017.
 */
public class MarkSymbolCounterTest {


    private MarkSymbolCounter markSymbolCounter;
    private List<MarkSymbol> markList;
    private ArrayList<MarkSymbol> markList2;
    private ArrayList<MarkSymbol> markList3;

    @Before
    public void setup() {

        markSymbolCounter = new MarkSymbolCounter(MarkSymbol.X);

    }

    @Test
    public void whenGivenAListOfMarkSymbolsReturnsNumberOfSpecifiedMarkSymbolsInList() {

        markList = new ArrayList<>(Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.X));

        assert markSymbolCounter.countMarkSymbols(markList) == 3;

    }


    @Test
    public void whenMarkSymbolCounterHasMarkSymbolOReturnsCountOfMarkSymbolOInGivenList() {

        MarkSymbolCounter markSymbolCounter = new MarkSymbolCounter(MarkSymbol.O);

        markList = new ArrayList<>(Arrays.asList(MarkSymbol.O, MarkSymbol.O, MarkSymbol.X));

        assert markSymbolCounter.countMarkSymbols(markList) == 2;

    }

    @Test

    public void whenGivenAListOfMarkSymbolReturns1IfLineContainsThreeMarkSymbols() {

        markList = new ArrayList<>(Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.X));

        int threeInARow = markSymbolCounter.count3InARow(markList);

        assert threeInARow == 1;

    }

    @Test

    public void whenGivenAListOfMarkSymbolListsReturnsNumberOfLinesThatContainsThreeMarkSymbols() {

        markList = new ArrayList<>(Arrays.asList(MarkSymbol.X, MarkSymbol.X, MarkSymbol.X));
        markList2 = new ArrayList<>(Arrays.asList(MarkSymbol.O, MarkSymbol.O, MarkSymbol.O));
        markList3 = new ArrayList<>(Arrays.asList(MarkSymbol.BLANK, MarkSymbol.X, MarkSymbol.O));

        List<List<MarkSymbol>> markSymbolLists = Arrays.asList(markList, markList2, markList3);

        int threeInARowCount = markSymbolCounter.count3InARowLists(markSymbolLists);

        assert threeInARowCount == 1;

    }

}