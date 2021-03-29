package ex04;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-03-29
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        mergeSort(a, 0, n - 1);
        for (int i = 0; i < n; ++i) System.out.print(a[i] + " ");
    }

    public static void mergeSort(int[] a, int l, int r) {
        int m = (l + r) / 2;
        if (l < r) {
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void merge(int[] a, int l, int m, int r) {
        int l1 = l, l2 = m, r1 = m + 1, r2 = r;
        int[] temp = new int[r - l + 1];
        int cnt = 0;
        while (l1 <= l2 && r1 <= r2) {
            if (a[l1] < a[r1]) {
                temp[cnt++] = a[l1++];
            } else {
                temp[cnt++] = a[r1++];
            }
        }
        while (l1 <= l2) {
            temp[cnt++] = a[l1++];
        }
        while (r1 <= r2) {
            temp[cnt++] = a[r1++];
        }
        for (int i = l; i <= r; ++i) {
            a[i] = temp[i - l];
        }
    }
}