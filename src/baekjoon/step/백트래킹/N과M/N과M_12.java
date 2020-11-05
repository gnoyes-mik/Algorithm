package baekjoon.step.백트래킹.N과M;

import java.io.*;
import java.util.*;

/**
 * Q N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - N과 M (5)와 다르게 N개의 자연수는 같은 수 일 수 있음
 * - N개의 자연수 중에서 M개를 고른 수열
 * - 같은 수를 여러 번 골라도 된다.
 * - 고른 수열은 비내림차순이어야 한다.
 * - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 * - 출력은 사전 순으로 증가하는 순서로
 */
public class N과M_12 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static Set<String> result;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        permutation(0, 0, "");

        for (String s : result)
            bw.write(s + "\n");
        bw.close();
    }

    private static void permutation(int idx, int cnt, String val) {
        if (cnt == M) {
            result.add(val);
            return;
        }

        for (int i = idx; i < N; i++) {
            permutation(i, cnt + 1, val + arr[i] + " ");
        }
    }
}
