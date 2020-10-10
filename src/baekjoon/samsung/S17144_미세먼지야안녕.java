package baekjoon.samsung;

import java.util.Scanner;

public class S17144_미세먼지야안녕 {

    static int[][] map;
    static int[][] airCleanerPos;
    static int R;
    static int C;
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt(); // 행
        C = sc.nextInt(); // 열
        T = sc.nextInt(); // 초

        map = new int[R][C];
        airCleanerPos = new int[2][2];


        int aCP = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int val = sc.nextInt();
                map[i][j] = val;
                if (val == -1) {
                    airCleanerPos[aCP++] = new int[]{i, j};
                }
            }
        }
        while (T > 0) {
            spreadDust();
            T--;
        }
        System.out.println(sumDust());
    }

    public static void spreadDust() {
        int[][] tempMap = new int[R][C];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != 0 && map[i][j] != -1) {
                    int dCnt = 0;
                    for (int[] d : dir) {
                        int tempX = i + d[0];
                        int tempY = j + d[1];
                        if (tempX >= 0 && tempX < R && tempY >= 0 && tempY < C && map[tempX][tempY] != -1) {
                            tempMap[tempX][tempY] += map[i][j] / 5;
                            dCnt++;
                        }
                    }
                    map[i][j] -= map[i][j] / 5 * dCnt;
                }
            }
        }
        sum(tempMap);
        refresh();
    }

    public static void sum(int[][] tmp) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += tmp[i][j];
            }
        }
    }

    public static void refresh() {
        int x1 = airCleanerPos[0][0];
        int y1 = airCleanerPos[0][1];
        int x2 = airCleanerPos[1][0];
        int y2 = airCleanerPos[1][1];

        // 공기 청정기 바람 순환
        //공청기1
        //아래
        for (int i = x1 - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        //왼쪽
        for (int j = 0; j < C - 1; j++) {
            map[0][j] = map[0][j + 1];
        }
        //위쪽
        for (int i = 0; i < x1; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        //오른쪽
        for (int j = C - 1; j > 0; j--) {
            map[x1][j] = map[x1][j - 1];
        }
        map[x1][1] = 0;

        //공청기2
        //위
        for (int i = x2 + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        //왼쪽
        for (int j = 0; j < C - 1; j++) {
            map[R - 1][j] = map[R - 1][j + 1];
        }
        //아래
        for (int i = R - 1; i > x2; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        //오른쪽
        for (int j = C - 1; j > 0; j--) {
            map[x2][j] = map[x2][j - 1];
        }
        map[x2][1] = 0;
    }

    static int sumDust() {
        int total = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    total += map[i][j];
                }
            }
        }
        return total;
    }
}
