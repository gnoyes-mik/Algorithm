package baekjoon.step.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2623_음악프로그램 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        int[] indegree = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int pd = Integer.parseInt(stk.nextToken()); // 담당 PD

            int a = Integer.parseInt(stk.nextToken());

            while (stk.hasMoreTokens()) {
                int b = Integer.parseInt(stk.nextToken());

                list[a].add(b);
                indegree[b]++;
                a = b;
            }
        }
        ArrayList<Integer> result = topologicalSort(indegree, list);
        if (result.size() == N){
            for (int x : result)
                System.out.println(x);
            return;
        }
        System.out.println(0);
    }

    static ArrayList<Integer> topologicalSort(int[] indegree, ArrayList<Integer>[] list) {
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        return result;
    }
}
