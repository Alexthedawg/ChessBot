package pieces;

import pieces.Piece;

/**
 * Represents a square on the chess board.
 * May contain a Piece.
 */
public class Tile {

    final int tileID;
    private Piece piece;

    public Tile(int tileID, Piece piece) {
        this.tileID = tileID;
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }

    @Override
    public String toString() {
        return piece.getType().toString();
    }
}
