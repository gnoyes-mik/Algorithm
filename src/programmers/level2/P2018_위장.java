package programmers.level2;

import java.util.HashMap;

public class P2018_위장 {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> category = new HashMap<>();
        for (String[] clothe : clothes) {
            if (category.containsKey(clothe[1])) {
                category.put(clothe[1], category.get(clothe[1]) + 1);
            } else {
                category.put(clothe[1], 1);
            }
        }

        int answer = 1;

        for (String key : category.keySet()) {
            answer *= category.get(key) + 1;
        }

        return answer - 1;
    }
}
