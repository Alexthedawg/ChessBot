import pieces.Alliance;
import pieces.Board;
import pieces.Move;
import pieces.PieceType;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(Alliance.WHITE);

        Board copy = new Board(board);
        Set<Move> moves = board.pieces.get(0).getMoves(board);

        System.out.println(moves);
    }
}
