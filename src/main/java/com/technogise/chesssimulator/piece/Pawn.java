package com.technogise.chesssimulator.piece;

import com.technogise.chesssimulator.Position;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Position position) {
        super(position);
    }

    @Override
    public List<Position> getAllPossibleMoves() {
        List<Position> possibleMoves = new ArrayList<Position>();
        Position currentPosition = getPosition();

        if(currentPosition.isValid()) {
            int curRow = currentPosition.getRow();
            int curCol = currentPosition.getCol();

            Position newPosition = new Position(curRow - 1, curCol);
            if(newPosition.isValid()) {
                possibleMoves.add(newPosition);
            }
        }

        return possibleMoves;
    }
}