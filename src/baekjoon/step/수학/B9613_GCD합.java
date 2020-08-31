package baekjoon.step.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9613_GCD합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);

            long sum = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    sum += gcd(Integer.parseInt(strArr[i]), Integer.parseInt(strArr[j]));
                }
            }
            System.out.println(sum);
        }
        br.close();
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
