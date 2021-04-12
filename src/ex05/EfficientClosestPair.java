package ex05;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-04-12
 */
public class EfficientClosestPair {
    public static int[] index = new int[100];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; ++i) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        System.out.println(closestPair(points, 0, n - 1));
    }

    public static double closestPair(Point[] S, int left, int right) {
        double minDist;
        //返回由蛮力算法求出的最小距离
        if (right - left <= 2) {
            minDist = Integer.MAX_VALUE;
            for (int i = left; i < right; ++i) {
                for (int j = i + 1; j <= right; ++j) {
                    double dist = distance(S[i], S[j]);
                    minDist = Math.min(minDist, dist);
                }
            }
        } else {
            int mid = (left + right) / 2;
            minDist = Math.min(closestPair(S, left, mid), closestPair(S, mid + 1, right));
            int cnt = 0;
            for (int i = left; i <= right; ++i) {
                if (S[i].x >= S[mid].x - minDist && S[i].x <= S[mid].x + minDist) {
                    index[cnt++] = i;
                }
            }
            for (int i = 0; i < cnt; ++i) {
                for (int j = i + 1; j < cnt; ++j) {
                    if (S[index[i]].y > S[index[j]].y) {
                        Point temp = S[index[i]];
                        S[index[i]] = S[index[j]];
                        S[index[j]] = temp;
                    }
                }
            }
            for (int i = 0; i < cnt; ++i) {
                for (int j = i + 1; j < Math.min(i + 7, cnt); ++j) {
                    if (S[index[j]].y - S[index[i]].y > minDist) {
                        break;
                    }
                    minDist = Math.min(minDist, distance(S[index[i]], S[index[j]]));
                }
            }
        }
        return minDist;
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return this.x - o.x;
    }
}