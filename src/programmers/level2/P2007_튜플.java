package programmers.level2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P2007_튜플 {
    public static int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s,"{}");

        ArrayList<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(!tmp.equals(",")){
                list.add(tmp);
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<String> resultList = new ArrayList<>();
        for(String tmp : list){
            String[] strArr = tmp.split(",");
            for (int i = 0; i < strArr.length; i++) {
                if(!resultList.contains(strArr[i])){
                    resultList.add(strArr[i]);
                }
            }
        }

        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = Integer.parseInt(resultList.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        for(int i : solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
