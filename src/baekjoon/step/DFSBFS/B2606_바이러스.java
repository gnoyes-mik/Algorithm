package baekjoon.step.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B2606_바이러스 {
    static int[][] node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        node = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < K; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            node[a][b] = 1;
            node[b][a] = 1;
        }

        bfs(1);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        int cnt = 0;
        while(!queue.isEmpty()){
            int x = queue.poll();

            for (int i = 1; i < node.length; i++) {
                if(node[x][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
