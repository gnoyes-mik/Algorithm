import java.util.Arrays;

// Programmers [정렬] K번째 수
public class P0002 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int T = 0; T < commands.length; T++) {
            int startIndex = commands[T][0];
            int endIndex = commands[T][1];
            int k = commands[T][2];

            int[] tmp = Arrays.copyOfRange(array,startIndex-1,endIndex);
            Arrays.sort(tmp);
            answer[T] = tmp[k-1];
        }
        return answer;
    }
}
