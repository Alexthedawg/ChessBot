import pieces.Piece;
import pieces.PieceType;

public final class Board {

    /**
     * The standard number of squares on the board.
     */
    public static final int N_SQUARES = 64;
    /**
     * The standard starting chess board.
     */
    static Tile[] board = initializeStandardBoard();

    /**
     * Creates a standard setup of chess pieces.
     * @return a Board with the standard chess setup.
     */
    private static Tile[] initializeStandardBoard() {
        Tile[] board = new Tile[N_SQUARES];
        // Building Board...
        for (int i = 0; i < N_SQUARES; i++) {
            switch (i) {
                case 0, 7, 56, 63:
                    board[i] = new Tile(i, new Piece(i, PieceType.ROOK));
                    break;
                case 1, 6, 57, 62:
                    board[i] = new Tile(i, new Piece(i, PieceType.KNIGHT));
                    break;
                case 2, 5, 58, 61:
                    board[i] = new Tile(i, new Piece(i, PieceType.BISHOP));
                    break;
                case 3, 59:
                    board[i] = new Tile(i, new Piece(i, PieceType.QUEEN));
                    break;
                case 4, 60:
                    board[i] = new Tile(i, new Piece(i, PieceType.KING));
                    break;
                case 8, 9, 10, 11, 12, 13, 14, 15, 48, 49, 50, 51, 52, 53, 54, 55:
                    board[i] = new Tile(i, new Piece(i, PieceType.PAWN));
                    break;
                default:
                    board[i] = new Tile(i, new Piece(i, PieceType.NULL));
            }
        }
        return board;
    }

    /**
     * Formats a String representation of the current
     * chess Board. TODO format with flipped orientation.
     * @return a String representation of the Board.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int n_tile = 0;
        builder.append("WHITE\n\n");
        for (Tile tile : board) {
            builder.append(tile.toString() + " ");
            if (++n_tile % 8 == 0) { builder.append("\n"); }
        }
        builder.append("\nBLACK");
        return builder.toString();
    }
}