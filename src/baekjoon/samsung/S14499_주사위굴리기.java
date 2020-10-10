package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S14499_주사위굴리기 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        map = new int[N][M];

        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        int[] start = new int[]{x, y};

        int K = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(br.readLine());
        ArrayList<Integer> orderList = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            orderList.add(Integer.parseInt(stk.nextToken()));
        }

        for (int order : orderList){

        }
    }
}
