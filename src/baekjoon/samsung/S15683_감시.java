package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. CCTV 리스트를 저장
 * 2. CCTV의 모든 방향에 대한 조합을 구한다(dfs)
 * 3. 각 경우의 사각지대를 구한다
 * ## watched(visited같은) 배열의 초기화를 잊지 말자
 */


public class S15683_감시 {

    static int N, M, result;
    static int[][] map;
    static boolean[][] watched;
    static List<CCTV> cctvList;
    static int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];
        watched = new boolean[N][M];

        cctvList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvList.add(new CCTV(i, j, map[i][j], 0));
                }
            }
        }
        result = 100;
        dfsComb(0);

        System.out.println(result);
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(watched[i], false);
        }
    }

    private static void dfsComb(int idx) {
        if (idx == cctvList.size()) {
            init();

            for (CCTV cctv : cctvList)
                check(cctv);

            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    if (!watched[i][j] && map[i][j] == 0) {
                        cnt++;
                    }
            }

            result = Math.min(result, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            cctvList.get(idx).d = i;
            dfsComb(idx + 1);
        }
    }

    private static void check(CCTV cctv) {
        switch (cctv.n) {
            case 1: // 한쪽
                calculateMonitorZone(cctv.x, cctv.y, cctv.d);
                break;
            case 2: // 양쪽
                calculateMonitorZone(cctv.x, cctv.y, cctv.d);
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d + 2) % 4);
                break;
            case 3: // ㄴ
                calculateMonitorZone(cctv.x, cctv.y, cctv.d);
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d + 1) % 4);
                break;
            case 4: // ㅗ
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d) % 4);
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d + 1) % 4);
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d + 2) % 4);
                break;
            case 5: // +
                calculateMonitorZone(cctv.x, cctv.y, cctv.d);
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d + 1) % 4);
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d + 2) % 4);
                calculateMonitorZone(cctv.x, cctv.y, (cctv.d + 3) % 4);
                break;
        }
    }

    private static void calculateMonitorZone(int x, int y, int d) {
        int[] dir = direction[d];
        int tmpX = x + dir[0];
        int tmpY = y + dir[1];

        while (tmpX >= 0 && tmpX < N && tmpY >= 0 && tmpY < M && map[tmpX][tmpY] != 6) {
            if (map[tmpX][tmpY] == 0 && !watched[tmpX][tmpY]) {
                watched[tmpX][tmpY] = true;
            }
            tmpX += dir[0];
            tmpY += dir[1];
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (watched[i][j]) System.out.print("# ");
                else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}

class CCTV {
    int x, y, n, d;

    public CCTV(int x, int y, int n, int d) {
        this.x = x;
        this.y = y;
        this.n = n;
        this.d = d;
    }
}
