package programmers;

// 문자열 다루기 기본
public class P0011 {
    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!(48 <= (int) c && (int) c <= 57)) {
                return false;
            }
        }
        return true;
    }
}
