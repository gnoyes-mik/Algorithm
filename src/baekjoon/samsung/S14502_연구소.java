package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 벽을 세운다(벽 세우고 -> DFS -> 벽 허물고)
 * 2. 벽을 3개 세우면 바이러스를 퍼트린다(BFS)
 * 3. 다 퍼트려 지면 안전구역을 계산한다
 * 4. 안전구역 수를 최신화 한뒤 2번부터 반복한다
 */
public class S14502_연구소 {
    static int N;
    static int M;
    static int safeZone;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        int[][] map = new int[N][M];

        safeZone = 0;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());

                if (map[i][j] == 0) safeZone++;
            }
        }
        // 새로 추가되는 벽 3개로 인한 안전구역 3 감소
        safeZone -= 3;
        max = 0;
        walling(map, 0, 0, 0);
        System.out.println(max);
    }

    private static void walling(int[][] map, int row, int col, int count) {
        if (count == 3) {
            calculateSafeZone(map);
        } else {
            if (col >= M) {
                walling(map, row + 1, 0, count);
                return;
            }

            if (row >= N) {
                return;
            }

            if (map[row][col] == 0) {
                map[row][col] = 1;
                walling(map, row, col + 1, count + 1);
                map[row][col] = 0;
            }
            walling(map, row, col + 1, count);
        }
    }

    private static void calculateSafeZone(int[][] map) {
        int tmpSafeZone = safeZone;

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    tmpSafeZone -= spreadVirus(copyMap, i, j);
                }
            }
        }

        max = Math.max(max, tmpSafeZone);

    }

    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int spreadVirus(int[][] map, int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        int virusZone = 0;

        while (!q.isEmpty()) {
            Position pos = q.remove();

            for (int[] dir : direction) {
                int tmpX = pos.x + dir[0];
                int tmpY = pos.y + dir[1];

                if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M) continue;

                if (!visited[tmpX][tmpY] && map[tmpX][tmpY] == 0) {
                    visited[tmpX][tmpY] = true;
                    map[tmpX][tmpY] = 2;
                    virusZone++;
                    q.offer(new Position(tmpX, tmpY));
                }
            }
        }
        return virusZone;
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}