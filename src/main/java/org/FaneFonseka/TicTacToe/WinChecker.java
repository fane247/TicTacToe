package org.FaneFonseka.TicTacToe;

import java.util.ArrayList;
import java.util.List;

class WinChecker {

    private List<List<Mark>> allLines;
    List<List<MarkSymbol>> allMarkSymbolLines;
    private GameBoard gameBoard;
    private boolean xHasWon;
    private boolean oHasWon;
    private boolean noSpacesLeft;

    WinChecker(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
    }

    boolean gameIsOver() {

        setAllMarkSymbolLines();

        xHasWon = markSymbolHasWon(MarkSymbol.X);
        oHasWon = markSymbolHasWon(MarkSymbol.O);
        noSpacesLeft = noSpacesLeft();

        boolean gameIsOver = false;

        if (xHasWon || oHasWon || noSpacesLeft) {

            gameIsOver = true;

        }

        return gameIsOver;
    }

    void setAllMarkSymbolLines() {
        setAllLines();
        MarkSymbolExtractor markSymbolExtractor = new MarkSymbolExtractor();
        allMarkSymbolLines = markSymbolExtractor.getMarkSymbolsLists(allLines);
    }

    void setAllLines() {
        allLines = new ArrayList<>();
        BoardLinesExtractor boardLinesExtractor = new BoardLinesExtractor(gameBoard);
        allLines = boardLinesExtractor.getLines();
    }


    private Boolean markSymbolHasWon(MarkSymbol markSymbol) {

        MarkSymbolCounter markSymbolCounterCurrentPlayerX = new MarkSymbolCounter(markSymbol);
        boolean MarkSymbolHasWon = false;

        for (List<MarkSymbol> markSymbolList : allMarkSymbolLines) {

            int markSymbolCount = markSymbolCounterCurrentPlayerX.countMarkSymbols(markSymbolList);

            MarkSymbolHasWon = markSymbolCount == 3;

            if (MarkSymbolHasWon) {
                break;
            }

        }

        return MarkSymbolHasWon;
    }


    private boolean noSpacesLeft() {

        MarkSymbolCounter markSymbolCounterBlank = new MarkSymbolCounter(MarkSymbol.BLANK);

        int blankCount = 0;

        for (List<MarkSymbol> markSymbolList : allMarkSymbolLines) {

            blankCount += markSymbolCounterBlank.countMarkSymbols(markSymbolList);
        }

        return blankCount == 0;
    }

    public String announceWinner() {

        String gameOverStatement = "";

        if (xHasWon){

          gameOverStatement = "X has won!";

        } if(oHasWon){

            gameOverStatement = "O has won!";
        }
        if (!xHasWon && !oHasWon && noSpacesLeft){

            gameOverStatement = "Tie Game!";
        }

        return gameOverStatement;

    }
}