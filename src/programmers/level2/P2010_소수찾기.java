package programmers.level2;

import java.util.*;

public class P2010_소수찾기 {

    static Set<Integer> permutationList;

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void permutation(List<String> arr, List<String> result, int n, int r) {
        if (r == 0) {
            StringBuilder num = new StringBuilder();
            for (String s : result)
                num.append(s);
            permutationList.add(Integer.parseInt(num.toString()));
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            permutation(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }

    }

    public static int solution(String numbers) {
        int answer = 0;

        permutationList = new HashSet<>();

        List<String> strArr = new ArrayList<>(Arrays.asList(numbers.split("")));
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= strArr.size(); i++) {
            permutation(strArr, result, strArr.size(), i);
        }

        for (int n : permutationList)
            if(isPrime(n)) answer++;

        return answer;
    }


    public static void main(String[] args){
        System.out.println((solution("17")));
        System.out.println((solution("011")));
    }
}
