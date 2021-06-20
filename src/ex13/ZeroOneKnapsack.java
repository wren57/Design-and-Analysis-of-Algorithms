package ex13;

import java.util.Scanner;

import static java.lang.Math.max;


/**
 * @author WangJiayi
 * @since 2021-06-19
 */
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //任务数量
        int n = scanner.nextInt();
        //n项任务各自的加工时间ti
        int[] t = new int[n];
        //加工总时间
        int total = 0;
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
            total += t[i];
        }
        //二分加工时间
        int half = total / 2;
        //dp[i][j]为前i件任务在加工时间不超过j时实际需要的时间
        int[][] dp = new int[n][half + 1];
        //路径记录,path[i][j]=1表示任务i的加工时间不大于j并且交由本机器执行
        int[][] path = new int[n][half + 1];
        //初始化第一行dp
        for (int i = 0; i <= half; ++i) {
            dp[0][i] = i >= t[0] ? t[0] : 0;
        }
        //核心代码
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= half; j++) {
                if (j < t[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - t[i]] + t[i]);
                    path[i][j] = 1;
                }
            }
        }
        System.out.println("最少加工时间：" + (total - dp[n - 1][half]));
        //路径求解
        int i = n - 1, j = half;
        int[] flag = new int[n];
        System.out.print("机器1加工任务：");
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.print(i + 1 + " ");
                flag[i] = 1;
                j -= t[i];
            }
            --i;
        }
        System.out.print("\n机器2加工任务：");
        for (int k = 0; k < n; k++) {
            if (flag[k] == 0) {
                System.out.print(k + 1 + " ");
            }
        }
    }
}
