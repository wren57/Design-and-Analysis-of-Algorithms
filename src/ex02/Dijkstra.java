package ex02;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-03-15
 */
public class Dijkstra {
    private static final int INF = 10000;

    public static void main(String[] args) {
        Dijkstra();
    }

    public static void Dijkstra() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] edge = new int[n][n];
        int[] dis = new int[n];
        //将顶点通过visited数组分为已知最短路径的集合V`和未知最短路径的集合V-V`
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = INF;
            }
            edge[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edge[u][v] = scanner.nextInt();
        }
        for (int i = 0; i < n; ++i) dis[i] = edge[0][i];
        for (int i = 0; i < n - 1; ++i) {
            int min = INF;
            int index = 0;
            //遍历出集合V-V`中距离源点最近的顶点
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && dis[j] < min) {
                    min = dis[j];
                    index = j;
                }
            }
            visited[index] = true;
            //以当前顶点为中点迭代最短路径
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && edge[index][j] < INF) {
                    dis[j] = Integer.min(dis[j], dis[index] + edge[index][j]);
                }
            }
        }
        System.out.println(dis[n - 1]);
    }
}