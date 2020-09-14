package socar;

public class Q3 {
    static int[][][] map;
    static int R;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int max = 0;
    static int[][] visited;

    public static int solution(int r, int[][] delivery) {
        R = r;
        map = new int[r][r][2];
        visited = new int[r][r];
        visited[0][0] = 1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                map[i][j][0] = delivery[i * r + j][0];
                map[i][j][1] = delivery[i * r + j][1];
            }
        }
        dfs(0, 0, 0, map[0][0][0]);
        return max;
    }

    public static void dfs(int startX, int startY, int time, int sum) {

        for (int[] dir : direction) {
            int tmpX = startX + dir[0];
            int tmpY = startY + dir[1];

            if (tmpX < 0 || tmpX >= R || tmpY < 0 || tmpY >= R) continue;

            if (time + 1 <= map[tmpX][tmpY][0] && visited[tmpX][tmpY] == 0) {
                if(time + 1 == 16){
                    if(max < sum){
                        max = sum;
                    }
                    continue;
                }
                visited[tmpX][tmpY] = 1;
                dfs(tmpX, tmpY, time+1, sum+map[tmpX][tmpY][1]);
                visited[tmpX][tmpY] = 0;
            }
            if(time+1 == 16){
                if(max < sum){
                    max = sum;
                }
                continue;
            }
            visited[tmpX][tmpY] = 1;
            dfs(tmpX, tmpY, time+1, sum);
            visited[tmpX][tmpY] = 0;
        }
        return;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 10},{8, 1},{8, 1},{3, 100},{8, 1},{8, 1},{8, 1},{8, 1},{8, 1},{8, 1},{8, 1},{8, 1},{9,100},{8, 1},{8, 1},{8, 1}};
        System.out.println(solution(4, arr));
    }
}

// DFS, BFS, DP 쥐약 문제 이해도 잘 못 하겠고 써먹는 것도 너무 어려움..
// DFS, BFS 기본 문제는 느리더라도 풀 수는 있는데.. 조금만 문제가 길거나 복잡하면 대가리 터짐
// -> 다음 코테를 더 잘보기위해 이런것들을 많이 풀어볼꺼야 그리고