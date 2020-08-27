package programmers.level1;

// 약수의 합
public class P1014 {
    public int solution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int answer = 1 + n;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
