package programmers.level2;

public class P2011_카펫 {
    public static int[] solution(int brown, int yellow) {
        // 2w + 2h -4 = brown
        // (w-2)*(h-2) = yellow

        int height = 0, width = 0;
        for (height = 3; height <= (int) (brown + 4) / 2; height++) {
            width = ((brown + 4) / 2) - height;
//            if (width < height) {
//                break;
//            }

            int yellowCount = (width - 2) * (height - 2);
            if (yellow == yellowCount) {
                break;
            }
        }
        int[] answer = new int[] { width, height };
        return answer;
    }

    public static void main(String[] args){
        int[] answer = solution(10,2);
        System.out.println(answer[0]+", "+answer[1]);

        answer = solution(8,1);
        System.out.println(answer[0]+", "+answer[1]);

        answer = solution(24,24);
        System.out.println(answer[0]+", "+answer[1]);

    }
}
