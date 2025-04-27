package com.technogise.chesssimulator;

public class Position {
    private final int  mRow;
    private final int mCol;

    public Position(int row, int col) {
        mRow = row;
        mCol = col;
    }

    public boolean isValid() {
        return mRow >= 0 && mCol >= 0 && mRow < 8 && mCol < 8;
    }

    public String getStringNotation() {
        return (char)(mCol + 'A') +""+ (8 - mRow);
    }

    public int getRow() {
        return mRow;
    }

    public int getCol() {
        return mCol;
    }

    public static Position fromString(String pos) throws IllegalArgumentException {
        if (pos.length() != 2) {
            throw new IllegalArgumentException("Invalid position format: " + pos);
        }

        char colChar = pos.toUpperCase().charAt(0);
        char rowChar = pos.charAt(1);

        if (colChar < 'A' || colChar > 'H' || rowChar < '1' || rowChar > '8') {
            throw new IllegalArgumentException("Invalid position: " + pos);
        }

        int col = colChar - 'A';
        // 'A'->0, 'B'->1, ..., 'H'->7
        int row = 8 - (rowChar - '0');
        // '8'->0, '7'->1, ..., '1'->7

        return new Position(row, col);
    }

    // Override equals to compare based on column and row
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return mCol == position.getCol() && mRow == position.getRow();
    }
}
