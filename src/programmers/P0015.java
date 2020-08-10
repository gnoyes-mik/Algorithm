package programmers;

// 이상한 문자 만들기
public class P0015 {
    public static String solution(String s) {
        String answer = "";
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += s.charAt(i);
                start = -1;
            }

            if (start % 2 == 0) {
                answer += Character.toUpperCase(s.charAt(i));
            } else if (start % 2 == 1) {
                answer += Character.toLowerCase(s.charAt(i));
            }

            start++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
