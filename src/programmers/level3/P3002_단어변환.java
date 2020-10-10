package programmers.level3;

public class P3002_단어변환 {
    static String[] wordArr;
    static int answer;

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        wordArr = words;
        answer = 0;
        dfs(begin, target, visited, 0);
        return answer;
    }

    private int dfs(String begin, String target, boolean[] visited, int count) {
        if (count > wordArr.length) return 0;
        if (begin.equals(target)) {
            answer = count;
        }

        for (int i = 0; i < wordArr.length; i++) {
            if (!visited[i] && check(begin, wordArr[i])) {
                visited[i] = true;
                dfs(wordArr[i], target, visited, count + 1);
                visited[i] = false;
            }
        }
        return count;
    }

    private boolean check(String begin, String word) {
        int diff = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (diff > 1) break;
            if (begin.charAt(i) != word.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
