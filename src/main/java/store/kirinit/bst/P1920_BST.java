package store.kirinit.bst;

import java.util.Arrays;
import java.util.Scanner;

// 백준 P1920 문제 - 이진 탐색 구현
public class P1920_BST {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = A.length - 1;
            while (start <= end) {
                int midIndex = (start + end) / 2;
                int midValue = A[midIndex];
                if (midValue > target) {
                    end = midIndex - 1;
                } else if (midValue < target) {
                    start = midIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }
            System.out.println(find ? 1 : 0);
        }
    }


}
