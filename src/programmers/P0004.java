package programmers;

// Programmers 2016년
public class P0004 {
    public static String solution(int a, int b) {
        String answer = "";
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sumOfDay = 0;
        for (int i = 0; i < a - 1; i++) {
            sumOfDay += dayOfMonth[i];
        }
        sumOfDay += b;
        switch (sumOfDay % 7) {
            case 0:
                answer = "THU";
                break;
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
