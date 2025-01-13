package store.kirinit.combination;

import java.util.Scanner;

// 이항 계수
public class P11050_combination {
    static int N, K;
    static int D[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N + 1][N + 1];
        // 초기화
        for (int i = 0; i <= N; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }

        // 점화식으로 배열 완성
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
            }
        }
        System.out.println(D[N][K]);
    }
}
