package sorting;

/**
 * - n 개의 원소를 가진 배열을 정렬할 때, 인접한 두 개의 데이터를 비교해가면서 정렬해나가는 방식
 * - 가장 큰 값을 맨 끝에다 이동시키면서 정렬하고자 하는 원소의 개수 만큼 두번 반복하게 된다
 *
 * 시간 복잡도 O(n^2)
 * 공간 복잡도 O(1)
 */

class BubbleSort {
    public static void swapValue(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swapValue(arr, i, j);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 0, 3};

        for (int x : sort(arr))
            System.out.print(x + " ");
    }
}