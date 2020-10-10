package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14501_퇴사 {
    static int N;
    static int[][] schedule;
    static int maxProfit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        schedule = new int[N + 1][2];
        boolean[] worked = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(stk.nextToken());
            schedule[i][1] = Integer.parseInt(stk.nextToken());
        }

        maxProfit = 0;
        dfs(worked, 0, 1);
        System.out.println(maxProfit);
    }

    private static void dfs(boolean[] worked, int sum, int idx) {
        for (int i = idx; i < schedule.length; i++) {
            if (!worked[i] && i + schedule[i][0] - 1 <= N) {

                int k = i;

                while (k != i + schedule[i][0]) {
                    worked[k++] = true;
                }

                dfs(worked, sum + schedule[i][1], k);

                while (k != i - 1) {
                    worked[k - 1] = false;
                    k--;
                }

            }
        }
        if (maxProfit <= sum) {
            maxProfit = sum;
        }
    }
}
