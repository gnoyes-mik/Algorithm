package baekjoon.step.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] map = new int[W];

        st = new StringTokenizer(br.readLine());

        int si = 0, sv = 0;
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            if (sv <= map[i]) {
                sv = map[i];
                si = i;
            }
        }
        int[] lm = new int[W];
        lm[0] = map[0];
        for (int i = 1; i < si; i++) {
            lm[i] = Math.max(lm[i - 1], map[i]);
        }

        int[] rm = new int[W];
        rm[W - 1] = map[W - 1];
        for (int i = W - 2; i > si; i--) {
            rm[i] = Math.max(rm[i + 1], map[i]);
        }

        int ans = 0;

        for (int i = 0; i < W; i++) {
            if (i < si) {
                ans += lm[i] - map[i];
            } else if (i > si) {
                ans += rm[i] - map[i];
            }
        }
        System.out.println(ans);
    }
}
