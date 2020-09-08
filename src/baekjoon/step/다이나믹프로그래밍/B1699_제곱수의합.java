package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1699_제곱수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        //D[n] = 제곱 수의 합의 최소 개수
        //D[n-1] = min(D[n-i^2]) + 1
        // 1^2 <= i^2 <= N

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.println(dp[n]);
    }
}
