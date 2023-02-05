package pieces;

import java.util.AbstractSequentialList;
import java.util.Set;
import java.util.stream.Collectors;

public class Piece {

    /**
     * The position of the Piece on the pieces.Board.
     * 0 is the equivalent of A1; 63 is H8.
     */
    private int position;
    /**
     * The player who will play the next move.
     */
    private Alliance alliance;
    /**
     * The "class" of the Piece
     * (i.e. Knight, King, Pawn, etc.).
     */
    private PieceType type;

    public Piece(int position, Alliance alliance, PieceType type) {
        this.position = position;
        this.alliance = alliance;
        this.type = type;
    }

    public int getPosition() { return position; }

    public void setPosition(int position) { this.position = position; }

    public PieceType getType() { return this.type; }

    public Alliance getAlliance() { return this.alliance; }

    /**
     * The letter representation of this Piece.
     * @return the name of this Piece as defined in pieces.PieceType.
     */
    @Override
    public String toString() { return type.name(); }

    /**
     * Creates a deep copy of this Piece.
     * @return a deep copy of this Piece.
     */
    public Piece clone() {
        Piece clone = new Piece(this.getPosition(), this.alliance, PieceType.NULL);
        clone.type = this.getType();

        return clone;
    }

    /**
     * Gives a Set of Moves that this Piece can make.
     * TODO check for invalid moves that leave King in check.
     * @return a Set of valid Moves.
     */
    public Set<Move> getMoves(Board board) {
        // Gets the square of potential moves.
        Set<Integer> targets = this.type.getPotentialMoves(board, this.getPosition());
        // TODO check for invalid moves due to exposed King.
        return targets.stream()
                      .map(target -> new Move(this.getPosition(), target))
                      .collect(Collectors.toSet());
    }
}
