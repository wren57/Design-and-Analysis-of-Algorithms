package ex09;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-05-10
 */
public class LCS {

    static int MAX = 100;
    static int[][] C = new int[MAX][MAX];
    static int[][] B = new int[MAX][MAX];
    static String x, y, ans="";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.next();
        y = scanner.next();
        int m = x.length();
        x = " " + x;
        int n = y.length();
        y = " " + y;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (x.charAt(i) == y.charAt(j)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                    B[i][j] = 3;
                } else {
                    if (C[i][j - 1] >= C[i - 1][j]) {
                        C[i][j] = C[i][j - 1];
                        B[i][j] = 2;
                    } else {
                        C[i][j] = C[i - 1][j];
                        B[i][j] = 1;
                    }
                }
            }
        }
        System.out.println(C[m][n]);
        print(m, n);
    }

    static void print(int i, int j) {
        if (i == 0 || j == 0) {
            System.out.println(ans);
            return;
        }
        if (B[i][j] == 3) {
            ans = x.charAt(i) + ans;
            print(i - 1, j - 1);
        } else if (B[i][j] == 1) {
            print(i - 1, j);
        } else {
            print(i, j - 1);
        }
    }
}
