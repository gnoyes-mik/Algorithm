package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1<=N<=90
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][2];

        //이친수는 0으로 시작하지 않음
        //1이 연속되지 않음
        //D[N][L] = N자리 이친수의 개수, 마지막 수는 L
        //1) D[N][0] = D[n-1][0] + D[n-1][1]
        //2) D[N][1] = D[n-1][0]
        //3) 초기값 D[1][0] = 0, D[1][1] = 1
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }
        int result = dp[N][0] + dp[N][1];
        System.out.println(result);

    }
}
