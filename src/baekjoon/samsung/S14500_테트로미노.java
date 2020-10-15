package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14500_테트로미노 {
    static int N, M, result;
    static int[][] map;
    static boolean[][] put;
    static int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        put = new boolean[N][M];

        result = 0;

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0, 0);
                getExtraShape(i, j);
            }
        }
        System.out.println(result);
    }

    // ㅗ모양 제외하고 나머지 (나머지 모양들은 dfs 깊이가 4인 경로들과 같음)
    private static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int[] dir : direction) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }
            if (put[nextX][nextY]) {
                continue;
            }
            put[nextX][nextY] = true;
            dfs(nextX, nextY, depth + 1, sum + map[nextX][nextY]);
            put[nextX][nextY] = false;
        }
    }

    // ㅗ 모양 구하기
    // + 모양(날개 4개)에서 날개 하나 빼기
    private static void getExtraShape(int x, int y) {

        int wing = 4;
        int min = 999999;
        int sum = map[x][y];

        for (int[] dir : direction) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (wing <= 2) {
                return;
            }

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                wing--;
                continue;
            }

            min = Math.min(min, map[nextX][nextY]);
            sum += map[nextX][nextY];

        }
        if (wing == 4) {
            sum -= min;
        }

        result = Math.max(result, sum);

    }

}
