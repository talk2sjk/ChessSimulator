package com.technogise.chesssimulator.piece;

import com.technogise.chesssimulator.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTest {

    private Queen queen;

    @Test
    void testGetAllPossibleMoves_Center() {
        queen = new Queen(new Position(4, 4)); //E4
        List<Position> possibleMoves = queen.getAllPossibleMoves();

        // Check that we have 27 possible moves for a Queen at the center of the board
        assertEquals(27, possibleMoves.size());

        // Verify the expected positions
        assertTrue(possibleMoves.contains(Position.fromString("A4")));
        assertTrue(possibleMoves.contains(Position.fromString("B4")));
        assertTrue(possibleMoves.contains(Position.fromString("C4")));
        assertTrue(possibleMoves.contains(Position.fromString("D4")));
        assertTrue(possibleMoves.contains(Position.fromString("F4")));
        assertTrue(possibleMoves.contains(Position.fromString("G4")));
        assertTrue(possibleMoves.contains(Position.fromString("H4")));

        assertTrue(possibleMoves.contains(Position.fromString("E1")));
        assertTrue(possibleMoves.contains(Position.fromString("E2")));
        assertTrue(possibleMoves.contains(Position.fromString("E3")));
        assertTrue(possibleMoves.contains(Position.fromString("E5")));
        assertTrue(possibleMoves.contains(Position.fromString("E6")));
        assertTrue(possibleMoves.contains(Position.fromString("E7")));
        assertTrue(possibleMoves.contains(Position.fromString("E8")));

        assertTrue(possibleMoves.contains(Position.fromString("A8")));
        assertTrue(possibleMoves.contains(Position.fromString("B7")));
        assertTrue(possibleMoves.contains(Position.fromString("C6")));
        assertTrue(possibleMoves.contains(Position.fromString("D5")));
        assertTrue(possibleMoves.contains(Position.fromString("F3")));
        assertTrue(possibleMoves.contains(Position.fromString("G2")));
        assertTrue(possibleMoves.contains(Position.fromString("H1")));
        assertTrue(possibleMoves.contains(Position.fromString("B1")));
        assertTrue(possibleMoves.contains(Position.fromString("C2")));
        assertTrue(possibleMoves.contains(Position.fromString("D3")));
        assertTrue(possibleMoves.contains(Position.fromString("F5")));
        assertTrue(possibleMoves.contains(Position.fromString("G6")));
        assertTrue(possibleMoves.contains(Position.fromString("H7")));

    }

    @Test
    void testGetAllPossibleMoves_corner() {
        // Moving the King to the edge of the board (A1)
        queen = new Queen(new Position(7, 0)); //Placing the Queen at A1
        List<Position> possibleMoves = queen.getAllPossibleMoves();

        // The King on the corner should have 3 valid moves
        assertEquals(21, possibleMoves.size());

        // Verify the positions
        assertTrue(possibleMoves.contains(Position.fromString("A2")));
        assertTrue(possibleMoves.contains(Position.fromString("A3")));
        assertTrue(possibleMoves.contains(Position.fromString("A4"))); // and so on in vertical direction...

        assertTrue(possibleMoves.contains(Position.fromString("B1")));
        assertTrue(possibleMoves.contains(Position.fromString("C1")));
        assertTrue(possibleMoves.contains(Position.fromString("D1"))); // and so on in horizontal direction...

        assertTrue(possibleMoves.contains(Position.fromString("B2")));
        assertTrue(possibleMoves.contains(Position.fromString("C3")));
        assertTrue(possibleMoves.contains(Position.fromString("D4"))); // and so on in diagonal direction...
    }


    @Test
    void testGetAllPossibleMoves_edge() {
        // Moving the King to a corner of the board (H8)
        queen = new Queen(new Position(7, 4)); // Placing Queen at E1
        List<Position> possibleMoves = queen.getAllPossibleMoves();

        // The King in the corner should have 21 valid moves
        assertEquals(21, possibleMoves.size());

        // Verify the positions
        assertTrue(possibleMoves.contains(Position.fromString("D1")));
        assertTrue(possibleMoves.contains(Position.fromString("C1"))); // and so on in horizontal left direction...

        assertTrue(possibleMoves.contains(Position.fromString("F1")));
        assertTrue(possibleMoves.contains(Position.fromString("G1"))); // and so on in horizontal right direction...

        assertTrue(possibleMoves.contains(Position.fromString("E2")));
        assertTrue(possibleMoves.contains(Position.fromString("E3")));
        assertTrue(possibleMoves.contains(Position.fromString("E4"))); // and so on in vertical top direction...

        assertTrue(possibleMoves.contains(Position.fromString("D2")));
        assertTrue(possibleMoves.contains(Position.fromString("C3"))); // and so on in diagonal left top direction...

        assertTrue(possibleMoves.contains(Position.fromString("f2")));
        assertTrue(possibleMoves.contains(Position.fromString("G3"))); // and so on in diagonal right top direction...
    }

    @Test
    void testGetAllPossibleMovesInvalidPosition() {
        // Testing invalid position (Outside board), should return no valid moves
        queen = new Queen(new Position(8, 8)); // Invalid position (out of bounds)
        List<Position> possibleMoves = queen.getAllPossibleMoves();

        assertTrue(possibleMoves.isEmpty());
    }
}
