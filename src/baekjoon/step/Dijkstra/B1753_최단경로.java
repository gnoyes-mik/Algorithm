package baekjoon.step.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1753_최단경로 {
    static ArrayList<Node>[] graph;
    static int[] minCost;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int src = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        minCost = new int[V + 1];
        for (int i = 1; i <= V; i++) minCost[i] = (i == src ? 0 : INF);


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
//            graph[v].add(new Node(u, w));
        }

        dijkstra(minCost, src);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (i == src) {
                sb.append("0\n");
                continue;
            }

            if (minCost[i] == INF) {
                sb.append("INF\n");
                continue;
            }

            sb.append(minCost[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra(int[] minCost, int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.cost > minCost[now.idx]) continue;

            for (Node next : graph[now.idx]) {
                if (minCost[next.idx] > minCost[now.idx] + next.cost) {
                    minCost[next.idx] = minCost[now.idx] + next.cost;
                    pq.add(new Node(next.idx, minCost[next.idx]));
                }

            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
