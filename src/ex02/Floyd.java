package ex02;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-03-15
 */
public class Floyd {
    //定义常量INF表示两点之间不存在路径，即距离无穷大
    private static final int INF = 100000;

    public static void main(String[] args) {
        Floyd();
    }

    public static void Floyd() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = INF;
            }
            dp[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            dp[u][v] = scanner.nextInt();
        }
        //更新任意两点之间的最短路径
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    dp[i][j] = Integer.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.printf(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
