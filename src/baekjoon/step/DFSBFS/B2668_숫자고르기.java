package baekjoon.step.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2668_숫자고르기 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result)
            System.out.println(x);
    }

    private static void dfs(int i, int origin) {
        if (!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i], origin);
            visited[arr[i]] = false;
        }
        if (arr[i] == origin) {
            result.add(arr[i]);
        }
    }
}
