package codility;

/** CyclicRotation **/
public class C2_1 {
    public static int[] solution(int[] A, int K) {
        int len = A.length;
        int[] result = new int[len];

        int idx = len - (K % len);
        for (int i = 0; i < len; i++) {
            result[i] = A[(idx++) % len];
        }
        return result;
    }
}
