package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        //D[i] = i번째 수로 끝나는 가장 큰 연속합
        //i번째 수가 i-1번째와 연속인 경우와 연속이 아닌 경우
        //D[i-1] = D[i-1]+A[i]
        //D[i-1] = A[i]
        //D[i] = max(D[i-1]+A[i] , A[i])

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        arr[0] = Integer.parseInt(stk.nextToken());
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());

            int tmp = dp[i - 1] + arr[i];
            dp[i] = Math.max(tmp, arr[i]);
        }
        int max = -1001;
        for (int x : dp) {
            if (x >= max) {
                max = x;
            }
        }
        System.out.println(max);
    }
}
