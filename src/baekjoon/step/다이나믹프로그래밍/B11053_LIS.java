package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11053_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1<=N<=1000
        int N = Integer.parseInt(br.readLine());
        // 1<=A[i]<=1000
        int[] A = new int[N];
        int[] dp = new int[N];

        Arrays.fill(dp, 1);

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(stk.nextToken());

        //D[i] = A[i]까지 수열이 있을때 A[i]를 마지막으로 하는 LIS의 길이
        //D[i] = max(A[j])+1      //A[i] 직전에 있는 수는 A[j] (A[i]-1아님)
        // j<i, A[j] < A[i]

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int x : dp) {
            if (x >= max)
                max = x;
        }
        System.out.println(max);

    }
}
