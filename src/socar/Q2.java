package socar;

public class Q2 {
    public static int solution(String[] drum) {
        String[][] map = new String[drum.length][drum[0].length()];

        int count = 0;

        for (int i = 0; i < drum.length; i++) {
            for (int j = 0; j < drum[0].length(); j++) {
                map[i][j] = String.valueOf(drum[i].charAt(j));
            }
        }

        for (int i = 0; i < map.length; i++) {
            int curX = 0;
            int curY = i;
            int starC = 0;
            boolean flag = false;

            while (true) {
                switch (map[curX][curY]) {
                    case "#":
                        curX++;
                        if (curX >= map.length) {
                            count++;
                            flag = true;
                        }
                        break;

                    case ">":
                        curY++;
                        if (curY >= map.length)
                            flag = true;
                        break;

                    case "<":
                        curY--;
                        if (curY < 0)
                            flag = true;
                        break;
                    case "*":
                        if (starC == 0) {
                            curX++;
                            starC++;
                            if (curX >= map.length) {
                                count++;
                                flag = true;
                            }
                        } else {
                            flag = true;
                        }
                        break;
                    default:
                        break;
                }
                if (flag) break;

            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"}));
    }
}
