package ex07;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-04-25
 */
public class InvestDP {
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt() + 1;
        m = scanner.nextInt() + 1;
        int[][] f = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                f[i][j] = scanner.nextInt();
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                dp[i][j] = 0;
                for (int k = 0; k <= j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], f[i][k] + dp[i - 1][j - k]);
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
