package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S13458_시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(stk.nextToken());
        int C = Integer.parseInt(stk.nextToken());

        long min = 0;
        for (int i = 0; i < N; i++) {
            list[i] -= B;
            min++;
            if (list[i] > 0) {
                int tmp = list[i] / C;
                min += tmp;
                if (list[i] - tmp*C > 0) min++;
            }
        }
        System.out.println(min);
    }
}