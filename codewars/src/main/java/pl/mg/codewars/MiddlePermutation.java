package pl.mg.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiddlePermutation {

    public static void main(String[] args) {
        System.out.println(findMidPerm("abcd"));
    }


    /**
     * You are given a string s. Every letter in s appears once.
     * <p>
     * Consider all strings formed by rearranging the letters in s.
     * After ordering these strings in dictionary order, return the middle term.
     * (If the sequence has a even length n, define its middle term to be the (n/2)th term.)
     * <p>
     * Example
     * For s = "abc", the result should be "bac". The permutations in order are: "abc", "acb", "bac", "bca",
     * "cab", "cba" So, The middle term is "bac".
     * <p>
     * Input/Output
     * [input] string s
     * <p>
     * unique letters (2 <= length <= 26)
     * <p>
     * [output] a string
     * <p>
     * middle permutation.
     *
     * @param strng
     * @return
     */
    public static String findMidPerm(String strng) {
        char[] sorted = strng.toCharArray();
        Arrays.sort(sorted);
        List<Character> chars = new ArrayList<>();
        for (char c : sorted) {
            chars.add(c);
        }
        String result = "";
        for (int i = 0; i < sorted.length; i++) {
            int index = (int) Math.floor((chars.size()-1) / 2L);
            if (index < 0)
                index = 0;
            result += chars.get(index);
            chars.remove(index);
        }
        return result;
    }

    private static long calculateFact(int size) {
        long fact = 1;
        for (int i = 2; i <= size; i++) {
            fact = fact * i;
        }
        return fact;
    }

}


