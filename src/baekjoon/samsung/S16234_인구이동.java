package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S16234_인구이동 {

    static int N, L, R, cnt, result;
    static int[][] map;
    static boolean[][] opened;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;

        while (true) {
            opened = new boolean[N][N];
            visited = new boolean[N][N];
            cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!opened[i][j]){
                        isOpened(new Position(i, j));
                    }
                }
            }

            if (cnt == 0) {
                break;
            } else {
                result++;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (opened[i][j] && !visited[i][j]) {
                        bfs(new Position(i, j));
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static void isOpened(Position pos) {
        int x = pos.x;
        int y = pos.y;

        for (int[] dir : direction) {
            int tmpX = x + dir[0];
            int tmpY = y + dir[1];

            if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N) {
                continue;
            }
            int diff = Math.abs(map[x][y] - map[tmpX][tmpY]);
            if (L <= diff && diff <= R) {
                opened[x][y] = true;
                opened[tmpX][tmpY] = true;
                cnt++;
            }
        }
    }

    private static void bfs(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        List<Position> list = new ArrayList<>();

        visited[pos.x][pos.y] = true;

        int n = 0;
        int sum = 0;

        queue.add(pos);
        list.add(pos);

        while (!queue.isEmpty()) {
            Position p = queue.remove();

            sum += map[p.x][p.y];
            n++;

            for (int[] dir : direction) {
                int tmpX = p.x + dir[0];
                int tmpY = p.y + dir[1];

                if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N || !opened[tmpX][tmpY]) {
                    continue;
                }
                int diff = Math.abs(map[p.x][p.y] - map[tmpX][tmpY]);

                if (!visited[tmpX][tmpY] && L <= diff && diff <= R) {
                    queue.add(new Position(tmpX, tmpY));
                    list.add(new Position(tmpX, tmpY));
                    visited[tmpX][tmpY] = true;
                }
            }
        }
        int divide = sum / n;
        for (Position p : list){
            map[p.x][p.y] = divide;
        }
    }

    static class Position {
        public int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
