package pieces;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class MoveUtils {
    private static final int MIN_POS = 0;
    private static final int MAX_POS = 63;
    private static final int RANK_LEN = 8;

    /**
     * Functions for valid moves for each piece type.
     */
    public static final BiFunction<Board, Integer, Set<Integer>> ROOK_MOVES = (board, initialPos) -> {
        Set<Integer> moves = new TreeSet<>();
        Tile[] tiles = board.getBoard();
        int rankIndex = initialPos / RANK_LEN;
        int rankStart = rankIndex * RANK_LEN;
        int rankEnd   = rankStart + RANK_LEN;
        int index = initialPos;
        while (index > rankStart) {
            if (isEmptyTile(tiles[--index])) {
                moves.add(index);
            } else {
                addAttackMove(moves, tiles[initialPos], tiles[index]);
                break;
            }
        }
        index = initialPos;
        while (index < rankEnd - 1) {
            if (tiles[++index].getPiece().getType() == PieceType.NULL) {
                moves.add(index);
            } else {
                moves.add(index);
                break;
            }
        }
        index = initialPos;
        while (index >= MIN_POS + RANK_LEN) {
            index -= RANK_LEN;
            if (tiles[index].getPiece().getType() == PieceType.NULL) {
                moves.add(index);
            } else {
                moves.add(index);
                break;
            }
        }
        index = initialPos;
        while (index <= MAX_POS - RANK_LEN) {
            index += RANK_LEN;
            if (tiles[index].getPiece().getType() == PieceType.NULL) {
                moves.add(index);
            } else {
                moves.add(index);
                break;
            }
        }
        return moves;
    };

    private static boolean isEmptyTile(Tile tile) {
        return tile.getPiece().getType() == PieceType.NULL;
    }

    private static void addAttackMove(Set<Integer> moves,
                                      Tile attacker,
                                      Tile victim) {
        if (attacker.getPiece().getAlliance() != victim.getPiece().getAlliance()) {
            moves.add(victim.getPiece().getPosition());
        }
    }
}