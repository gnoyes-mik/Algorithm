package programmers.level3;

public class P3007_방문길이 {

    public static int solution(String dirs) {
        int ans = 0;
        char[] orders = dirs.toCharArray();
        boolean[][][][] visited = new boolean[11][11][11][11];

        MyCharacter user = new MyCharacter(5, 5);

        for (char order : orders) {
            int[] dir = getDirection(order);
            int nx = user.x + dir[0];
            int ny = user.y + dir[1];

            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;

            if (!visited[user.x][user.y][nx][ny]) {
                visited[user.x][user.y][nx][ny] = true;
                visited[nx][ny][user.x][user.y] = true;
                ans++;
            }
            user = new MyCharacter(nx, ny);

        }
        return ans;
    }

    private static int[] getDirection(char dir) {
        switch (dir) {
            case 'U':
                return new int[]{-1, 0};
            case 'D':
                return new int[]{1, 0};
            case 'L':
                return new int[]{0, -1};
            case 'R':
                return new int[]{0, 1};
            default:
                return new int[]{};
        }
    }

    static class MyCharacter {
        int x;
        int y;

        public MyCharacter(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
}
