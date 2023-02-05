package pieces;

import java.util.Objects;

public final class Move {

    int start, end;
    //Board resultBoard;

    public Move(final int start, final int end) {
        validateSquares(start, end);

        this.start = start;
        this.end = end;
    }

    /**
     * Asserts that all param squares have valid square numbers.
     * @param squares the squares to be validated.
     */
    private static void validateSquares(int... squares) {
        for (int square : squares) {
            assert square < Board.N_SQUARES && square >= 0;
        }
    }

    /**
     * Two moves are equal if their start and end are the same.
     * TODO maybe add the Board equivalence for more specificity.
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        Objects.requireNonNull(other);
        if (other instanceof Move) {
            Move move = (Move) other;
            if (this.start == move.start
                && this.end == move.end) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.end + "";
    }
}
