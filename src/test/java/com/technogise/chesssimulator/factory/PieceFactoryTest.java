package com.technogise.chesssimulator.factory;


import com.technogise.chesssimulator.piece.King;
import com.technogise.chesssimulator.piece.Pawn;
import com.technogise.chesssimulator.piece.Piece;
import com.technogise.chesssimulator.piece.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceFactoryTest {

    @Test
    void testCreateKing() {
        Piece piece = PieceFactory.createPiece("King", "E4");
        assertNotNull(piece);
        assertInstanceOf(King.class, piece);
        assertEquals("E4", piece.getPosition().getStringNotation());
    }

    @Test
    void testCreateQueen() {
        Piece piece = PieceFactory.createPiece("Queen", "G4");
        assertNotNull(piece);
        assertInstanceOf(Queen.class, piece);
        assertEquals("G4", piece.getPosition().getStringNotation());
    }

    @Test
    void testCreatePawn() {
        Piece piece = PieceFactory.createPiece("Pawn", "A1");
        assertNotNull(piece);
        assertInstanceOf(Pawn.class, piece);
        assertEquals("A1", piece.getPosition().getStringNotation());
    }

    @Test
    void testInvalidPieceType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                PieceFactory.createPiece("Rook", "A1")
        );
        assertEquals("Unsupported piece type: Rook", exception.getMessage());
    }

    @Test
    void testInvalidPositionFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                PieceFactory.createPiece("King", "Z9")
        );
        assertTrue(exception.getMessage().contains("Invalid position"));
    }

    @Test
    void testNullPieceType() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                PieceFactory.createPiece(null, "A1")
        );
    }

    @Test
    void testNullPositionString() {
        Exception exception = assertThrows(NullPointerException.class, () ->
                PieceFactory.createPiece("Pawn", null)
        );
    }
}
