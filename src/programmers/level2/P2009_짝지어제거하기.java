package programmers.level2;


import java.util.Stack;

public class P2009_짝지어제거하기 {
    static public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty())
                stack.push(c);
            else {
                if (stack.peek() != c)
                    stack.push(c);
                else
                    stack.pop();
            }
        }
        return (stack.isEmpty()) ? 1 : 0;

    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
}
