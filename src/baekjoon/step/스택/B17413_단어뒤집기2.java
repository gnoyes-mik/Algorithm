package baekjoon.step.스택;

import java.util.Scanner;
import java.util.Stack;

public class B17413_단어뒤집기2 {
    static Stack<Character> stack;

    public static void print(){
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        boolean tag = false;

        stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '<'){
                print();
                tag = true;
                System.out.print(c);
            }
            else if(c == '>'){
                tag = false;
                System.out.print(c);
            }
            else if(tag) {
                System.out.print(c);
            }
            else{
                if (c == ' '){
                    print();
                    System.out.print(' ');
                }else{
                    stack.push(c);
                }
            }
        }
        print();
    }
}
