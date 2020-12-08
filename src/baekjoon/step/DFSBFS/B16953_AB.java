package baekjoon.step.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B16953_AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");

        int A = Integer.parseInt(tmp[0]);
        int B = Integer.parseInt(tmp[1]);
        int ans = 0;

        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
                ans++;
                continue;
            }
            String val = String.valueOf(B);
            if (val.substring(val.length() - 1).equals("1")) {
                B = Integer.parseInt(val.substring(0, val.length() - 1));
                ans++;
            } else {
                break;
            }
        }

        if (B == A)
            System.out.println(ans + 1);
        else
            System.out.println(-1);
    }
}
