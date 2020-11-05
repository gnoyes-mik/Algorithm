package baekjoon.step.백트래킹.N과M;

import java.io.*;
import java.util.*;

/**
 * Q N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
 * - N개의 자연수 중에서 M개를 고른 수열
 * - 고른 수열은 오름차순이어야 한다.
 * - 출력은 사전 순으로 증가하는 순서로
 */
public class N과M_6 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0, "");

    }

    private static void dfs(int idx, int cnt, String val) {
        if (cnt == M) {
            System.out.println(val);
            return;
        }

        for (int i = idx; i < N; i++) {
            dfs(i + 1, cnt + 1, val + arr[i] + " ");
        }
    }
}
