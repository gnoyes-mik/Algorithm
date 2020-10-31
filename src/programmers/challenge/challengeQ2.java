package programmers.challenge;

public class challengeQ2 {
    static class Solution {
        public String solution(String encrypted_text, String key, int rotation) {
            String encrypted = rotate(encrypted_text, rotation);

            String res = "";
            for (int i = 0; i < encrypted.length(); i++) {
                res += getDecryptedText(i, encrypted.substring(i, i + 1), key);
            }
            return res;
        }

        private String rotate(String str, int rotation) {
            int r = rotation % str.length();
            String result = "";

            if (r < 0) {
                r *= -1;
                result += str.substring(str.length() - r, str.length());
                result += str.substring(0, str.length() - r);
                return result;
            } else if (r > 0) {
                result += str.substring(r, str.length());
                result += str.substring(0, r);
                return result;
            }
            return str;
        }

        private String getDecryptedText(int idx, String str, String key) {
            char k = key.toCharArray()[idx];
            int n = getNum(k);
            char ch = str.toCharArray()[0];

            if (ch - n < 97) {
                return Character.toString(123 - (97 - (ch - n)));
            }

            return Character.toString(ch - n);
        }

        private int getNum(char alphabet) {
            return alphabet - 96;
        }

    }

    public static void main(String[] args) {
        challengeQ2.Solution s = new challengeQ2.Solution();
        System.out.println(s.solution("qyyigoptvfb", "abcdefghijk", 3));
    }
}
