package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class P2021_영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Map<String, Integer> usedWords = new HashMap<>();
        int[] player = new int[n];

        String alphabet = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                alphabet = words[i].substring(words[i].length() - 1);
                player[i % n]++;
                usedWords.put(words[i], 0);
                continue;
            }

            // 앞단어 맨뒷 글자로 시작하지 않는 경우
            if (!alphabet.equals(words[i].substring(0, 1))) {
                answer = new int[]{(i % n) + 1, player[i % n] + 1};
                break;
            }

            // 같은 단어 또 말한경우
            if (usedWords.containsKey(words[i])) {
                answer = new int[]{(i % n) + 1, player[i % n] + 1};
                break;
            }

            player[i % n]++;
            usedWords.put(words[i], 0);
            alphabet = words[i].substring(words[i].length() - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] ans = solution(n, words);
        System.out.println(ans[0] + "," + ans[1]);
    }
}
