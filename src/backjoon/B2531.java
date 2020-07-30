package backjoon;

import java.util.*;

public class B2531 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 접시의 수
        int d = sc.nextInt();   // 초밥의 가짓수
        int k = sc.nextInt();   // 연속해서 먹는 접시의 수
        int c = sc.nextInt();   // 쿠폰 번호

        int[] sushiArr = new int[N];
        for (int i = 0; i < N; i++) {
            sushiArr[i] = sc.nextInt();
        }

        int maxEat = 0;
        for (int i = 0; i < N - k + 1; i++) {
            Set<Integer> sushiKind = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                sushiKind.add(sushiArr[j]);
            }
            sushiKind.add(c);
            if (sushiKind.size() > maxEat) {
                maxEat = sushiKind.size();
            }
        }
        System.out.println(maxEat);
    }
}
