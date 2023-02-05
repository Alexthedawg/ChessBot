package pieces;

import java.util.ArrayList;

public final class Board {

    /**
     * The standard number of squares on the board.
     */
    public static final int N_SQUARES = 64;
    /**
     * TODO check if King is in check.
     */
    //public final boolean validBoard;
    /**
     * The standard starting chess board.
     */
    private Tile[] board;
    public ArrayList<Piece> pieces;
    /**
     * This is the Alliance of the player
     * whose turn it is.
     */
    private Alliance toMove;
    private ArrayList<Move> validMoves;

    public Board(int test, Alliance toMove) {
        if (test == 1) {
            this.board = testRookBoard(); //TODO test rook here
            this.pieces = getPiecesOnBoard();
            this.toMove = toMove;
            this.validMoves = calculateValidMoves();
        }
    }

    private Tile[] testRookBoard() {
        return null;
    }

    public Board(Alliance toMove) {
        this.board = initializeStandardBoard();
        this.pieces = getPiecesOnBoard();
        this.toMove = toMove;
        this.validMoves = calculateValidMoves();
    }

    /**
     * Constructs a new pieces.Board based on parameter.
     * @param copy
     */
    public Board(Board copy) {
        this.board = copy.board.clone();
        this.pieces = new ArrayList<>();
        for (Piece piece : copy.pieces) {
            this.pieces.add((Piece) piece.clone());
        }
        this.validMoves = calculateValidMoves();
    }

    private ArrayList<Move> calculateValidMoves() {
        ArrayList<Move> validMoves = new ArrayList<>();
        Piece p = pieces.get(0); //TODO get all Pieces not just Rook
        validMoves.addAll(p.getMoves(this));

        return validMoves;
    }

    /**
     * Moves a Piece on the pieces.Board.
     * @param from the square the Piece starts on.
     *             The starting square cannot be empty.
     * @param to the square the Piece is moving to.
     *           The result of moving the Piece to this
     *           square cannot place the King in check.
     * @return the square the Piece moved to (the same
     * as from on failure, the same as to on success).
     */
    public int movePiece(final int from, final int to) {
        Piece pieceOnSquare = board[from].getPiece();

        // If there is no Piece on square, return from.
        if (pieceOnSquare.getType() == PieceType.NULL) {
            return from;
        }

        //TODO finish this method
        return -1;
    }

    /**
     * Gets the Pieces on the initialized pieces.Board.
     * @return a list of the Pieces on the pieces.Board.
     */
    private ArrayList<Piece> getPiecesOnBoard() {
        ArrayList<Piece> pieces = new ArrayList<>();

        for (Tile t : board) {
            if (t.getPiece().getType() != PieceType.NULL) {
                pieces.add(t.getPiece());
            }
        }
        return pieces;
    }

    /**
     * Creates a standard setup of chess pieces.
     * @return a pieces.Board with the standard chess setup.
     */
    private static Tile[] initializeStandardBoard() {
        Tile[] board = new Tile[N_SQUARES];
        // Building pieces.Board...
        for (int i = 0; i < N_SQUARES; i++) {
            switch (i) {
                case 0, 7:
                    board[i] = new Tile(i, new Piece(i, Alliance.WHITE, PieceType.ROOK));
                    break;
                case 56, 63:
                    board[i] = new Tile(i, new Piece(i, Alliance.BLACK, PieceType.ROOK));
                    break;
                case 1, 6:
                    board[i] = new Tile(i, new Piece(i, Alliance.WHITE, PieceType.KNIGHT));
                    break;
                case 57, 62:
                    board[i] = new Tile(i, new Piece(i, Alliance.BLACK, PieceType.KNIGHT));
                    break;
                case 2, 5:
                    board[i] = new Tile(i, new Piece(i, Alliance.WHITE, PieceType.BISHOP));
                    break;
                case 58, 61:
                    board[i] = new Tile(i, new Piece(i, Alliance.BLACK, PieceType.BISHOP));
                    break;
                case 3:
                    board[i] = new Tile(i, new Piece(i, Alliance.WHITE, PieceType.QUEEN));
                    break;
                case 59:
                    board[i] = new Tile(i, new Piece(i, Alliance.BLACK, PieceType.QUEEN));
                    break;
                case 4:
                    board[i] = new Tile(i, new Piece(i, Alliance.WHITE, PieceType.KING));
                    break;
                case 60:
                    board[i] = new Tile(i, new Piece(i, Alliance.BLACK, PieceType.KING));
                    break;
                case 9, 10, 11, 12, 13, 14, 15:
                    board[i] = new Tile(i, new Piece(i, Alliance.WHITE, PieceType.PAWN));
                    break;
                case 48, 49, 50, 51, 52, 53, 54, 55:
                    board[i] = new Tile(i, new Piece(i, Alliance.BLACK, PieceType.PAWN));
                    break;
                default:
                    board[i] = new Tile(i, new Piece(i, Alliance.NULL, PieceType.NULL));
            }
        }
        return board;
    }

    /**
     * Formats a String representation of the current
     * chess pieces.Board. TODO format with flipped orientation.
     * @return a String representation of the pieces.Board.
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

    public Tile[] getBoard() {
        return this.board;
    }

    public Alliance whoToMove() {
        return this.toMove;
    }
}