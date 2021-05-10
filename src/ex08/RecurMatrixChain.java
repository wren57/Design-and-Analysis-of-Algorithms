package ex08;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-04-26
 */
public class RecurMatrixChain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n + 1];
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            p[i] = scanner.nextInt();
        }
        for (int r = 2; r <= n; ++r) {
            for (int i = 1; i <= n - r + 1; ++i) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                for (int k = i + 1; k <= j - 1; ++k) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                    }
                }
            }
        }
        System.out.println(m[1][n]);
    }
}
