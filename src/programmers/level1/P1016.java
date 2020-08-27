package programmers.level1;

//자릿수 더하기
public class P1016 {
    public int solution(int n) {
        int sum = 0;
        String[] nArr = Integer.toString(n).split("");
        for(String s : nArr){
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
