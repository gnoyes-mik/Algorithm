package baekjoon.step.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17087_숨바꼭질 {
    static StringTokenizer stk;

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());

        int[] A = new int[N];
        int[] tmp = new int[N];
        stk = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
            tmp[i] = Math.abs(S - A[i]);
        }

        int result = tmp[0];
        for (int i = 1; i < tmp.length; i++) {
            result = gcd(result,tmp[i]);
        }

        System.out.println(result);
        br.close();
    }
}
