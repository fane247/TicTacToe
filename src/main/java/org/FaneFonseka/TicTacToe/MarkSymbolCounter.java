package org.FaneFonseka.TicTacToe;

import java.util.List;

public class MarkSymbolCounter {

    private final MarkSymbol markSymbol;
    private int markSymbolCount;

    MarkSymbolCounter(MarkSymbol markSymbol) {

        this.markSymbol = markSymbol;

    }

    int countMarkSymbols(List<MarkSymbol> line) {

        markSymbolCount = 0;

        for (MarkSymbol markSymbol : line) {

            if (markSymbol.equals(getMarkSymbol())) {
                markSymbolCount++;
            }
        }

        return markSymbolCount;
    }

    MarkSymbol getMarkSymbol() {
        return markSymbol;
    }

    public int count3InARow(List<MarkSymbol> markList) {

        int threeInARowCount = 0;

        countMarkSymbols(markList);

        if (markSymbolCount == 3) {
            threeInARowCount++;
        }


        return threeInARowCount;
    }

    public int count3InARowLists(List<List<MarkSymbol>> markSymbolLists) {

        int threeInARowCount = 0;

        for (List<MarkSymbol> markSymbolsList : markSymbolLists) {

            threeInARowCount += count3InARow(markSymbolsList);

        }

        return threeInARowCount;

    }

}