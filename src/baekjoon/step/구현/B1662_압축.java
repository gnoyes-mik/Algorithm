package baekjoon.step.구현;

import java.util.ArrayDeque;
import java.util.Deque;

public class B1662_압축 {

    public static void main(String[] args) {
        System.out.println(solution("33(562(71(9)))"));
        System.out.println(solution("33(62(71(9)))"));
        System.out.println(solution("3(3(3(2(2)2(2))))"));
    }

    static int solution(String input) {
        char[] cArr = input.toCharArray();
        int[] mark = new int[50];

        Deque<Integer> s1 = new ArrayDeque<>(cArr.length);

        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (c == '(') s1.push(i);
            if (c == ')') mark[s1.pop()] = i;      // mark[openIdx] = closeIdx
        }

        return decode(0, cArr.length, cArr, mark);
    }

    private static int decode(int start, int end, char[] cArr, int[] mark) {
        int size = 0;

        for (int i = start; i < end; i++) {

            // 하위 괄호 탐색
            if (cArr[i] == '(') {
                int multiply = Character.digit(cArr[i - 1], 10);
                size += multiply * decode(i + 1, mark[i], cArr, mark) - 1; // 앞의 개수 * 내부 괄호 문자 수 - 1 || -1은 곱해진 수 때문에 뺀다
                i = mark[i];

                // BC - 1 | 더이상 내부에 괄호가 없을 때
            } else {
                size++;
            }
        }

        // BC - 2 | 모든 내부 길이 계산 완료
        return size;
    }
}