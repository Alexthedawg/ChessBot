package pieces;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Represents the various Pieces on the chessboard.
 * Stores the letter representations of each type
 * (e.g. B for Bishop, N for Knight, P for Pawn).
 */
public enum PieceType {
    //TODO finish these move functions.
    KING("K", null),
    QUEEN("Q", null),
    BISHOP("B", null),
    KNIGHT("N", null),
    ROOK("R", MoveUtils.ROOK_MOVES),
    PAWN("P", null),
    NULL("-", null);

    private final String name;
    private final BiFunction<Board, Integer, Set<Integer>> moves;

    PieceType(String name, BiFunction<Board, Integer, Set<Integer>> moves) {
        this.name = name;
        this.moves = moves;
    }

    public final Set<Integer> getPotentialMoves(Board board, final int position) {
        return this.moves.apply(board, position);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
