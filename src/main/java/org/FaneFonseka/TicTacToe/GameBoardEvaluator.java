package org.FaneFonseka.TicTacToe;

import java.util.List;

/**
 * Created by Fane on 23/01/2017.
 */
public class GameBoardEvaluator {

    private final GameBoard gameBoard;
    private final MarkSymbol maximisingPlayer;
    private final MarkSymbol minimisingPlayer;
    private MarkSymbolCounter markSymbolCounter;
    private List<List<MarkSymbol>> markSymbolsLists;

    GameBoardEvaluator(GameBoard gameBoard, MarkSymbol maximisingPlayer) {

        this.gameBoard = gameBoard;
        this.maximisingPlayer = maximisingPlayer;
        minimisingPlayer = maximisingPlayer.equals(MarkSymbol.X) ? MarkSymbol.O : MarkSymbol.X;
        markSymbolCounter = new MarkSymbolCounter(maximisingPlayer);
    }


    public int evaluateBoardMaxPlayer() {
        setMarkSymbolsList();
        markSymbolCounter = new MarkSymbolCounter(maximisingPlayer);

        return getScore3InARow();
    }

    public int evaluateBoardMinPlayer() {

        setMarkSymbolsList();
        markSymbolCounter = new MarkSymbolCounter(minimisingPlayer);
        return getScore3InARow()*-1;

    }

    public int evaluateBoard() {

        int maxPlayerBoardScore = evaluateBoardMaxPlayer();
        int minPlayerBoardScore = evaluateBoardMinPlayer();

        return maxPlayerBoardScore + minPlayerBoardScore;
    }


    int getScore3InARow() {

        setMarkSymbolsList();
        return markSymbolCounter.count3InARowLists(markSymbolsLists) * 1000;

    }

    private void setMarkSymbolsList() {

        LineExtractor lineExtractor = new LineExtractor(gameBoard);
        markSymbolsLists = lineExtractor.getAllLines();

    }

}
