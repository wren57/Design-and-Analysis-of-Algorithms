package ex03;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-03-22
 */
public class Search {
    public static void main(String[] args) {
        int[] a;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        while (true) {
            int x = scanner.nextInt();
            if (x == -1) break;
            System.out.println("Sequential Search: " + sequentialSearch(a, x));
            System.out.println("Binary Search: " + binarySearch(a, x));
        }
    }

    public static int sequentialSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i + 1;
            }
            if (a[i] > x) {
                break;
            }
        }
        return 0;
    }

    public static int binarySearch(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == x) {
                return m + 1;
            }
            if (a[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return 0;
    }
}