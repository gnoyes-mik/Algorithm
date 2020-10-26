package baekjoon.step.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int title = 665;


        while (N > 0) {
            title++;
            String str = Integer.toString(title);

            if (str.contains("666"))
                N--;
        }

        System.out.println(title);
    }
}
