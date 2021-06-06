package ex11;

import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-05-25
 */
public class Huffman {

    private static int s1, s2;
    private static String[] HCode;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();    //字符集
        int n = str.length();
        int[] weights = new int[n]; //每个字符的权重
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        Node[] HT = null;
        create(HT, weights, n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%c:%s\n", str.charAt(i), HCode[i]);
        }
    }

    public static void create(Node[] tree, int[] weights, int n) {
        int total = 2 * n - 1;
        tree = new Node[total];
        for (int i = 0; i < total; ++i) {
            tree[i]=new Node();
            if (i < n) {
                tree[i].weight = weights[i];
            } else {
                tree[i].weight = 0;
            }
        }
        for (int i = n; i < total; ++i) {
            selectMin(tree, i - 1);
            tree[s1].parent = tree[s2].parent = tree[i];
            tree[i].left = tree[s1];
            tree[i].right = tree[s2];
            tree[i].weight = tree[s1].weight + tree[s2].weight;
        }
        char[] cd = new char[n];
        HCode = new String[n];
        cd[n - 1] = '\0';
        int start;
        for (int i = 0; i < n; ++i) {
            start = n - 1;
            Node f = tree[i].parent;
            for (Node j = tree[i]; f != null; j = f, f = f.parent) {
                if (f.left == j) {
                    cd[--start] = '0';
                } else {
                    cd[--start] = '1';
                }
            }
            HCode[i] = String.copyValueOf(cd);
        }
    }

    public static void selectMin(Node[] tree, int n) {
        int min = 1;
        for (int i = 0; i < n; i++) {
            if (tree[i].parent == null) {
                min = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (tree[i].parent == null && tree[i].weight < tree[min].weight) {
                min = i;
            }
        }
        s1 = min;
        for (int i = 0; i < n; i++) {
            if (tree[i].parent == null && i != s1) {
                min = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (tree[i].parent == null && tree[i].weight < tree[min].weight && i != s1) {
                min = i;
            }
        }
        s2 = min;
    }
}

class Node {
    int weight;
    Node parent, left, right;
}

