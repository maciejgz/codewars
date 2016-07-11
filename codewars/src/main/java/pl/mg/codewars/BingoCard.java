package pl.mg.codewars;

import java.util.Random;

/**
 * 
 * Finish method:
BingoCard.getCard()
A bingo card contains 24 unique and random numbers according to this scheme:
5 numbers from the B column in the range 1 to 15
5 numbers from the I column in the range 16 to 30
4 numbers from the N column in the range 31 to 45
5 numbers from the G column in the range 46 to 60
5 numbers from the O column in the range 61 to 75

The card must be returned as an array of bingo style numbers:
{"B14", "B12", "B5", "B6", "B3", "I28", "I27", ... }
The numbers must be in the order of their column: B, I, N, G, O. Within the columns the order of the numbers is random.

 * 
 * 
 * @author Maciej Gzik
 *
 */
public class BingoCard {

    public static String[] getCard() {
        String[][] card = new String[5][5];
        String[] LETTERS = new String[] { "B", "I", "N", "G", "O" };
        int[] LIMES = new int[] { 0, 15, 30, 45, 60 };
        Random random = new Random();
        int number = 0;

        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (i == 2 && j == 2) {
                    card[i][j] = "";
                } else {
                    number = random.nextInt(15) + 1 + LIMES[i];
                    while (checkIfExists(card[i], j, LETTERS[i] + number)) {
                        number = random.nextInt(15) + 1 + LIMES[i];
                    }
                    card[i][j] = LETTERS[i] + number;
                }
            }
        }
        return flattenArray(card);
    }

    public static String[] flattenArray(String[][] doubleArray) {
        String[] array = new String[24];
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                } else {
                    array[k++] = doubleArray[i][j];
                }
            }
        }
        return array;
    }

    public static boolean checkIfExists(String[] array, int lastIndex, String value) {
        for (int i = 0; i < lastIndex; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

}
