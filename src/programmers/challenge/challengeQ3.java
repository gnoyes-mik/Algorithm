package programmers.challenge;

import java.util.*;

public class challengeQ3 {
    static class Solution {
        static int[][] map;
        static boolean[][] visited;
        static int[] answer = new int[3];
        static int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        public int[] solution(int[][] v) {
            map = new int[v.length][v.length];
            visited = new boolean[v.length][v.length];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    map[i][j] = v[i][j];
                }
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (!visited[i][j]) {
                        bfs(new Position(i, j), map[i][j]);
                    }
                }
            }

            return answer;
        }

        private static void bfs(Position pos, int item) {
            Queue<Position> queue = new LinkedList<>();
            queue.offer(pos);
            visited[pos.x][pos.y] = true;
            answer[item]++;

            while (!queue.isEmpty()) {
                Position p = queue.poll();

                for (int[] dir : direction) {
                    int nx = p.x + dir[0];
                    int ny = p.y + dir[1];

                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length) continue;

                    if (map[nx][ny] == item && !visited[nx][ny]) {
                        queue.offer(new Position(nx, ny));
                        visited[nx][ny] = true;
                        answer[item]++;
                    }
                }

            }

        }

        static class Position {
            int x, y;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }

    public static void main(String[] args) {
        challengeQ3.Solution s = new challengeQ3.Solution();
        int[][] v = new int[][]{{0,0,1,1},{1,1,1,1},{2,2,2,1},{0,0,0,2}};
        int[] ans = s.solution(v);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }
}
