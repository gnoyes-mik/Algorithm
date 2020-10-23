package programmers.level2;

import java.util.PriorityQueue;

public class P2019_더맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int n : scoville)
            heap.offer(n);

        if (heap.size() == 0) return -1;
        if (heap.size() == 1) {
            if (heap.peek() >= K)
                return 0;
            else
                return -1;
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                answer = -1;
                break;
            }

            int foodA = heap.poll();
            int foodB = heap.poll();

            int newFood = foodA + foodB * 2;
            heap.offer(newFood);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int[] scoville = new int[]{12, 10, 9, 3, 2, 1};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
