package baekjoon.step.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class B2667_단지번호붙이기 {

    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            int j = 0;
            for (String s : br.readLine().split("")) {
                map[i][j++] = Integer.parseInt(s);
            }
        }

        ArrayList<Integer> result = new ArrayList();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    result.add(bfs(new Position(i, j)));
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (int x : result) System.out.println(x);
    }

    private static int bfs(Position position) {
        Queue<Position> queue = new LinkedList<>();
        int house = 0;

        queue.offer(position);
        visited[position.x][position.y] = true;
        house++;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            for (int i = 0; i < direction.length; i++) {
                int tmpX = pos.x + direction[i][0];
                int tmpY = pos.y + direction[i][1];

                if (tmpX >= 0 && tmpX < map.length && tmpY >= 0 && tmpY < map.length
                        && map[tmpX][tmpY] == 1
                        && !visited[tmpX][tmpY]) {
                    queue.add(new Position(tmpX, tmpY));
                    visited[tmpX][tmpY] = true;
                    house++;
                }
            }
        }
        return house;
    }
}
