package baekjoon.step.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2644_촌수계산 {
    static int n, m;
    static int a, b;
    static int[][] tree;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        tree = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x][y] = 1;
            tree[y][x] = 1;
        }

        bfs(new Node(a, 0));
    }

    private static void bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.n == b) {
                System.out.println(node.count);
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (tree[node.n][i] == 1 && !visited[node.n][i]) {
                    visited[node.n][i] = true;
                    visited[i][node.n] = true;
                    queue.offer(new Node(i, node.count + 1));
                }
            }
        }
        System.out.println(-1);
    }

    static class Node {
        int n, count;

        Node(int n, int count) {
            this.n = n;
            this.count = count;
        }
    }
}
