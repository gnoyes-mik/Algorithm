package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P2015_다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;
        int time = 0;
        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (weight - sum < truck) {
                        queue.offer(0);
                        time++;
                    } else {
                        queue.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
}
