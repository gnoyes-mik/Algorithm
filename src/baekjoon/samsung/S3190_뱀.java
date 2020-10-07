package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Snake {
    public int[] head;
    public int[] dir;
    public Deque<int[]> body;

    public Snake(int[] head, int[] dir) {
        this.head = head;
        this.dir = dir;
        body = new LinkedList<>();
        body.offerFirst(head);
    }

    public void move() {
        int nextX = head[0] + dir[0];
        int nextY = head[1] + dir[1];
        body.offerFirst(new int[]{nextX, nextY});
        head = new int[]{nextX, nextY};
    }

    public void follow() {
        body.removeLast();
    }

    public boolean isConflict(int[] nextPosition) {
        for (int[] b : body) {
            if (b[0] == nextPosition[0] && b[1] == nextPosition[1]) {
                return true;
            }
        }
        return false;
//        return body.contains(nextPosition);
    }
}

class Direction {
    public int[] dir;
    private int D;
    //우, 상, 좌, 하
    private final int[][] dirDB;

    public Direction() {
        this.dirDB = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        D = 0;
        this.dir = dirDB[D];
    }

    public int[] getDir() {
        return this.dirDB[D];
    }

    public void rotate(String direction) {
        if (direction.equals("L")) {
            D = D != 0 ? D - 1 : 3;
        } else if (direction.equals("D")) {
            D = (D + 1) % 4;
        }
    }
}

public class S3190_뱀 {

    static Queue<String[]> order;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            while (stk.hasMoreTokens()) {
                int i = Integer.parseInt(stk.nextToken());
                int j = Integer.parseInt(stk.nextToken());

                map[i][j] = 1;
            }
        }
        order = new LinkedList<>();
        int L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(stk.nextToken());
            String c = stk.nextToken();

            String[] tmp = new String[]{String.valueOf(x), c};

            order.add(tmp);
        }

        gameStart(new int[]{1, 1});
    }

    public static void gameStart(int[] start) {
        Direction direction = new Direction();
        int[] dir = direction.getDir();
        Snake snake = new Snake(start, dir);

        int time = 0;
        while (true) {
            if (!order.isEmpty() && Integer.parseInt(order.element()[0]) == time) {
                direction.rotate(order.remove()[1]);
                dir = direction.getDir();
                snake.dir = dir;
            }
            int nextX = snake.head[0] + dir[0];
            int nextY = snake.head[1] + dir[1];

            //벽에 부딪혔을 때
            if (nextX < 1 || nextX > N || nextY < 1 || nextY > N) {
                System.out.println(time + 1);
                return;
            }

            //몸에 부딪혔을 때
            if (snake.isConflict(new int[]{nextX, nextY})) {
                System.out.println(time + 1);
                return;
            }

            //사과를 먹었을 때
            if (map[nextX][nextY] == 1) {
                snake.move();
                map[snake.head[0]][snake.head[1]] = 0;
            } else {
                snake.move();
                snake.follow();
            }
            time++;
        }
    }
}
