package programmers;

import java.util.Arrays;

// 문자열 내림차순으로 배치하기
public class P0010 {
    public String solution(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new StringBuilder(new String(array)).reverse().toString();
    }
}
