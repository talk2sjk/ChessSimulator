package com.technogise.chesssimulator.piece;

import com.technogise.chesssimulator.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {

    private King king;

    @Test
    void testGetAllPossibleMoves_Center() {
        king = new King(new Position(4, 4)); //E4
        List<Position> possibleMoves = king.getAllPossibleMoves();

        // Check that we have 8 possible moves for a King at the center of the board
        assertEquals(8, possibleMoves.size());

        // Verify the expected positions
        assertTrue(possibleMoves.contains(Position.fromString("D3")));
        assertTrue(possibleMoves.contains(Position.fromString("D4")));
        assertTrue(possibleMoves.contains(Position.fromString("D5")));
        assertTrue(possibleMoves.contains(Position.fromString("E3")));
        assertTrue(possibleMoves.contains(Position.fromString("E5")));
        assertTrue(possibleMoves.contains(Position.fromString("F3")));
        assertTrue(possibleMoves.contains(Position.fromString("F4")));
        assertTrue(possibleMoves.contains(Position.fromString("F5")));
    }

    @Test
    void testGetAllPossibleMoves_corner() {
        // Moving the King to the edge of the board (A1)
        king = new King(new Position(7, 0)); //Placing the king at A1
        List<Position> possibleMoves = king.getAllPossibleMoves();

        // The King on the corner should have 3 valid moves
        assertEquals(3, possibleMoves.size());

        // Verify the positions
        assertTrue(possibleMoves.contains(Position.fromString("A2")));
        assertTrue(possibleMoves.contains(Position.fromString("B1")));
        assertTrue(possibleMoves.contains(Position.fromString("B2")));
    }

    @Test
    void testGetAllPossibleMoves_edge() {
        // Moving the King to a corner of the board (H8)
        king = new King(new Position(7, 4)); // Placing King at E1
        List<Position> possibleMoves = king.getAllPossibleMoves();

        // The King in the corner should have 5 valid moves
        assertEquals(5, possibleMoves.size());

        // Verify the positions
        assertTrue(possibleMoves.contains(Position.fromString("D1")));
        assertTrue(possibleMoves.contains(Position.fromString("D2")));
        assertTrue(possibleMoves.contains(Position.fromString("E2")));
        assertTrue(possibleMoves.contains(Position.fromString("F1")));
        assertTrue(possibleMoves.contains(Position.fromString("F2")));
    }

    @Test
    void testGetAllPossibleMovesInvalidPosition() {
        // Testing invalid position (Outside board), should return no valid moves
        king = new King(new Position(8, 8)); // Invalid position (out of bounds)
        List<Position> possibleMoves = king.getAllPossibleMoves();

        assertTrue(possibleMoves.isEmpty());
    }
}
