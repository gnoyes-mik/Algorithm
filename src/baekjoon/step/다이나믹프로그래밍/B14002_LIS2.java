package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14002_LIS2 {
    static int[] A;
    static int[] dp;
    static int[] v;
    static void go(int p) {
        if (p == -1) return;
        go(v[p]);
        System.out.print(A[p] + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1<=N<=1000
        int N = Integer.parseInt(br.readLine());
        // 1<=A[i]<=1000
        A = new int[N];
        dp = new int[N];
        v = new int[N];

        Arrays.fill(dp, 1);

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(stk.nextToken());

        //D[i] = A[i]까지 수열이 있을때 A[i]를 마지막으로 하는 LIS의 길이
        //D[i] = max(A[j])+1      //A[i] 직전에 있는 수는 A[j] (A[i]-1아님)
        // j<i, A[j] < A[i]

        //v[i] = A[i]의 앞에 와야하는 수의 인덱스. 즉, A[i]의 앞에는 A[V[i]]가 와야 길이가 가장 길다

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            v[i] = -1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    v[i] = j;
                }
            }
        }
        int ans = dp[0];
        int p = 0;
        for (int i=0; i<N; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
                p = i;
            }
        }
        System.out.println(ans);
        go(p);
        System.out.println();

    }
}
