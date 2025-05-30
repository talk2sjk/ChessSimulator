package com.technogise.chesssimulator.piece;

import com.technogise.chesssimulator.Position;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Position position) {
        super(position);
    }

    @Override
    public List<Position> getAllPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<Position>();

        Position currentPosition = getPosition();
        if (currentPosition.isValid()) {
            int curRow = currentPosition.getRow();
            int curCol = currentPosition.getCol();

            int[] dx = {1, 0, -1, 1, -1, 1, 0, -1};
            int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

            for (int dir = 0; dir < 8; dir++) {
                Position newPosition = new Position(curRow + dx[dir], curCol + dy[dir]);
                if (newPosition.isValid()) {
                    possibleMoves.add(newPosition);
                }
            }
        }

        return possibleMoves;
    }
}