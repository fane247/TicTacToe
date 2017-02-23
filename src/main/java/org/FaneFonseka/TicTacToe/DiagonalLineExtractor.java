package org.FaneFonseka.TicTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fane on 16/01/2017.
 */
class DiagonalLineExtractor extends LineExtractor {

    DiagonalLineExtractor(GameBoard gameBoard) {
        super(gameBoard);

    }

    @Override
    List<List<Mark>> getLines() {
        return null;
    }

//    List<List<Mark>> getLines() {
//
//        List<List<Mark>> linesToBeChecked = new ArrayList<List<Mark>>();
//
//        linesToBeChecked.add(getDiagonalLineTopLeftDown());
//        linesToBeChecked.add(getDiagonalLineTopRightDown());
//
//        return linesToBeChecked;
//    }
//
//
//    List<Mark> getDiagonalLineTopRightDown() {
//
//
//        List<Mark> markList = new ArrayList<Mark>();
//
//        int j = 2;
//
////        0,2 1,1 2,0
//
//        for (int i = 0; i < board.size(); i++) {
//
//            Mark mark = board.get(i).get(j);
//            markList.add(mark);
//
//            j--;
//
//        }
//
//        return markList;
//    }
//
//
//    List<Mark> getDiagonalLineTopLeftDown() {
//
//
//        List<Mark> markList = new ArrayList<Mark>();
//
//        for (int i = 0; i < board.size(); i++) {
//
//            Mark mark = board.get(i).get(i);
//            markList.add(mark);
//
//        }
//
//        return markList;
//    }


}
