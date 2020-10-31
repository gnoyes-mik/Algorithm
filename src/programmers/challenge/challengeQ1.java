package programmers.challenge;

import java.util.*;

class challengeQ1 {

    static class Solution {
        public String solution(int n, int[][] delivery) {
            String answer = "";
            String[] products = new String[n + 1];
            Arrays.fill(products, "?");

            List<int[]> dontKnow = new ArrayList<>();

            for(int[] d : delivery){
                if(d[2] == 1){
                    products[d[0]] = "O";
                    products[d[1]] = "O";
                    continue;
                }
                if(d[2] == 0){
                    if("O".equals(products[d[0]])){
                        products[d[1]] = "X";
                        continue;
                    }
                    if("O".equals(products[d[1]])){
                        products[d[0]] = "X";
                        continue;
                    }
                    dontKnow.add(d);
                }
            }

            for(int[] d : dontKnow){
                if("O".equals(products[d[0]])){
                    products[d[1]] = "X";
                    continue;
                }
                if("O".equals(products[d[1]])){
                    products[d[0]] = "X";
                    continue;
                }
            }

            for(int i = 1; i<= n ; i++){
                answer += products[i];
            }
            return answer;
        }

    }

    public static void main(String[] args) {
        challengeQ1.Solution s = new challengeQ1.Solution();
//        s.solution();
    }
}
