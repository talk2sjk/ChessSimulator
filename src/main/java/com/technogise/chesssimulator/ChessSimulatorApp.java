package com.technogise.chesssimulator;

import com.technogise.chesssimulator.factory.PieceFactory;
import com.technogise.chesssimulator.piece.Piece;

import java.util.List;
import java.util.Scanner;

public class ChessSimulatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Piece and its position (e.g Queen, D5):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            //splitting the input based on the delimiter: a zero or more whitespace followed by a comma
            //again followed by a zero or more whitespace characters
            String[] partitions = input.split("\\s*,\\s*");

            if (partitions.length != 2) {
                System.out.println("Invalid input");
                continue;
            }

            String pieceType = partitions[0];
            String positionStringNotation = partitions[1];


            try {
                Piece piece = PieceFactory.createPiece(pieceType, positionStringNotation);
                List<Position> possibleMoves = piece.getAllPossibleMoves();

                if (possibleMoves.isEmpty()) {
                    System.out.println("No possible moves found");
                    continue;
                }

                System.out.print("Possible moves for " + pieceType + " at " + positionStringNotation + ": ");
                for (int i = 0; i < possibleMoves.size(); i++) {
                    if(i == possibleMoves.size()-1){
                        System.out.println(possibleMoves.get(i).getStringNotation());
                    } else {
                        System.out.print(possibleMoves.get(i).getStringNotation() + ", ");
                    }

                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}