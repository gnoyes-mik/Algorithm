package codility;

import java.util.Stack;

public class C7_4 {
    public static int solution(int[] H) {
        // write your code in Java SE 8

        Stack<Integer> stack = new Stack();
        int blockCnt = 0;
        for(int i =0 ; i < H.length; i++){

            while(!stack.isEmpty() && stack.peek() > H[i]){
                stack.pop();
            }


            if(stack.isEmpty() || stack.peek() < H[i]){
                stack.push(H[i]);
                blockCnt++;
                System.out.print(H[i]+" ");
            }

        }
        return blockCnt;
    }
    public static void main(String[] args){
        int[] H = {8,8,5,7,9,8,7,4,8};
        solution(H);
    }
}
