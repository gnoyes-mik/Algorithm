package programmers.level3;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P3005_디스크컨트롤러 {
    public static int solution(int[][] jobs) {
        LinkedList<Job> waitQueue = new LinkedList<>();

        PriorityQueue<Job> controllor = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.workingTime - o2.workingTime;
            }
        });

        for (int[] job : jobs) {
            waitQueue.offer(new Job(job[0], job[1]));
        }
        waitQueue.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.requestTime - o2.requestTime;
            }
        });

        int time = waitQueue.peekFirst().requestTime;
        int result = 0;
        int numberOfJob = 0;

        while (numberOfJob < jobs.length) {
            while (!waitQueue.isEmpty() && waitQueue.peek().requestTime <= time) {
                controllor.offer(waitQueue.pollFirst());
            }

            if (!controllor.isEmpty()) {
                Job job = controllor.poll();
                time += job.workingTime;
                result += time - job.requestTime;
                numberOfJob++;
            } else {
                time++;
            }
        }
        return result / numberOfJob;
    }

    static class Job {
        int requestTime;  // 시작 가능 시간
        int workingTime;       // job 소요 시간

        Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        @Override
        public String toString() {
            return requestTime + "ms 시점에 " + workingTime + "ms 걸리는 작업";
        }
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }
}
