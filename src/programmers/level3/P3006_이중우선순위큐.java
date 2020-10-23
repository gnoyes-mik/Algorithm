package programmers.level3;

import java.util.*;

public class P3006_이중우선순위큐 {
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation, " ");

            String op = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            if (op.equals("I")) {
                maxQ.offer(val);
                minQ.offer(val);
                continue;
            }
            if (val == 1) {
                if (!maxQ.isEmpty()) deleteValue(minQ, maxQ.poll());
            } else if (val == -1) {
                if (!minQ.isEmpty()) deleteValue(maxQ, minQ.poll());
            }
        }

        return new int[]{maxQ.isEmpty() ? 0 : maxQ.poll(), minQ.isEmpty() ? 0 : minQ.poll()};
    }

    private static void deleteValue(PriorityQueue<Integer> queue, int val) {
        List<Integer> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            if (tmp == val) break;
            arr.add(tmp);
        }
        queue.addAll(arr);
    }

}
