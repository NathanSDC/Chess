package com.nd.chess.chess;

import com.nd.chess.boardgame.Board;
import com.nd.chess.boardgame.Piece;
import com.nd.chess.boardgame.Position;
import com.nd.chess.chess.pieces.King;
import com.nd.chess.chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);

        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                matriz[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return matriz;
    }

    public ChessPiece performChessMove(Position origin, Position target) {
        validateOriginPosition(origin);

        Piece capturedPiece = makeMove(origin, target);

        return (ChessPiece) capturedPiece;
    }

    private void validateOriginPosition(Position pos) {
        if (!board.ThereIsAPiece(pos)) {
            throw new ChessException("There is no piece on origin position!");
        }

        if(!board.piece(pos).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece!");
        }
    }

    private Piece makeMove(Position origin, Position target) {
        Piece p = board.removePiece(origin);
        Piece c = board.removePiece(target);

        board.placePiece(p, target);
        return c;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){
        // WHITE PIECES
        placeNewPiece('h', 6, new Rook(board, Color.WHITE));
        board.placePiece(new King(board, Color.WHITE), new Position(4,7));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7, 7));

        // BLACK PIECES
        board.placePiece(new Rook(board, Color.BLACK), new Position(0, 0));
        board.placePiece(new King(board, Color.BLACK), new Position(4, 0));
        board.placePiece(new Rook(board, Color.BLACK), new Position(7, 0));
    }
}
