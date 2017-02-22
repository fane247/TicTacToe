package org.FaneFonseka.TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fane on 20/01/2017.
 */
public class BoardLinesExtractor extends LineExtractor {


    private final List<LineExtractor> lineExtractors;

    BoardLinesExtractor(GameBoard gameBoard) {

        super(gameBoard);


        RowLineExtractor rowLineExtractor = new RowLineExtractor(gameBoard);
        ColumnLineExtractor columnLineExtractor = new ColumnLineExtractor(gameBoard);
        DiagonalLineExtractor diagonalLineExtractor = new DiagonalLineExtractor(gameBoard);

        lineExtractors = Arrays.asList(columnLineExtractor, rowLineExtractor, diagonalLineExtractor);

    }

    @Override
    List<List<Mark>> getLines() {

        List<List<Mark>> lines = new ArrayList<>();

        for (LineExtractor lineExtractor : lineExtractors) {

            List<List<Mark>> lists = lineExtractor.getLines();

            for (List<Mark> markList : lists) {

                lines.add(markList);
            }

        }
        return lines;
    }


}
