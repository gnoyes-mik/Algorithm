package socar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q1 {
    public static int solution(String[] bakery_schedule, String current_time, int K) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date curtime = sdf.parse(current_time);

        int sum = 0;
        Date time = new Date();
        for (String str : bakery_schedule) {
            if (sum >= K) break;

            String[] timeNum = str.split(" ");
            time = sdf.parse(timeNum[0]);

            if (time.compareTo(curtime) >= 0) {
                sum += Integer.parseInt(timeNum[1]);
            }
        }

        if (sum < K) {
            return -1;
        } else {
            long diff = time.getTime() - curtime.getTime();
            long diffMin = diff / (60 * 1000);
            return (int) diffMin;
        }
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(solution(new String[]{"09:05 10", "12:20 5", "13:25 6", "14:24 5"}, "12:05", 10));
    }

}
