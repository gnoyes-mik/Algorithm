package baekjoon.step.백트래킹.N과M;

import java.io.*;
import java.util.*;

/**
 * Q N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
 * - N개의 자연수 중에서 M개를 고른 수열
 * - 같은 수를 여러 번 골라도 된다.
 * - 고른 수열은 비내림차순이어야 한다.
 * - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 * - 출력은 사전 순으로 증가하는 순서로
 */
public class N과M_8 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        bw.close();
    }

    private static void dfs(int idx, int cnt, String val) throws IOException {
        if (cnt == M) {
            bw.write(val + "\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            dfs(i, cnt + 1, val + arr[i] + " ");
        }
    }
}
