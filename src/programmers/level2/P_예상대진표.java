package programmers.level2;

import java.util.*;

class P_예상대진표 {

    public static int bestSolution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;
        }
        return round;
    }

    public static int solution(int n, int a, int b) {
        int answer = 1;

        User[] userArr = new User[n + 1];

        // init
        for (int i = 1; i <= n; i++) {
            userArr[i] = new User(i, i);
        }

        // fight
        while (true) {
            boolean flag = fight(userArr, a, b);

            if (flag) break;

            answer++;

            userArr = nextRound(userArr, a, b);
        }

        return answer;
    }

    private static User[] nextRound(User[] arr, int a, int b) {
        List<User> list = new ArrayList<>();

        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i].id == a) {
                list.add(arr[i]);
                continue;
            }
            if (arr[i + 1].id == a) {
                list.add(arr[i + 1]);
                continue;
            }
            if (arr[i].id == b) {
                list.add(arr[i]);
                continue;
            }
            if (arr[i + 1].id == b) {
                list.add(arr[i + 1]);
                continue;
            }
            list.add(arr[i]);
        }

        User[] newArr = new User[list.size() + 1];
        int newIndex = 1;
        for (User user : list) {
            user.index = newIndex;
            newArr[newIndex++] = user;
        }
        return newArr;
    }

    private static boolean fight(User[] arr, int a, int b) {
        for (int i = 1; i < arr.length; i += 2) {
            if (arr[i].id == a && arr[i + 1].id == b) {
                return true;
            }
            if (arr[i].id == b && arr[i + 1].id == a) {
                return true;
            }
        }
        return false;
    }

    static class User {
        int id;
        int index;

        public User(int id, int index) {
            this.id = id;
            this.index = index;
        }
    }
}

