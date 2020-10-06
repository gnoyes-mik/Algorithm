package codility;

/** CoverBuildings **/
public class GoldenAward2020 {
    public static int solution(int[] H) {
        int[] left = new int[H.length];
        int[] right = new int[H.length];

        int lH = H[0],   rH = H[H.length-1];
        left[0] = H[0];  right[H.length-1] = H[H.length-1];
        for(int i=1; i<H.length; i++){
            if(H[i]>= lH) lH = H[i];
            left[i] = (i+1)*lH;

            if(H[H.length-1-i] >= rH) rH = H[H.length-1-i];
            right[H.length-1-i] = (i+1)*rH;
        }
        int w = right[0];
        for (int i = 1; i < H.length ; i++) {
            w = Math.min(right[i]+left[i-1], w);
        }

        return w;
    }
    public static void main(String[] args){
        int[] H = {3,1,4};
        System.out.println(solution(H));
        H = new int[]{5, 3, 2, 4};
        System.out.println(solution(H));
        H = new int[]{5,3,5,2,1};
        System.out.println(solution(H));
        H = new int[]{7,7,3,7,7};
        System.out.println(solution(H));
        H = new int[]{1,1,7,6,6,6};
        System.out.println(solution(H));
    }
}
