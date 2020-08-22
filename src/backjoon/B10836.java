package backjoon;

import java.util.Scanner;

public class B10836 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] map = new int[M][M];
        int[] order = new int[2 * M];

        for (int i = 0; i < N; i++) {
            int zero = sc.nextInt();
            int one = sc.nextInt();
            int two = sc.nextInt();
            order[zero]++;
            order[zero + one]++;
        }

        // 왼쪽 세로
        int sum = 0;
        int index = 0;
        for (int i = M - 1; i >= 0; i--) {
            sum += order[index++];
            map[i][0] = sum;
        }

        // 상단 가로(0,1부터)
        for (int i = 1; i < M; i++) {
            sum += order[index++];
            map[0][i] = sum;
        }

        //나머지 칸
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                map[i][j] = map[0][j];
            }
        }

        //출력
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + 1 + " ");
            }
            System.out.println();
        }
    }
}



