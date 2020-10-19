package baekjoon.step.구현;

import java.util.*;

public class B2531 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 접시의 수
        int d = sc.nextInt();   // 초밥의 가짓수
        int k = sc.nextInt();   // 연속해서 먹는 접시의 수
        int c = sc.nextInt();   // 쿠폰 번호

        int[] sushiArr = new int[N + k - 1];

        // 초밥들을 입력받되 환형처럼 만들기 위해 뒤에 k-1개를 추가
        for (int i = 0; i < N; i++) {
            sushiArr[i] = sc.nextInt();
            if (i < k - 1) {
                sushiArr[N + i] = sushiArr[i];
            }
        }

        int[] kind = new int[d+1];
        int count = 0;  // 현재 경우의 수에서 먹을 수 있는 초밥 종류 개수의 최대값

        kind[c]++;  count++;    //쿠폰으로 먹을 수 있는 초밥

        for (int i = 0; i < k; i++) {               // O(N) sliding window를 위해 미리 k 길이의 window 준비
            if (kind[sushiArr[i]] == 0) count++;    // 한 window에서 먹은 초밥의 종류++
            kind[sushiArr[i]]++;
        }

        int max = count;
        for (int i = k; i < sushiArr.length; i++) {

            int left = sushiArr[i - k];
            kind[left]--;                   // 왼쪽 정보 지운다
            if (kind[left] == 0) count--;   // 왼쪽 정보가 0이 됬으면 해당 종류 초밥은 못 먹었으니까 count--
                                            // (만일 0 이상 값이면 해당 종류 초밥은 먹은거임)

            int right = sushiArr[i];
            if (kind[right] == 0) count++;  // 오른쪽으로 한칸 갈건데 만약 0이면 새로운 종류의 초밥이니까 count++
            kind[right]++;                  // 오른쪽에 해당하는 종류의 초밥을 count++ 한다

            if (max < count) max = count;   // max와 count를 비교하여 항상 max값을 유지하도록 한다
        }

        System.out.println(max);

    }
}
