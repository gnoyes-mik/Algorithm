// Programmers 가운데 글자 가져 오기
public class P0005 {
    public static String solution(String s) {
        int len = s.length();
        int index = len / 2;
        return (len % 2 == 0) ? s.substring(index - 1, index + 1)
                : s.substring(index, index + 1);
    }
}
