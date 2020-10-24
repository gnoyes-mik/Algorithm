package baekjoon.step.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2304_창고다각형 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int size = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // index
            arr[i][1] = Integer.parseInt(st.nextToken()); // height
            size = Math.max(size, arr[i][0] + 1);
        }

        int si = 0, sv = 0;
        int[] map = new int[size];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i][0]] = arr[i][1];
            if (sv <= arr[i][1]) {
                sv = arr[i][1];
                si = arr[i][0];
            }
        }
        // map 셋팅 완료

        int[] lm = new int[size];
        lm[0] = map[0];
        for (int i = 1; i < si; i++) {
            lm[i] = Math.max(lm[i - 1], map[i]);
        }

        int[] rm = new int[size];
        rm[size - 1] = map[size - 1];
        for (int i = size - 2; i > si; i--) {
            rm[i] = Math.max(rm[i + 1], map[i]);
        }

        int ans = 0;

        for (int i = 0; i < size; i++) {
            if(si > i){
                ans += lm[i];
            }else if(si == i){
                ans += map[i];
            }else{
                ans += rm[i];
            }
        }
        System.out.println(ans);
    }
}
