package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class P2002_압축 {
    static Map<String, Integer> dict = new HashMap<>();

    public static int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        char start = 'A';
        for (int i = 1; i < 27; i++) {
            dict.put(Character.toString(start + i - 1), i);
        }

        int idx = 27;
        boolean isEnd = false;
        for (int i = 0; i < msg.length(); i++) {
            String word = msg.charAt(i) + "";

            while (dict.containsKey(word)) {
                i++;
                if (i == msg.length()) {
                    isEnd = true;
                    break;
                }
                word += msg.charAt(i);
            }
            if (isEnd) {
                answer.add(dict.get(word));
                break;
            }
            System.out.println(word);
            answer.add(dict.get(word.substring(0, word.length() - 1)));
            dict.put(word, idx++);
            i--;
        }


        int[] ret = new int[answer.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = answer.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int i : solution("KAKAO")) {
            System.out.print(i + " ");
        }
    }
}
