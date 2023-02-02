package pieces;

/**
 * Represents the various Pieces on the chessboard.
 * Stores the letter representations of each type
 * (e.g. B for Bishop, N for Knight, P for Pawn).
 */
public enum PieceType {
    KING("K"),
    QUEEN("Q"),
    BISHOP("B"),
    KNIGHT("N"),
    ROOK("R"),
    PAWN("P"),
    NULL("-");

    private final String name;

    PieceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
