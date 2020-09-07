package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class B11052_카드구매하기 {

    static int[] P;
    static int[] D;

    // D[n] = n개 카드를 구매할 때 최대 비용
    // D[n] = max(D[N-i] + P[i])
    // 1 <= i <= N
    public static void buyCard(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                D[i] = max(D[i], D[i - j] + P[j]);
            }
        }
        System.out.println(D[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        P = new int[N + 1];
        D = new int[N + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(stk.nextToken());
        }

        buyCard(N);

        br.close();
    }
}
