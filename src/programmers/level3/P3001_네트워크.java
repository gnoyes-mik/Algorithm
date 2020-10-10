package programmers.level3;

public class P3001_네트워크 {

    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, int i) {
        visited[i] = true;

        for (int j = 0; j < computers.length; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(computers, j);
            }
        }
    }

}
