package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class P2020_가장큰수 {

    public static String solution(int[] numbers) {
        String[] sArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            sArr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        return sArr[0].equals("0") ? "0" : String.join("", sArr);
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
    }
}
