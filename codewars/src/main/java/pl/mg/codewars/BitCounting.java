package pl.mg.codewars;

/**
 * Write a function that takes an (unsigned) integer as input, and returns the number of bits that are equal to one in the binary representation of that number.

Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
* @author Maciej Gzik
 *
 */
public class BitCounting {

    public static int countBits(int n) {
        return Integer.toBinaryString(n).length() - Integer.toBinaryString(n).replace("1", "").length();
    }

}
