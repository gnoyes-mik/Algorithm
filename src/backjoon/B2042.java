package backjoon;

import java.util.HashMap;
import java.util.Scanner;

public class B2042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, M, K;

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        long[] arr = new long[N + 1];
        long[] sumArr = new long[N + 1];
        HashMap<Long, Long> diffMap = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sumArr[i] = arr[i] + sumArr[i - 1];
        }

        while (M > 0 || K > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 1) {
                long diff = c - arr[b];

                if (diffMap.containsKey((long) b)) {
                    diffMap.put((long) b, diffMap.get((long) b) + diff);
                } else {
                    diffMap.put((long) b, diff);
                }
                arr[b] = c;
                M--;
            } else if (a == 2) {
                long result = sumArr[c] - sumArr[b - 1];
                long diffSum = 0;

                for (long x : diffMap.keySet()) {
                    if (b <= x && c >= x) {
                        diffSum += diffMap.get(x);
                    }
                }
                System.out.println(result + diffSum);
                K--;
            }
        }
    }
}
