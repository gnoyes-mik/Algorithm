package baekjoon.step.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018_체스판다시칠하기 {
    static int N, M, ans;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = row[j].equals("W") ? 1 : -1;
            }
        }

        ans = 64;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                ans = Math.min(ans, checkColor(i, j, board[i][j]));
                ans = Math.min(ans, checkColor(i, j, board[i][j] * -1));
            }
        }
        System.out.println(ans);
    }

    private static int checkColor(int i, int j, int color) {
        int change = 0;

        for (int k = i; k < i + 8; k++) {
            for (int l = j; l < j + 8; l++) {
                int idx = l - j;
                if (idx % 2 == 0 && color != board[k][l]) change++;
                if (idx % 2 == 1 && (color * -1) != board[k][l]) change++;
            }
            color *= -1;
        }
        return change;
    }
}
