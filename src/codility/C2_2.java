package codility;

import java.util.*;

/** OddOccurrencesInArray **/
public class C2_2 {
    public static int solution(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : A){
            if(!map.containsKey(i)){
                map.put(i,0);
            }else{
                map.remove(i);
            }
        }

        int result = -1;
        for(int x : map.keySet())
            result = x;
        return result;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[]{1,1,2,3,2,3,5}));
    }
}
