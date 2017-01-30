package org.FaneFonseka.TicTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fane on 17/01/2017.
 */
class MarkSymbolExtractor {


    List<MarkSymbol> getMarkSymbolsList(List<Mark> markList) {

        List<MarkSymbol> markSymbolsList = new ArrayList<>();

        for (Mark mark : markList) {

            markSymbolsList.add(mark.MARK_SYMBOL);

        }

        return markSymbolsList;
    }

    List<List<MarkSymbol>> getMarkSymbolsLists(List<List<Mark>> listsMark) {

        List<List<MarkSymbol>> markSymbolLines = new ArrayList<>();

        for (List<Mark> markList : listsMark) {

            markSymbolLines.add(getMarkSymbolsList(markList));

        }

        return markSymbolLines;
    }
}
