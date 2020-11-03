package programmers.level2;

import java.util.Arrays;

public class P2024_삼각달팽이 {

    private static int getMax(int n) {
        return n == 1 ? 1 : getMax(n - 1) + n;
    }

    public static int[] solution(int n) {
        int[][] map = new int[n][n];

        for (int[] row : map)
            Arrays.fill(row, -1);

        int k = 1;
        int max = getMax(n);
        int i = 0, j = 0;

        map[i][j] = k;

        while (k < max) {
            while (i + 1 < n && map[i + 1][j] < 0 && k < max) {
                map[++i][j] = ++k;
            }
            while (j + 1 < n && map[i][j + 1] < 0 && k < max) {
                map[i][++j] = ++k;
            }
            while (i - 1 > 0 && j - 1 > 0 && map[i - 1][j - 1] < 0 && k < max) {
                map[--i][--j] = ++k;
            }

        }
        k = 0;
        int[] result = new int[max];
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                result[k++] = map[i][j];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        solution(1000);
    }
}
