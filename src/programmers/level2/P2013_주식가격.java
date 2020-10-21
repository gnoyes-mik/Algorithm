package programmers.level2;

import java.util.*;

public class P2013_주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Arrays.fill(answer, -1);
        Stack<Stock> s = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            if (s.isEmpty()) {
                s.push(new Stock(prices[i], i));
                continue;
            }
            if (s.peek().value <= prices[i]) {
                s.push(new Stock(prices[i], i));
            } else {
                while (!s.isEmpty() && s.peek().value > prices[i]) {
                    Stock stock = s.pop();
                    answer[stock.idx] = i - stock.idx;
                }
                s.push(new Stock(prices[i], i));
            }
        }

        if (!s.isEmpty()) {
            while (!s.isEmpty()) {
                Stock stock = s.pop();
                answer[stock.idx] = prices.length-1 - stock.idx;
            }
        }
        return answer;
    }

    static class Stock {
        int value;
        int idx;

        Stock(int v, int i) {
            this.value = v;
            this.idx = i;
        }
    }

    public static void main(String[] args) {
        for (int x : solution(new int[]{1, 2, 3, 2, 3})) {
            System.out.print(x + " ");
        }
    }
}
