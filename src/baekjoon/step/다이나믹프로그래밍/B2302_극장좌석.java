package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2302_극장좌석 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        int[] d = new int[41];

        // d[n] = n개의 요소들을 배치할 수 있는 경우의 수
        // d[3] = 3, d[4] = 5, d[5] = 8
        // => d[n] = d[n-2] + d[n-1]
        d[0] = 1; // 1
        d[1] = 1; // 1
        d[2] = 2; // 12 21

        for (int i = 3; i <= N; i++) {
            d[i] = d[i - 2] + d[i - 1];
        }

        int M = Integer.parseInt(br.readLine());
        int start = 0, stop = 0;
        for (int k = 0; k < M; k++) {
            stop = Integer.parseInt(br.readLine());
            ans *= d[stop - start - 1];
            start = stop;
        }
        ans *= d[N - stop];
        System.out.println(ans);

    }
}
