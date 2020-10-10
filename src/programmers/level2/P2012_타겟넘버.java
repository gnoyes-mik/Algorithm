package programmers.level2;

public class P2012_타겟넘버 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, target, idx + 1, sum + numbers[idx]) + dfs(numbers, target, idx + 1, sum - numbers[idx]);
    }
}
