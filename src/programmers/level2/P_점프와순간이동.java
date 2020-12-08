package programmers.level2;

public class P_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                n -= 1;
                ans++;
                continue;
            }
            n /= 2;
        }
        return ans;
    }
}
