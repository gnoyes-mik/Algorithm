package baekjoon.step.백트래킹.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Q 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * - 고른 수열은 오름차순이어야 한다.
 */
public class N과M_2 {
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dfs(1, 0, "");
    }

    private static void dfs(int idx, int cnt, String val) {
        if (cnt == M) {
            System.out.println(val);
            return;
        }

        for (int i = idx; i <= N; i++) {
            dfs(i + 1, cnt + 1, val + i + " ");
        }
    }
}
