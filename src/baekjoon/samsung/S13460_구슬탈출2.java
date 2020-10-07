package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Ball {
    int x;
    int y;
    int move;

    public Ball(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }

    public void back(int[] direction) {
        this.x -= direction[0];
        this.y -= direction[1];
    }
}

class Situation {
    Ball blue;
    Ball red;

    public Situation(Ball blue, Ball red) {
        this.blue = blue;
        this.red = red;
    }
}

public class S13460_구슬탈출2 {

    static String[][] board;
    static boolean[][][][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        board = new String[N][M];
        visited = new boolean[10][10][10][10];

        Ball red = null;
        Ball blue = null;

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int j = 0;
            for (String s : stk.nextToken().split("")) {
                if (s.equals("B")) blue = new Ball(i, j, 0);
                if (s.equals("R")) red = new Ball(i, j, 0);
                board[i][j++] = s;
            }
        }
        Situation initialSituation = new Situation(blue, red);
        bfs(initialSituation);

    }

    private static void bfs(Situation initialSituation) {
        Queue<Situation> q = new LinkedList<>();
        q.add(initialSituation);

        while (!q.isEmpty()) {
            Situation situation = q.poll();
            visited[situation.blue.x][situation.blue.y][situation.red.x][situation.red.y] = true;

            if (situation.red.move > 9) {
                System.out.println(-1);
                return;
            }

            for (int[] dir : direction) {
                Ball nextBlue = null;
                Ball nextRed = null;

                //blue
                int blueTmpX = situation.blue.x;
                int blueTmpY = situation.blue.y;

                while (!"#".equals(board[blueTmpX + dir[0]][blueTmpY + dir[1]])) {
                    blueTmpX += dir[0];
                    blueTmpY += dir[1];
                    if ("O".equals(board[blueTmpX][blueTmpY])) {
                        break;
                    }
                }
                nextBlue = new Ball(blueTmpX, blueTmpY, situation.blue.move + 1);


                //red
                int redTmpX = situation.red.x;
                int redTmpY = situation.red.y;

                while (!"#".equals(board[redTmpX + dir[0]][redTmpY + dir[1]])) {
                    redTmpX += dir[0];
                    redTmpY += dir[1];
                    if ("O".equals(board[redTmpX][redTmpY])) {
                        break;
                    }
                }
                nextRed = new Ball(redTmpX, redTmpY, situation.red.move + 1);

                //파란색 구슬이 'O'에 빠진 경우
                if ("O".equals(board[nextBlue.x][nextBlue.y]))
                    continue;

                //빨간색 구슬만 'O'에 빠진 경우
                if ("O".equals(board[nextRed.x][nextRed.y])) {
                    System.out.println(nextRed.move);
                    return;
                }

                if (nextBlue.x == nextRed.x && nextBlue.y == nextRed.y) {
                    // 상: {-1, 0} 하: {1, 0} 좌: {0, -1} 우: {0, 1}
                    //1:상 2:하 3:좌 4:우
                    int d = -1;
                    if (Arrays.equals(dir, new int[]{-1, 0})) d = 1;
                    if (Arrays.equals(dir, new int[]{1, 0})) d = 2;
                    if (Arrays.equals(dir, new int[]{0, -1})) d = 3;
                    if (Arrays.equals(dir, new int[]{0, 1})) d = 4;
                    switch (d) {
                        case 1: //상
                            if (situation.blue.x > situation.red.x) {
                                nextBlue.back(dir);
                            } else {
                                nextRed.back(dir);
                            }
                            break;
                        case 2: //하
                            if (situation.blue.x > situation.red.x) {
                                nextRed.back(dir);
                            } else {
                                nextBlue.back(dir);
                            }
                            break;
                        case 3: //좌
                            if (situation.blue.y > situation.red.y) {
                                nextBlue.back(dir);
                            } else {
                                nextRed.back(dir);
                            }
                            break;
                        case 4: //우
                            if (situation.blue.y > situation.red.y) {
                                nextRed.back(dir);
                            } else {
                                nextBlue.back(dir);
                            }
                            break;
                    }
                }

                if (!visited[nextBlue.x][nextBlue.y][nextRed.x][nextRed.y]) {
                    q.add(new Situation(nextBlue, nextRed));
                }
            }
        }
        System.out.println(-1);
    }
}
