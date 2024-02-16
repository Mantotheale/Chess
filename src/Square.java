import java.util.Objects;

public final class Square {
    private static final int CHESSBOARD_SIZE = 8;
    private static final Square[][] squares = generateChessboard();

    private final ChessRank rank;
    private final ChessFile file;

    private static Square[][] generateChessboard() {
        Square[][] squares = new Square[Square.CHESSBOARD_SIZE][Square.CHESSBOARD_SIZE];

        for (ChessRank rank: ChessRank.values())
            for (ChessFile file: ChessFile.values())
                squares[rank.ordinal()][file.ordinal()] = new Square(rank, file);

        return squares;
    }

    private Square(ChessRank rank, ChessFile file) {
        this.rank = rank;
        this.file = file;
    }

    public ChessRank rank() {
        return rank;
    }

    public ChessFile file() {
        return file;
    }

    public static Square of(ChessRank rank, ChessFile file) {
        return squares[rank.ordinal()][file.ordinal()];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Square) obj;
        return this.rank == that.rank &&
                this.file == that.file;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, file);
    }

    @Override
    public String toString() {
        return "Square: {" + rank + ", " + file + "}";
    }
}
