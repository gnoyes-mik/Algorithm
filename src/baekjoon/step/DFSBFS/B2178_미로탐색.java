package baekjoon.step.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_미로탐색 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = Integer.parseInt(row[j]);
            }
        }

        bfs(new Position(1, 1));
    }

    private static void bfs(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(pos);

        while (!queue.isEmpty()) {
            Position p = queue.poll();
            visited[p.x][p.y] = true;

            if (p.x == N && p.y == M) {
                System.out.println(map[p.x][p.y]);
            }

            for (int[] dir : direction) {
                int nx = p.x + dir[0];
                int ny = p.y + dir[1];

                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;

                if (map[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[p.x][p.y] + 1;

                    queue.offer(new Position(nx, ny));

                }
            }
        }
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
