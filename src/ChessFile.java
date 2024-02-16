public enum ChessFile {
    FILE_A('A') {
        @Override
        public ChessFile right() {
            return FILE_B;
        }

        @Override
        public ChessFile left() {
            throw new RuntimeException("File A can't have a file left");
        }
    },

    FILE_B('B') {
        @Override
        public ChessFile right() {
            return FILE_C;
        }

        @Override
        public ChessFile left() {
            return FILE_A;
        }
    },

    FILE_C('C') {
        @Override
        public ChessFile right() {
            return FILE_D;
        }

        @Override
        public ChessFile left() {
            return FILE_B;
        }
    },

    FILE_D('D') {
        @Override
        public ChessFile right() {
            return FILE_E;
        }

        @Override
        public ChessFile left() {
            return FILE_C;
        }
    },

    FILE_E('E') {
        @Override
        public ChessFile right() {
            return FILE_F;
        }

        @Override
        public ChessFile left() {
            return FILE_D;
        }
    },

    FILE_F('F') {
        @Override
        public ChessFile right() {
            return FILE_G;
        }

        @Override
        public ChessFile left() {
            return FILE_E;
        }
    },

    FILE_G('G') {
        @Override
        public ChessFile right() {
            return FILE_H;
        }

        @Override
        public ChessFile left() {
            return FILE_F;
        }
    },

    FILE_H('H') {
        @Override
        public ChessFile right() {
            throw new RuntimeException("FIle H can't have a file right");
        }

        @Override
        public ChessFile left() {
            return FILE_G;
        }
    };

    private final char file;

    ChessFile(char file) {
        this.file = file;
    }

    public static ChessFile of(char file) {
        return switch (file) {
            case 'A' -> FILE_A;
            case 'B' -> FILE_B;
            case 'C' -> FILE_C;
            case 'D' -> FILE_D;
            case 'E' -> FILE_E;
            case 'F' -> FILE_F;
            case 'G' -> FILE_G;
            case 'H' -> FILE_H;
            default ->
                    throw new IllegalArgumentException("Files are only between A and H, " + file + "is not a valid file");
        };
    }

    public boolean hasRight() {
        return this != FILE_H;
    }

    public boolean hasLeft() {
        return this != FILE_A;
    }

    public abstract ChessFile right();

    public abstract ChessFile left();

    @Override
    public String toString() {
        return "File: " + file;
    }
}