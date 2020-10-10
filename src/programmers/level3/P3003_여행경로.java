package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P3003_여행경로 {
    static boolean[] visited;
    static List<String> list;
    static String route = "";

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        list = new ArrayList<>();

        for(int i = 0 ; i < tickets.length; i++) {

            String departure = tickets[i][0];
            String destination = tickets[i][1];

            if(departure.equals("ICN")) {
                visited[i] = true;
                route = departure + ",";
                dfs(tickets, destination, 1);
                visited[i] = false;
            }
        }

        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    }

    public static void dfs(String[][] tickets, String end, int count) {

        route += end + ",";

        if(count==tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0 ; i < tickets.length ; i++) {
            String depart = tickets[i][0];
            String desti = tickets[i][1];

            if(end.equals(depart) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, desti, count+1);
                visited[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}
