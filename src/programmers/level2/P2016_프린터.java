package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class P2016_프린터 {
    public static int solution(int[] priorities, int location) {
        Queue<Print> waitQueue = new LinkedList<>();
        int idx = 0;
        for (int priority : priorities) {
            waitQueue.offer(new Print(idx, priority));
            idx++;
        }

        int cnt = 1;
        while (true) {
            Print j = waitQueue.remove();

            if (check(j, waitQueue)){
                if(j.idx == location){
                    break;
                }
                cnt++;
            } else {
                waitQueue.offer(j);
            }
        }


        return cnt;
    }

    private static boolean check(Print target, Queue<Print> waitQueue) {
        for (Print p : waitQueue) {
            if (p.compareTo(target) > 0) {
                return false;
            }
        }
        return true;
    }

    static class Print implements Comparable<Print> {
        int idx;
        int priority;

        public Print(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public int compareTo(Print target) {
            return Integer.compare(this.priority, target.priority);
        }

        @Override
        public String toString() {
            return "[Idx = " + this.idx + " Priority = " + this.priority+"]";
        }
    }

    public static void main(String[] args) {
        int[] pri = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(pri, location));
    }
}