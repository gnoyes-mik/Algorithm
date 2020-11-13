package sorting;

import java.util.Arrays;

/**
 * n 개의 원소를 가진 배열을 정렬할 때, 계속해서 바꾸는 것이 아니라 비교하고 있는 값의 index 를 저장해둔다.
 * 그리고 최종적으로 한 번만 바꿔준다.
 * 하지만 여러 번 비교를 하는 것은 마찬가지이다.
 *
 * 시간 복잡도 O(n^2)
 * 공간 복잡도 O(1)
 */

class SelectionSort {
    public static int[] solution(int[] arr) {
        if (arr == null) return null;
        int[] result = Arrays.copyOfRange(arr, 0, arr.length);
        int maxPos;

        for (int i = 0; i < result.length - 1; i++) {
            maxPos = i;
            for (int k = i + 1; k < result.length; k++) {
                if (result[maxPos] > result[k]) {
                    maxPos = k;
                }
            }
            Utils.swapValue(result, i, maxPos);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 0, 3};

        for (int x : solution(arr))
            System.out.print(x + " ");
    }
}
