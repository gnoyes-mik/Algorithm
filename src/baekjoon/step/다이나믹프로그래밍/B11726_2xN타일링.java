package baekjoon.step.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726_2xN타일링 {
    static int[] d;

    // D[n] = "2xn 크기의 직사각형을 타일로 채우는 방법의 수"
    // D[n] = D[n-1] + D[n-2]
    public static int tiling(int n) {
        if (n <= 2) {
            d[n] = n;
            return n;
        } else if (d[n] > 0) {
            return d[n];
        }
        d[n] = tiling(n - 1) + tiling(n - 2);
        return d[n] % 10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        System.out.println(tiling(n));

        br.close();
    }
}
