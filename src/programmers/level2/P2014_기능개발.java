package programmers.level2;

import java.util.ArrayList;
import java.util.Stack;

public class P2014_기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {

        if (progresses.length < 1) return new int[]{};

        Stack<Integer> schedule = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = progresses.length - 1; i > -1; i--) {
            schedule.push(
                    (int)Math.ceil((100 - progresses[i]) / (double)speeds[i])
                );
        }

        int date = schedule.peek();
        int cnt = 0;

        while (true) {
            while (!schedule.isEmpty() && date >= schedule.peek()) {
                cnt++;
                schedule.pop();
            }
            result.add(cnt);
            cnt = 0;
            if (!schedule.isEmpty())
                date = schedule.peek();
            else
                break;
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
//        for (int x : solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})) {
//            System.out.print(x + " ");
//        }
//        System.out.println();
        for (int x : solution(new int[]{95, 74, 93, 93}, new int[]{1, 5, 1, 1})) {
            System.out.print(x + " ");
        }
    }
}
