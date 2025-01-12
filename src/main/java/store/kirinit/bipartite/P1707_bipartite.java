package store.kirinit.bipartite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707_bipartite {

    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            visited = new boolean[V+1];
            isEven = true;
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            // 에지 데이터 저장하기
            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int i = 1; i <= V; i++) {
                if (isEven) {
                    DFS(1);
                } else {
                    break;
                }
            }
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        for (int i : A[start]) { // 인접 리스트로 받아서 start에서 연결된 모든 노드를 탐색
            if (!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류 1, 0으로 분류
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            } else if (check[start] == check[i]) {
                isEven = false;
            }
        }
    }

}
