package org.FaneFonseka.TicTacToe;

import java.util.List;

class WinChecker {

    private List<List<MarkSymbol>> allLines;
    List<List<MarkSymbol>> allMarkSymbolLines;
    private GameBoard gameBoard;
    private boolean xHasWon;
    private boolean oHasWon;
    private boolean noSpacesLeft;

    WinChecker(GameBoard gameBoard) {

        this.gameBoard = gameBoard;
    }

    boolean gameIsOver() {

        setAllLines();

        xHasWon = markSymbolHasWon(MarkSymbol.X);
        oHasWon = markSymbolHasWon(MarkSymbol.O);
        noSpacesLeft = noSpacesLeft();

        boolean gameIsOver = false;

        if (xHasWon || oHasWon || noSpacesLeft) {

            gameIsOver = true;

        }

        return gameIsOver;
    }


    void setAllLines() {
        LineExtractor lineExtractor = new LineExtractor(gameBoard);
        allMarkSymbolLines = lineExtractor.getAllLines();
    }


    public Boolean markSymbolHasWon(MarkSymbol markSymbol) {

        setAllLines();

        boolean MarkSymbolHasWon = false;

        for (List<MarkSymbol> markSymbolList : allMarkSymbolLines) {

            int markSymbolCount = 0;

            for (MarkSymbol markSymbolInBoard : markSymbolList) {

                if (markSymbolInBoard.equals(markSymbol)) {
                    markSymbolCount++;
                }
            }

            MarkSymbolHasWon = markSymbolCount == 3;

            if (MarkSymbolHasWon) {
                break;
            }

        }

        return MarkSymbolHasWon;
    }


    private boolean noSpacesLeft() {

        int blankCount = 0;

        for (List<MarkSymbol> markSymbolList : allMarkSymbolLines) {

            for (MarkSymbol markSymbol : markSymbolList) {

                if (markSymbol.equals(MarkSymbol.BLANK)) {

                    blankCount += 1;
                }
            }

        }

        return blankCount == 0;
    }

    public String announceWinner() {

        String gameOverStatement = "";

        if (xHasWon) {

            gameOverStatement = "X has won!";

        }
        if (oHasWon) {

            gameOverStatement = "O has won!";
        }
        if (!xHasWon && !oHasWon && noSpacesLeft) {

            gameOverStatement = "Tie Game!";
        }

        return gameOverStatement;

    }
}