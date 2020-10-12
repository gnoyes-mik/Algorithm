package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class S14888_연산자끼워넣기 {
    static int N;
    static int[] nums;
    //덧셈, 뺄셈, 곱셈, 나눗셈
    static int[] ops = new int[4];
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        result = new ArrayList<>();

        dfs(1, nums[0]);

        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));
    }

    private static void dfs(int idx, int sum) {
        for (int i = 0; i < ops.length; i++) {
            if (ops[i] != 0) {

                ops[i]--;

                switch (i) {
                    case 0:
                        dfs(idx + 1, sum + nums[idx]);
                        break;
                    case 1:
                        dfs(idx + 1, sum - nums[idx]);
                        break;
                    case 2:
                        dfs(idx + 1, sum * nums[idx]);
                        break;
                    case 3:
                        dfs(idx + 1, sum / nums[idx]);
                        break;
                }
                ops[i]++;
            }
        }
        if (idx == N) {
            result.add(sum);
        }
    }
}
