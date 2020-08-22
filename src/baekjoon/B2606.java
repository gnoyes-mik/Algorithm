package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
    static int[][] map;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();

        map = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < C; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }
        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = 1;
        queue.add(start);

        int count = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[x][i] == 1 && visited[i] != 1){
                    queue.add(i);
                    visited[i] = 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
