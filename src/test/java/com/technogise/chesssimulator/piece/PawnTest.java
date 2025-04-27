package com.technogise.chesssimulator.piece;

import com.technogise.chesssimulator.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {

    private Pawn pawn;

    @Test
    void testGetAllPossibleMoves_Center() {
        pawn = new Pawn(new Position(4, 4)); //E4
        List<Position> possibleMoves = pawn.getAllPossibleMoves();

        // Check that we have only 1 possible move for a Pawn at the center of the board
        assertEquals(1, possibleMoves.size());

        // Verify the expected positions
        assertTrue(possibleMoves.contains(Position.fromString("E5")));
    }

    @Test
    void testGetAllPossibleMoves_corner() {
        // Moving the Pawn to the edge of the board (A1)
        pawn = new Pawn(new Position(7, 0)); //Placing the pawn at A1
        List<Position> possibleMoves = pawn.getAllPossibleMoves();

        // Check that we have only 1 possible move for a Pawn at the center of the board
        assertEquals(1, possibleMoves.size());

        // Verify the expected positions
        assertTrue(possibleMoves.contains(Position.fromString("A2")));
    }

    @Test
    void testGetAllPossibleMoves_edge() {
        // Moving the Pawn to a corner of the board (H8)
        pawn = new Pawn(new Position(7, 4)); // Placing Pawn at E1
        List<Position> possibleMoves = pawn.getAllPossibleMoves();

        // Check that we have only 1 possible move for a Pawn at the center of the board
        assertEquals(1, possibleMoves.size());

        // Verify the expected positions
        assertTrue(possibleMoves.contains(Position.fromString("E2")));
    }

    @Test
    void testGetAllPossibleMovesInvalidPosition() {
        // Testing invalid position (Outside board), should return no valid moves
        pawn = new Pawn(new Position(9, 8)); // Invalid position (out of bounds)
        List<Position> possibleMoves = pawn.getAllPossibleMoves();

        assertTrue(possibleMoves.isEmpty());
    }
}
