package programmers.level1;

import java.util.ArrayList;
import java.util.List;

// Programmers [탐욕법] 체육복
public class P1003 {
    public static int solution(int n, int[] lost, int[] reserve) {

        List<Integer> lostList = new ArrayList<>();
        for (int x : lost) lostList.add(x);

        List<Integer> reserveList = new ArrayList<>();
        for (int y : reserve) reserveList.add(y);

        // 여벌 체육복이 있는데 도난 당한 경우 lostList에서 제외
        for (int i = 0; i < lostList.size(); i++) {
            for (int j = 0; j < reserveList.size(); j++) {
                if (lostList.get(i).equals(reserveList.get(j))) {
                    lostList.remove(i);
                    i--;
                    reserveList.remove(j);
                    break;
                }
            }
        }

        // 빌릴 수 있는 경우 lostList에서 제외
        for (int i = 0; i < lostList.size(); i++) {
            int lostStudent = lostList.get(i);
            for (int j = 0; j < reserveList.size(); j++) {
                int reserveStudent = reserveList.get(j);
                if (lostStudent == reserveStudent - 1 || lostStudent == reserveStudent + 1) {
                    lostList.remove(i);
                    i--;
                    reserveList.remove(j);
                    break;
                }
            }
        }

        // 총 학생 수에서 못빌린 학생들의 차
        return n - lostList.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }
}
