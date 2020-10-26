package programmers.level2;

import java.util.Arrays;

public class P2022_소수만들기 {
    static boolean[] isPrime;
    static int ans;

    public static int solution(int[] nums) {
        isPrime = new boolean[3001];

        setIsPrime();
        ans = 0;
        dfs(nums, 0, 0, 0);

        return ans;
    }

    private static void setIsPrime() {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int num = 2; num <= 3000; num++) {
            if (isPrime[num]) {
                for (int other = num * 2; other <= 3000; other += num) {
                    isPrime[other] = false;
                }
            }
        }
    }

    private static void dfs(int[] nums, int level, int idx, int sum) {
        if (level == 3) {
            if (isPrime[sum]) {
                ans++;
                return;
            }
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            dfs(nums, level + 1, i + 1, sum + nums[i]);

        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
    }
}
