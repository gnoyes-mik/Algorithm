package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * r,c 는 1부터
 * 0 = 빈칸, 1 = 집, 2 = 치킨집
 * 치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리(모든 집은 치킨 거리를 가지고 있음)
 * 도시의 치킨 거리 : 모든 집의 치킨거리의 합
 * 두 칸 (r1, c1)과 (r2, c2) 사이의 거리는 |r1-r2| + |c1-c2|로 구한다.
 * 수익을 가장 많이 낼 수 있는 치킨집 수는 최대 M
 * M을 제외한 나머지는 폐업
 * 도시의 치킨거리가 가장 작게되는 경우를 구하라
 */

public class S15686_치킨배달 {
    static int N, M;
    static int[][] map;
    static boolean[][] valid;
    static List<int[]> houseList;
    static List<int[]> chickenHouseList;
    static Stack<int[]> selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        valid = new boolean[N + 1][N + 1];

        houseList = new ArrayList<>();
        chickenHouseList = new ArrayList<>();
        selected = new Stack<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houseList.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickenHouseList.add(new int[]{i, j});
                }
            }
        }
        result = Integer.MAX_VALUE;

        selectChickenHouse(0, 0);

        System.out.println(result);
    }

    static int result;

    private static void selectChickenHouse(int start, int cnt) {
        if (cnt == M) {
            // 도시의 치킨 거리
            int distance = calculate();
            result = Math.min(result, distance);
            return;
        }

        for (int i = start; i < chickenHouseList.size(); i++) {
            selected.push(chickenHouseList.get(i));
            selectChickenHouse(i + 1, cnt + 1);
            selected.pop();
        }
    }

    private static int calculate() {
        int sum = 0;
        for (int[] home : houseList){
            int min = Integer.MAX_VALUE;

            for(int[] chickenHouse : selected){
                int distance = getDistance(home[0], home[1], chickenHouse[0], chickenHouse[1]);
                min = Math.min(min, distance);
            }

            sum += min;
        }

        return sum;
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
