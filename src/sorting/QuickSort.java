package sorting;

import java.util.Arrays;

public class QuickSort {
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        int rightPart = partition(arr, start, end);

        if (start < rightPart - 1)      // 왼쪽 Partition 의 원소가 적어도 1개 이상일 때만
            quickSort(arr, start, rightPart - 1);
        if (rightPart < end)            // 오른쪽 Partition 의 원소가 적어도 1개 이상일 때만
            quickSort(arr, rightPart, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        quickSort(new int[]{2, 1, 4, 0, 3});
        quickSort(new int[]{9, 2, 1, 4, 7, 8, 0, 3});
    }
}
