package baekjoon.step.스택;

import java.util.Scanner;
import java.util.Stack;

public class B10799_쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Stack<Integer> stack = new Stack();

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '('){
                stack.push(i);
            }
            else if(str.charAt(i) == ')'){
                if(i - stack.peek() == 1){
                    stack.pop();
                    sum += stack.size();
                }else{
                    stack.pop();
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
