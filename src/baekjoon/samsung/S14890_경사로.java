package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S14890_경사로 {

    static int N;
    static int L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (go(i, 0, 0)) {
                count++;
            }
            if (go(0, i, 1)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean go(int x, int y, int direction) {
        int[] road = new int[N];
        boolean[] built = new boolean[N];

        for (int i = 0; i < N; i++) {
            road[i] = (direction == 0) ? map[x][y + i] : map[x + i][y];
        }

        for (int i = 0; i < N - 1; i++) {
            if (road[i] == road[i + 1]) continue;

            if (Math.abs(road[i] - road[i + 1]) > 1) return false;

            if (road[i] + 1 == road[i + 1]) { // 오르막
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || road[i] != road[j] || built[j]) {
                        return false;
                    }
                    built[j] = true;
                }
            } else if (road[i] - 1 == road[i + 1]) { // 내리막
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || road[i + 1] != road[j] || built[j]) {
                        return false;
                    }
                    built[j] = true;
                }
            }
        }
        return true;
    }
}








