package programmers;

// 소수 찾기
public class P0012 {
    public static int solution(int n) {
        int count = 0;
        int number = 1;

        while (number <= n) {
            if (number % 2 != 0) {
                boolean isPrime = true;

                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    count++;
                }
            }
            number++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("\n" + solution(1000000));
    }
}

