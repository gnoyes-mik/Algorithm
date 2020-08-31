package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463_1로만들기 {

    static int[] d;

    private static int makeOneTD(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];

        d[n] = makeOneTD(n - 1) + 1;

        if (n % 2 == 0) {
            int tmp = makeOneTD(n / 2) + 1;
            if (d[n] > tmp) d[n] = tmp;
        }
        if (n % 3 == 0) {
            int tmp = makeOneTD(n / 3) + 1;
            if (d[n] > tmp) d[n] = tmp;
        }
        return d[n];
    }

    private static int makeOneBU(int n) {
        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
            }
            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
            }
            System.out.println("d[" + i + "] = " + d[i]);
        }
        return d[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        System.out.println(makeOneTD(n));
//        d = new int[n + 1];
//        System.out.println(makeOneBU(n));

    }
}
