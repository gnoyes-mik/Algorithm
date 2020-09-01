package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095_123더하기 {
    static int[] dp;

    private static int sum123(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (dp[n] > 0 ) return dp[n];
        dp[n] = sum123(n-3) + sum123(n-2) + sum123(n-1);
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1];
            System.out.println(sum123(n));
        }
        br.close();
    }
}
