package programmers.level1;

// 시저 암호
public class P1013 {
    public String solution(String s, int n) {
        String answer = "";
        int len = s.length();
        char alpha;
        char start;

        for (int i = 0; i < len; i++) {
            alpha = s.charAt(i);
            if (alpha != ' ') {
                start = Character.isLowerCase(alpha) ? 'a' : 'A';
                alpha = (char) (start + (alpha + n - start) % 26);
            }
            answer += alpha;
        }
        return answer;
    }
}
