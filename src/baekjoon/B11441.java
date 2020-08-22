package baekjoon;

import java.util.Scanner;

public class B11441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] sumArr = new int[N + 1];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                //empty
            } else {
                arr[i] = sc.nextInt();
                sumArr[i] = sumArr[i - 1] + arr[i];
            }
        }
        int M = sc.nextInt();
        for (int j = 0; j < M; j++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sumArr[end] - sumArr[start - 1]);
        }
    }
}
