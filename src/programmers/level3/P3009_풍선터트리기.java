package programmers.level3;

import java.util.*;

/** [Lv3 풍선터트리기]
 *  1. a 배열 양 끝 풍선은 항상 남길 수 있다.
 *  2. 양 끝을 제외한 나머지 풍선은 항상 left, center, right 꼴로 마지막에 남게 되는데
 *     이때 center 풍선이 최후까지 남으려면 left나 right 보다 (혹은 둘다 보다) 작아야 한다
 * */

public class P3009_풍선터트리기 {
    public int solution(int[] a) {
        if (a.length == 1) return 1;

        Set<Integer> result = new HashSet<>();

        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            leftMin = Math.min(leftMin, a[i]);
            rightMin = Math.min(rightMin, a[a.length-1-i]);
            result.add(leftMin);
            result.add(rightMin);
        }
        return result.size();
    }
}