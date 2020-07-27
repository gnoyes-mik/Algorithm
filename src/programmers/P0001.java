package programmers;

import java.util.ArrayList;
import java.util.List;

// Programmers [완전탐색] 모의고사
public class P0001 {
    public static int[] solution(int[] answers) {
        int[] rank = new int[3];

        int numberOfTotalProblem = answers.length;
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int i = 0;
        while (i < numberOfTotalProblem) {
            int answer = answers[i];
            if (answer == student1[i % 5]) rank[0]++;
            if (answer == student2[i % 8]) rank[1]++;
            if (answer == student3[i % 10]) rank[2]++;
            i++;
        }

        int max = 0;
        for (int value : rank) {
            if (value >= max) {
                max = value;
            }
        }

        List<Integer> resultTmp = new ArrayList<>();
        for (int j = 0; j < rank.length; j++) {
            if (max == rank[j]) {
                resultTmp.add(j + 1);
            }
        }

        int[] result = new int[resultTmp.size()];
        int k = 0;
        for (Integer r : resultTmp) {
            result[k++] = r;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rank = solution(new int[]{1, 2, 3, 4, 5, 2, 3, 1, 2, 3, 2, 3, 2, 3, 2, 1, 2, 5, 5, 2});
        for (int i : rank) {
            System.out.println(i);
        }
    }
}
