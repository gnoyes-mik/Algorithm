package baekjoon.step.스택;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 오큰수 : 자신보다 큰 수 이면서 가장 가까이(제일 왼쪽) 있는 수
public class B17298_오큰수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stk;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine(), " ");

        int[] a = new int[N];
        int idx = 0;
        while (stk.hasMoreTokens())
            a[idx++] = Integer.parseInt(stk.nextToken());

        int[] NGE = new int[N];
        Arrays.fill(NGE, -1);


        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {

            if (stack.empty()) { stack.push(i); }

            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                NGE[stack.peek()] = a[i];
                stack.pop();
            }

            stack.push(i);
        }

        for (int k : NGE) {
            System.out.print(k + " ");
        }
    }
}
