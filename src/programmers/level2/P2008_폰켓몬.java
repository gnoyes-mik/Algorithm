package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class P2008_폰켓몬 {
    public int solution(int[] nums) {
        int max = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (max <= set.size())
            return max;
        else{
            return set.size();
        }
    }
}
