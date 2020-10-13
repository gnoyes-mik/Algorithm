package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14889_스타트와링크 {
    static int[][] table;
    static int N;
    static int[] team;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        table = new int[N + 1][N + 1];
        team = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                table[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        match(1, 0);
        System.out.println(minDiff);
    }


    private static void match(int idx, int playerCount) {
        if (playerCount == N / 2) {
            calculate();
            return;
        }

        for (int i = idx; i <= N; i++) {
                team[i] = 1;
                match(i + 1, playerCount + 1);
                team[i] = 0;
        }
    }

    private static void calculate() {
        int[] startTeam = new int[N / 2];
        int[] linkTeam = new int[N / 2];
        int startCount = 0;
        int linkCount = 0;

        for (int i = 1; i <= N; i++) {
            if (team[i] == 1) {
                startTeam[startCount++] = i;
            } else{
                linkTeam[linkCount++] = i;
            }
        }

        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                startSum += table[startTeam[i]][startTeam[j]] + table[startTeam[j]][startTeam[i]];
                linkSum += table[linkTeam[i]][linkTeam[j]] + table[linkTeam[j]][linkTeam[i]];
            }
        }

        minDiff = Math.min(minDiff, Math.abs(startSum - linkSum));
    }
}
