package codility;
/** TapeEquilibrium **/
public class C3_3 {
    public static int solution(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        left[0] = A[0];    right[A.length-1] = A[A.length-1];

        for(int i=1; i<A.length; i++){
            left[i] = A[i] + left[i-1];
            right[A.length-1-i] = A[A.length-1-i] + right[A.length-i];
        }

        int min = 9999;

        for (int p = 0; p < A.length-1; p++) {
            int tmp = Math.abs(left[p]-right[p+1]);
            min = Math.min(min,tmp);
        }
        return min;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{3,1,2,4,3}));
    }
}
