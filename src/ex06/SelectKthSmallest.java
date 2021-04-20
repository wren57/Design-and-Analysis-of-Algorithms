package ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-04-19
 */
public class SelectKthSmallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; ++i) {
            a[i] = scanner.nextInt();
        }
        select(a, n, k);
    }

    public static void select(Integer[] a, int n, int k) {
        ArrayList<Integer> midArray = new ArrayList<>();
        // 五元分组排序
        for (int i = 0; i < n; i += 5) {
            int length = Math.min(5, n - i);
            Arrays.sort(a, i, i + length);
            midArray.add(a[i + (length - 1) / 2]);
        }
        Collections.sort(midArray);
        // 从中位数数组中选出m*
        int mid = midArray.get((midArray.size() - 1) / 2);
        ArrayList<Integer> s1 = new ArrayList<>();
        ArrayList<Integer> s2 = new ArrayList<>();
        for (int i = 0; i < n; i += 5) {
            // 规模<5的数组直接遍历分组
            if (n - i < 5) {
                for (int j = i; j < n; ++j) {
                    if (a[j] > mid) {
                        s2.add(a[j]);
                    } else {
                        s1.add(a[j]);
                    }
                }
                break;
            }
            if (a[i + 2] < mid) {
                for (int j = i; j <= i + 2; ++j) {
                    s1.add(a[j]);
                }
                for (int j = i + 3; j < i + 5; ++j) {
                    if (a[j] > mid) {
                        s2.add(a[j]);
                    } else {
                        s1.add(a[j]);
                    }
                }
            } else if (a[i + 2] > mid) {
                for (int j = i + 3; j < i + 5; ++j) {
                    s2.add(a[j]);
                }
                for (int j = i; j <= i + 2; ++j) {
                    if (a[j] > mid) {
                        s2.add(a[j]);
                    } else {
                        s1.add(a[j]);
                    }
                }
            } else {
                for (int j = i; j < i + 2; ++j) {
                    s1.add(a[j]);
                }
                for (int j = i + 3; j < i + 5; ++j) {
                    s2.add(a[j]);
                }
            }
        }
        int num1 = s1.size();
        int num2 = s2.size();
        if (k == num1 + 1) {
            System.out.println(mid);
            return;
        } else if (k <= num1) {
            Integer[] temp = new Integer[num1];
            s1.toArray(temp);
            select(temp, num1, k);
        } else {
            Integer[] temp = new Integer[num2];
            s2.toArray(temp);
            select(temp, num2, k - num1 - 1);
        }
    }
}
