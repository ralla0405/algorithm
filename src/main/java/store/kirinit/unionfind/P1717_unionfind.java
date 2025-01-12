package store.kirinit.unionfind;

import java.util.Scanner;

public class P1717_unionfind {
    static int parent[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        // 질의 실행
        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (question == 0) { // union
                union(a, b);
            } else { // 두 원소 같은지 확인
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        // 대표 노드를 찾아서 연결
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a; // 두 개 연결
        }
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        else
            return parent[a] = find(parent[a]); // a의 대표노드 값을 변경하여 저장 필수(경로 압축)
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        return false;
    }
}
