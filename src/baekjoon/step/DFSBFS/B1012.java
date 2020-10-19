package baekjoon.step.DFSBFS;

import java.util.Scanner;
import java.util.Stack;

public class B1012 {
    static int[][] map;
    static int[][] points;
    static boolean[][] visited;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            int answer = 0;
            map = new int[N][M];
            points = new int[K][2];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        answer++;
                        dfs(new Integer[] { i, j });
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void dfs(Integer[] p) {
        Stack<Integer[]> s = new Stack<>();
        s.push(p);
        while (!s.isEmpty()) {
            Integer[] nowP = s.pop();
            int y = nowP[0];
            int x = nowP[1];
            if (!visited[y][x]) {
                visited[y][x] = true;
                for (int i = 0; i < dir.length; i++) {
                    int tempY = y + dir[i][0];
                    int tempX = x + dir[i][1];
                    if (tempY >= 0 && tempY < map.length && tempX >= 0 && tempX < map[0].length
                            && !visited[tempY][tempX] && map[tempY][tempX] == 1) {
                        s.push(new Integer[] { tempY, tempX});
                    }
                }
            }
        }
    }

}