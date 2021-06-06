package ex12;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-06-06
 */
public class mColor {

    private static final int MAX_SIZE = 500;
    private static int[][] graph = new int[MAX_SIZE][MAX_SIZE];
    private static int[] color = new int[MAX_SIZE];
    private static int n, m, cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            graph[a][b] = graph[b][a] = 1;
        }
        backtrack(1);
        if (cnt != 0) {
            System.out.println("Total=" + cnt);
        } else {
            System.out.println("NO");
        }
    }

    public static void backtrack(int cur) {
        if (cur > n) {
            for (int i = 1; i <= n; ++i) {
                System.out.print(color[i] + " ");
            }
            ++cnt;
            System.out.println();
        } else {
            for (int i = 1; i <= m; i++) {
                color[cur] = i;
                if (check(cur)) {

                    backtrack(cur + 1);
                }
                color[cur] = 0;
            }

        }
    }

    public static boolean check(int x) {
        for (int i = 1; i <= n; i++) {
            if (graph[x][i] != 0 && color[x] == color[i]) {
                return false;
            }
        }
        return true;
    }
}
