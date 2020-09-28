package codility;

import java.util.Stack;

/**
 * Brackets
 **/
public class C7_1 {
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char ch : S.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return 0;
                else{
                    if(!isCorrect(stack.peek(), ch)) return 0;
                    else{
                        stack.pop();
                    }
                }
            }
        }
        if(!stack.isEmpty()) return 0;
        return 1;
    }

    private static boolean isCorrect(Character peek, char ch) {
        if(peek == '{' && ch == '}'){
            return true;
        }else if(peek == '[' && ch == ']'){
            return true;
        }else if(peek == '(' && ch == ')'){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("([)()]"));

    }
}
