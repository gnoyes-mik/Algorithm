package baekjoon;

import java.util.*;

public class B2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numArr = new int[N];

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        Arrays.sort(numArr);

        int liquid1 = 0;
        int liquid2 = 0;

        int left = 0;
        int right = numArr.length - 1;
        int sum;
        int min = 2000000000;

        while (left < right) {
            sum = numArr[left] + numArr[right];

            if (Math.abs(sum) < min) {
                liquid1 = numArr[left];
                liquid2 = numArr[right];
                min = Math.abs(sum);
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(liquid1 + " " + liquid2);
    }
}
