package baekjoon.step.구현;

import java.util.Scanner;

public class B2670 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        double[] arr = new double[N];
        double[] mulArr = new double[N];

        double start = 1;
        for (int i = 0; i < N; i++) {
            double d = sc.nextDouble();
            arr[i] = d;

            if (i == 0) {
                mulArr[i] = arr[i] * start;
            } else if (mulArr[i - 1] >= 1.0) {
                mulArr[i] = mulArr[i - 1] * arr[i];
            } else if (mulArr[i - 1] < 1.0) {
                mulArr[i] = arr[i];
            }
        }
        double max = -99999;
        for (double d : mulArr) {
            if (d >= max) {
                max = d;
            }
        }
        String result = String.format("%.3f", max);
        System.out.println(result);
    }
}
