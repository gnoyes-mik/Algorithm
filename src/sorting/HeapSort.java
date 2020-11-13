package sorting;

import java.util.Arrays;

class HeapSort {

    private static void heapify(int[] arr, int size, int pNode) {
        int parent = pNode;
        int lNode = parent * 2 + 1;
        int rNode = parent * 2 + 2;

        if (size > lNode && arr[parent] < arr[lNode]) {
            parent = lNode;
        }

        if (size > rNode && arr[parent] < arr[rNode]) {
            parent = rNode;
        }

        if (parent != pNode) {
            swap(arr, pNode, parent);

            heapify(arr, size, parent);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int number = 10;
        int[] arr = new int[number];

        for (int i = 0; i < number; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.print("정렬 전 : ");
        System.out.println(Arrays.toString(arr));

        // 초기 MaxHeap 정렬, 정렬되지 않은 완전 이진 트리는 n/2개 노드만 heapify 해주어도 Maxheap 정렬이 된다.
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        // 오름차순 정렬
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, i, 0); // 최상단 노드(최대값)를 최하단 노드와 값 교환(이후엔 해당 노드 제외 후 재정비)
            heapify(arr, i - 1, 0);
        }

        System.out.print("정렬 후 : ");
        System.out.println(Arrays.toString(arr));
    }
}