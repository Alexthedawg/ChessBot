package pieces;

public class Piece {

    /**
     * The position of the Piece on the Board.
     * 0 is the equivalent of A1; 63 is H8.
     */
    private int position;

    /**
     * The "class" of the Piece
     * (i.e. Knight, King, Pawn, etc.).
     */
    private PieceType type;

    public Piece(int position, PieceType type) {
        this.position = position;
        this.type = type;
    }

    public int getPosition() { return position; }

    public void setPosition(int position) { this.position = position; }

    public PieceType getType() { return type; }

    /**
     * The letter representation of this Piece.
     * @return the name of this Piece as defined in pieces.PieceType.
     */
    @Override
    public String toString() { return type.name(); }
}
