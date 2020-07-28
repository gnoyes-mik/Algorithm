package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 나누어 떨어지는 숫자 배열
public class P0006 {
    public static int[] solution(int[] arr, int divisor) {
        List<Integer> tmp = new ArrayList<>();
        for (int x : arr) {
            if (x % divisor == 0) {
                tmp.add(x);
            }
        }

        if (tmp.size() == 0) {
            tmp.add(-1);
        }

        int[] answer = new int[tmp.size()];
        int i = 0;

        for (int x : tmp) {
            answer[i++] = x;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args){
        int[] answer = solution(new int[]{2,36,1,3},1);
        for(int i : answer){
            System.out.println(i+", ");
        }
    }
}
