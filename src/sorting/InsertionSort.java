package sorting;

/**
 * n 개의 원소를 가진 배열을 정렬할 때, i 번째를 정렬할 순서라고 가정하면, 0 부터 i-1 까지의 원소들은 정렬되어있다는 가정하에,
 * i 번째 원소와 i-1 번째 원소부터 0 번째 원소까지 비교하면서 i 번째 원소가 비교하는 원소보다 클 경우 서로의 위치를 바꾸고,
 * 작을 경우 위치를 바꾸지 않고 다음 순서의 원소와 비교하면서 정렬해준다.
 * 이 과정을 정렬하려는 배열의 마지막 원소까지 반복해준다.
 * <p>
 * 시간 복잡도 O(n^2) 공간 복잡도 O(1)
 */

class InsertionSort {

    public static int[] solution(int[] arr) {
        if (arr == null) return null;
        int j, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            j = i;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 0, 3};

        for (int x : solution(arr))
            System.out.print(x + " ");
    }
}
