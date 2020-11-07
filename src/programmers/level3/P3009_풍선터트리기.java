package programmers.level3;

public class P3009_풍선터트리기 {
    public int solution(int[] a) {
        int answer = 2; // 처음과 끝은 무조건 남길 수 있다.

        int l = a[0];
        int r = a[a.length - 1];

        for (int i = 1; i < a.length - 1; i++) { // 가운데 풍선을 걸러낸다.
            if (l > a[i]) {
                l = a[i];
                answer++;
            }
            if (r > a[a.length - 1 - i]) {
                r = a[a.length - 1 - i];
                answer++;
            }
        }
        return l == r ? answer - 1 : answer; // l과 r이 같으면 중복 발생
    }
}