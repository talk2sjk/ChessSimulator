package com.technogise.chesssimulator.factory;

import com.technogise.chesssimulator.Position;
import com.technogise.chesssimulator.piece.King;
import com.technogise.chesssimulator.piece.Pawn;
import com.technogise.chesssimulator.piece.Piece;
import com.technogise.chesssimulator.piece.Queen;

public class PieceFactory {

    public static Piece createPiece(String type, String positionStr) throws IllegalArgumentException {

        Position position = Position.fromString(positionStr);

        return switch (type.toLowerCase()) {
            case "king" -> new King(position);
            case "queen" -> new Queen(position);
            case "pawn" -> new Pawn(position);
            default -> throw new IllegalArgumentException("Unsupported piece type: " + type);
        };
    }
}
