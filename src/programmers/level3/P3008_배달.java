package programmers.level3;

import java.util.Arrays;

public class P3008_배달 {
    public static int solution(int N, int[][] road, int K) {
        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], 500001);
            map[i][i] = 0;
        }

        for (int[] path : road) {
            if (map[path[0]][path[1]] < path[2]) continue;
            map[path[0]][path[1]] = path[2];
            map[path[1]][path[0]] = path[2];
        }

        for (int k = 1; k <= N; k++) { // 경유 정점
            for (int i = 1; i <= N; i++) { // 시작 정점
                for (int j = 1; j <= N; j++) { // 도착 정점
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i <= N; i++) {
            System.out.print(map[1][i] + " ");
            if (map[1][i] <= K) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int N = 5;
        int[][] road = new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K = 3;
        System.out.println(solution(N,road,K));
        N = 6;
        road = new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        K = 4;
        System.out.println(solution(N, road, K));
    }
}