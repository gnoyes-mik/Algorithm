package codility;

/**
 * Binary Gap
 **/
public class C1_1 {
    public static int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int max = 0;
        int countZero = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                countZero++;
            }
            else if(binary.charAt(i) == '1'){
                if (max <= countZero){
                    max = countZero;
                }
                countZero = 0;
            }
        }

        return max;
    }
    public static void main(String[] args){
//        System.out.println(solution(1041));
//        System.out.println(solution(15));
//        System.out.println(solution(32));
        System.out.println(solution(561892));
    }
}
