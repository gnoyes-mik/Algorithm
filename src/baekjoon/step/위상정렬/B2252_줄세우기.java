package baekjoon.step.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2252_줄세우기 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            list[a].add(b);
            indegree[b]++;
        }

        topologicalSort(indegree, list);
    }

    static void topologicalSort(int[] indegree, ArrayList<Integer>[] list){
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.peek()+" ");
            int current = queue.poll();

            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
    }
}
