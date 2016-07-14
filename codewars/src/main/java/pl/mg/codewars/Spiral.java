package pl.mg.codewars;

/**
 * Your objective is to complete a function createSpiral(N) that receives an integer N and returns two-dimensional array where numbers from 1 to N should be represented as clockwise spiral.

Return an empty array if N < 1

Examples:

N = 4 Output: [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]

1   2   3   4
12  13  14  5
11  16  15  6
10  9   8   7
 * @author Maciej Gzik
 *
 */
public class Spiral {
    public static int[][] createSpiral(int N) {
        int A[][] = new int[N][N];
        int k = 1, c1 = 0, c2 = N - 1, r1 = 0, r2 = N - 1;

        while (k <= N * N) {
            for (int i = c1; i <= c2; i++) {
                A[r1][i] = k++;
            }

            for (int j = r1 + 1; j <= r2; j++) {
                A[j][c2] = k++;
            }

            for (int i = c2 - 1; i >= c1; i--) {
                A[r2][i] = k++;
            }

            for (int j = r2 - 1; j >= r1 + 1; j--) {
                A[j][c1] = k++;
            }

            c1++;
            c2--;
            r1++;
            r2--;
        }
        return A;
    }

}
