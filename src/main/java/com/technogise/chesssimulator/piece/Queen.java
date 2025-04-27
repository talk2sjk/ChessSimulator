package com.technogise.chesssimulator.piece;

import com.technogise.chesssimulator.Position;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Position position) {
        super(position);
    }

    @Override
    public List<Position> getAllPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<Position>();
        Position currentPosition = getPosition();
        if (currentPosition.isValid()) {
            //These are the immediate 8 directions for the queen
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int dir = 0; dir < 8; dir++) {
                int curRow = currentPosition.getRow();
                int curCol = currentPosition.getCol();
                boolean continueLoop = true;

                while (continueLoop) {
                    //Queen can continue in the same direction as many steps as she wants
                    curRow += dx[dir];
                    curCol += dy[dir];
                    Position newPosition = new Position(curRow, curCol);

                    if (newPosition.isValid()) {
                        possibleMoves.add(newPosition);
                    } else {
                        continueLoop = false;
                    }
                }
            }
        }


        return possibleMoves;
    }
}