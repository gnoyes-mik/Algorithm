package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10844_쉬운계단수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1 <= N <= 100
        int N = Integer.parseInt(br.readLine());
        int mod = 1000000000;
        long[][] dp = new long[101][11];

        //D[N][L] = D[N-1][L-1] + D[N-1][L+1]
        //if(L==0) D[N][L] = D[N-1][L+1]
        //if(L==9) D[N][L] = D[N-1][L-1]

        for (int i = 1; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if(j==0) {
                    dp[i][j] = dp[i - 1][j + 1];
                    continue;
                }
                if(j==9) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;
            }
        }
        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[N][i];
        }
        System.out.println(result % mod);
    }
}