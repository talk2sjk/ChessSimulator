package com.technogise.chesssimulator.piece;

import com.technogise.chesssimulator.Position;

import java.util.List;

public abstract class Piece {
    public Position mPosition;

    public Piece(Position  position) {
        mPosition = position;
    }

    public Position getPosition() {
        return mPosition;
    }

    public abstract List<Position> getAllPossibleMoves();
}
