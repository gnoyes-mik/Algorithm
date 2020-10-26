package baekjoon.step.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231_분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int constructor = N;

        for (int i = N - 1; i > -1; i--) {
            int tmp = i;
            String num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                tmp += Integer.parseInt(num.substring(j, j + 1));
            }
            if (tmp == N) {
                constructor = Math.min(constructor, i);
            }
        }
        if (constructor == N) System.out.println(0);
        else System.out.println(constructor);
    }
}
