package programmers;

// 두 정수 사이의 합
public class P0007 {
    public long solution(int a, int b) {
        long sum = 0;
        int start, end;
        if (a == b) {
            return a;
        }
        if (a < b) {
            start = a;
            end = b;
        } else {
            start = b;
            end = a;
        }

        while (start != end + 1) {
            sum += start++;
        }
        return sum;
    }
}
