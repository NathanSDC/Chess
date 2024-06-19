package com.nd.chess.chess.pieces;

import com.nd.chess.MainApplication;
import com.nd.chess.boardgame.Board;
import com.nd.chess.boardgame.Position;
import com.nd.chess.chess.ChessPiece;
import com.nd.chess.chess.Color;

import javafx.scene.image.Image;

public class Queen extends ChessPiece{

    public Queen(Board board, Color color) {
        super(board, color, new Image(MainApplication.class.getResource(String.format("images/pieces/queen-%s.png", color.toString())).toString()));
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] m = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(position.getRow(), position.getColumn());

        // below right
        p.setValues(position.getRow()+1, position.getColumn()+1);
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()+1);
            p.setRow(p.getRow()+1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }

        // below left
        p.setValues(position.getRow()+1, position.getColumn()-1);
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()-1);
            p.setRow(p.getRow()+1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }

        // above below
        p.setValues(position.getRow()-1, position.getColumn()-1);
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()-1);
            p.setRow(p.getRow()-1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }

        // above right
        p.setValues(position.getRow()-1, position.getColumn()+1);
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()+1);
            p.setRow(p.getRow()-1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().ThereIsAPiece(p)) {
            m[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if(getBoard().positionExists(p) && isThereAnOpponentPiece(p)){
            m[p.getRow()][p.getColumn()] = true;
        }
        
        return m;
    }

    @Override
    public String toString() {
        return "Queen";
    }

}
