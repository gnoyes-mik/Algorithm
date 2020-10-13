package baekjoon.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S14891_톱니바퀴 {

    static ArrayList<Gear> gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        gears = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            stk = new StringTokenizer(br.readLine());
            String[] strArr = stk.nextToken().split("");

            int[] arr = new int[8];

            for (int j = 0; j < strArr.length; j++) {
                arr[j] = Integer.parseInt(strArr[j]);
            }
            gears.add(new Gear(arr));
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());

            int gearNum = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            control(gearNum, d);
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            score += (gears.get(i).getTop() == 0) ? 0 : Math.pow(2, i);
        }
        System.out.println(score);
    }

    private static void control(int gearNum, int d) {
        int idx = gearNum - 1;
        int dir = d;

        ArrayList<int[]> rotateList = new ArrayList<>();
        rotateList.add(new int[]{idx, dir});

        //왼쪽
        while (idx - 1 >= 0) {
            if (gears.get(idx - 1).getRight() != gears.get(idx).getLeft()) {
                dir *= -1;
                rotateList.add(new int[]{idx - 1, dir});
            } else {
                break;
            }
            idx--;
        }

        idx = gearNum - 1;
        dir = d;
        // 오른쪽
        while (idx + 1 <= 3) {
            if (gears.get(idx).getRight() != gears.get(idx + 1).getLeft()) {
                dir *= -1;
                rotateList.add(new int[]{idx + 1, dir});
            } else {
                break;
            }
            idx++;
        }
        for (int[] order : rotateList) {
            gears.get(order[0]).rotate(order[1]);
        }
    }


}

class Gear {
    int[] nums;

    public Gear(int[] nums) {
        this.nums = nums;
    }

    public void rotate(int d) {
        int[] tmp;
        switch (d) {
            case 1: // 시계 방향
                tmp = new int[nums.length];
                tmp[0] = nums[nums.length - 1];
                for (int i = 0; i < nums.length - 1; i++) {
                    tmp[i + 1] = nums[i];
                }
                nums = tmp;
                break;
            case -1: // 반시계 방향
                tmp = new int[nums.length];
                for (int i = 0; i < nums.length - 1; i++) {
                    tmp[i] = nums[i + 1];
                }
                tmp[tmp.length - 1] = nums[0];
                nums = tmp;
                break;
        }
    }

    public int getLeft() {
        return nums[6];
    }

    public int getRight() {
        return nums[2];
    }

    public int getTop() {
        return nums[0];
    }
}
