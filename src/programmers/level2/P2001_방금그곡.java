package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class P2001_방금그곡 {
    static String[] sharp = {"C#", "D#", "F#", "G#", "A#"};
    static String[] replaceChar = {"c", "d", "f", "g", "a"};

    public static String solution(String m, String[] musicInfos) {
        String melody = replace(m);
        String[][] infos = replace(musicInfos);

        Arrays.sort(infos, new Comparator<String[]>() {
            @Override
            public int compare(String[] music1, String[] music2) {
                int runningTimeOfMusic1 = Integer.parseInt(music1[0]);
                int runningTimeOfMusic2 = Integer.parseInt(music2[0]);

                return -(runningTimeOfMusic1 - runningTimeOfMusic2);
            }
        });

        for (int i = 0; i < infos.length; ++i) {
            if (infos[i][2].contains(melody)) {
                return infos[i][1];
            }
        }

        return "(None)";
    }

    private static String replace(String m) {
        String result = m;
        for (int i = 0; i < sharp.length; i++) {
            result = result.replaceAll(sharp[i], replaceChar[i]);
        }
        return result;
    }

    private static String[][] replace(String[] musicInfos) {
        String[][] infos = new String[musicInfos.length][3];

        for (int i = 0; i < musicInfos.length; i++) {
            String[] musicInfo = musicInfos[i].split(",");

            int runningTime = getRunningTime(musicInfo[0].split(":"), musicInfo[1].split(":"));
            infos[i][0] = runningTime + "";
            infos[i][1] = musicInfo[2]; //title

            String replacedMusic = replace(musicInfo[3]);
            String music = "";
            for (int j = 0; j < runningTime; j++) {
                music += replacedMusic.charAt(j % replacedMusic.length());
            }

            infos[i][2] = music;
        }
        return infos;
    }

    private static int getRunningTime(String[] start, String[] end) {
        int runningTime = 0;

        int startHour = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMinute = Integer.parseInt(end[1]);

        runningTime = (endHour - startHour) * 60 + (endMinute - startMinute);

        return runningTime;
    }

    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"13:00,13:05,WORLD,ABCDEF","12:00,12:14,HELLO,C#DEFGAB"}));
    }
}
