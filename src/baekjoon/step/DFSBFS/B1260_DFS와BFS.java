package baekjoon.step.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260_DFS와BFS {
    static int N, M, V;
    static int[][] map;
    static boolean[] visited;
    static List<Integer> result;
//    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        init();
        dfs(V);
        print();

        init();
        bfs(V);
        print();
    }

    private static void init() {
        result = new ArrayList<>();
        visited = new boolean[N + 1];
        visited[0] = true;
    }

    private static void print() {
        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void dfs(int node) {
        visited[node] = true;
        result.add(node);

        for (int i = 1; i <= N; i++) {
            if (map[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int i = 1; i <= N; i++) {
                if (map[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
