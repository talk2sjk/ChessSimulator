package com.technogise.chesssimulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {


    @Test
    void testIsValid() {
        Position valid = new Position(0, 0);
        assertTrue(valid.isValid());

        Position invalidRow = new Position(-1, 4);
        assertFalse(invalidRow.isValid());

        Position invalidCol = new Position(4, 8);
        assertFalse(invalidCol.isValid());

        Position invalidBoth = new Position(9, 9);
        assertFalse(invalidBoth.isValid());
    }

    @Test
    void testGetRowAndGetCol() {
        Position pos = new Position(2, 5);
        assertEquals(2, pos.getRow());
        assertEquals(5, pos.getCol());
    }

    @Test
    public void testFromString_positive() {
        Position pos1 = Position.fromString("H8");
        assertEquals(0, pos1.getRow());
        assertEquals(7, pos1.getCol());

        Position pos2 = Position.fromString("A8");
        assertEquals(0, pos2.getRow());
        assertEquals(0, pos2.getCol());

        Position pos3 = Position.fromString("D6");
        assertEquals(2, pos3.getRow());
        assertEquals(3, pos3.getCol());
    }

    @Test
    void testFromString_negative() {
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("Z1"));
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("AB"));
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("A0"));
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("I5"));
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("A9"));
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("9A"));
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("9"));
        assertThrows(IllegalArgumentException.class, () -> Position.fromString("B12"));
    }

    @Test
    void testGetStringNotation() {
        Position pos1 = new Position(0, 0);
        assertEquals("A8", pos1.getStringNotation());

        Position pos2 = new Position(7, 7);
        assertEquals("H1", pos2.getStringNotation());

        Position pos3 = new Position(0, 7);
        assertEquals("H8", pos3.getStringNotation());

        Position pos4 = new Position(7, 0);
        assertEquals("A1", pos4.getStringNotation());

        Position pos5 = new Position(4, 4);
        assertEquals("E4", pos5.getStringNotation());
    }
}
