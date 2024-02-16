public enum ChessRank {
    RANK_ONE(1) {
        @Override
        public ChessRank up() {
            return RANK_TWO;
        }

        @Override
        public ChessRank down() {
            throw new RuntimeException("Rank 1 can't have a rank down");
        }
    },

    RANK_TWO(2) {
        @Override
        public ChessRank up() {
            return RANK_THREE;
        }

        @Override
        public ChessRank down() {
            return RANK_ONE;
        }
    },

    RANK_THREE(3) {
        @Override
        public ChessRank up() {
            return RANK_FOUR;
        }

        @Override
        public ChessRank down() {
            return RANK_TWO;
        }
    },

    RANK_FOUR(4) {
        @Override
        public ChessRank up() {
            return RANK_FIVE;
        }

        @Override
        public ChessRank down() {
            return RANK_THREE;
        }
    },

    RANK_FIVE(5) {
        @Override
        public ChessRank up() {
            return RANK_SIX;
        }

        @Override
        public ChessRank down() {
            return RANK_FOUR;
        }
    },

    RANK_SIX(6) {
        @Override
        public ChessRank up() {
            return RANK_SEVEN;
        }

        @Override
        public ChessRank down() {
            return RANK_FIVE;
        }
    },

    RANK_SEVEN(7) {
        @Override
        public ChessRank up() {
            return RANK_EIGHT;
        }

        @Override
        public ChessRank down() {
            return RANK_SIX;
        }
    },

    RANK_EIGHT(8) {
        @Override
        public ChessRank up() {
            throw new RuntimeException("Rank 8 can't have a rank up");
        }

        @Override
        public ChessRank down() {
            return RANK_SEVEN;
        }
    };

    private final int rank;

    ChessRank(int rank) {
        this.rank = rank;
    }

    public static ChessRank of(int rank) {
        return switch (rank) {
            case 1 -> RANK_ONE;
            case 2 -> RANK_TWO;
            case 3 -> RANK_THREE;
            case 4 -> RANK_FOUR;
            case 5 -> RANK_FIVE;
            case 6 -> RANK_SIX;
            case 7 -> RANK_SEVEN;
            case 8 -> RANK_EIGHT;
            default ->
                    throw new IllegalArgumentException("Ranks are only between 1 and 8, " + rank + "is not a valid rank");
        };
    }

    public boolean hasUp() {
        return this != RANK_EIGHT;
    }

    public boolean hasDown() {
        return this != RANK_ONE;
    }

    public abstract ChessRank up();

    public abstract ChessRank down();

    @Override
    public String toString() {
        return "Rank: " + rank;
    }
}
