package baekjoon.step.백트래킹.N과M;

import java.io.*;
import java.util.*;

/**
 * Q N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - N과 M (5)와 다르게 N개의 자연수는 같은 수 일 수 있음
 * - N개의 자연수 중에서 M개를 고른 수열
 * - 출력은 사전 순으로 증가하는 순서로
 */
public class N과M_9 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static Set<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        visited = new boolean[N + 1];
        result = new LinkedHashSet<>();

        Arrays.sort(arr);

        permutation(0, "");

        for (String s : result)
            System.out.println(s);
    }

    private static void permutation(int cnt, String val) {
        if (cnt == M) {
            result.add(val);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(cnt + 1, val + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}
