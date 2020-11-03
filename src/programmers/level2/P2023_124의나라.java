package programmers.level2;


public class P2023_124의나라 {
    public static String solution(int n) {
        String[] numbers = {"4", "1", "2"};
        String ans = "";

        while (n > 0) {
            ans = numbers[n % 3] + ans;
            n = (n - 1) / 3;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(500000000));
    }
}
