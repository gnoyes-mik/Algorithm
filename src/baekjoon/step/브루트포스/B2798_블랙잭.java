package baekjoon.step.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2798_블랙잭 {
    static int N, M, ans;
    static int[] cards;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        used = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int idx, int sum) {
        if (sum > M) return;
        if (idx == 3) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!used[i]) {
                sum += cards[i];
                used[i] = true;
                dfs(idx + 1, sum);
                sum -= cards[i];
                used[i] = false;
            }
        }
    }
}
