package backjoon;

import java.util.Scanner;

public class B2042SegmentTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, M, K;

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        long[] array = new long[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        SegmentTree segmentTree = new SegmentTree(array, N);

        while (M > 0 || K > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 1) {
                segmentTree.update(segmentTree.segmentArr, 0, N - 1, 1, b - 1, c - array[b - 1]);
                array[b - 1] = c;
                M--;
            } else if (a == 2) {
                long sum = segmentTree.sum(segmentTree.segmentArr, 0, N - 1, 1, b - 1, c - 1);
                System.out.println(sum);
                K--;
            }
        }
    }
}

class SegmentTree {

    long[] segmentArr;

    SegmentTree(long[] arr, int n) {

        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int segmentSize = (int) Math.pow(2, x) * 2 - 1;
        segmentArr = new long[segmentSize];
//        segmentArr = new long[n * 4];

        init(arr, 0, n - 1, 1);
    }

    long init(long[] arr, int start, int end, int node) {

        if (start == end) {
            return segmentArr[node] = arr[start];
        }

        int mid = (start + end) / 2;

        segmentArr[node] += init(arr, start, mid, node * 2);
        segmentArr[node] += init(arr, mid + 1, end, node * 2 + 1);

        return segmentArr[node];
    }

    void update(long[] arr, int start, int end, int node, int index, long diff) {
        if (!(start <= index && index <= end)) {
            return;
        }

        arr[node] += diff;

        if (start != end) {
            int mid = (start + end) / 2;
            update(arr, start, mid, node * 2, index, diff);
            update(arr, mid + 1, end, node * 2 + 1, index, diff);
        }
    }

    long sum(long[] arr, int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return arr[node];
        }

        int mid = (start + end) / 2;

        return sum(arr, start, mid, node * 2, left, right)
                + sum(arr, mid + 1, end, node * 2 + 1, left, right);
    }
}
