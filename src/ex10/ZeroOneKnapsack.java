package ex10;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-06-21
 */
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        int[] dp = new int[c + 1];
        int[] flag = new int[c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = c; j >= w[i]; --j) {
                if (dp[j - w[i]] + 1 > dp[j]) {
                    dp[j] = dp[j - w[i]] + 1;
                    flag[j] = 1;
                }
            }
        }
        System.out.println("最多可承载集装箱数量为：" + dp[c]);
        System.out.print("装载的集装箱编号为：");
        int k = c, i = n - 1;
        while (k > 0) {
            if (flag[k] == 1) {
                System.out.print((i + 1) + " ");
                k -= w[i];
            }
            --i;
        }
    }
}
