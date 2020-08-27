package programmers.level1;

// 문자열 내 p와 y의 개수
public class P1009 {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                count++;
            } else if (s.charAt(i) == 'y') {
                count--;
            }
        }
        if (count == 0) {
            answer = true;
        }

        return answer;
    }
}
