package programmers.level2;

import java.util.Arrays;

public class P2017_전화번호목록 {
    public static boolean solution(String[] phone_book) {
//        boolean answer = true;

        Trie trie = new Trie();
        Arrays.sort(phone_book);

        for (String number : phone_book) {
            if (!trie.insert(number)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"119", "97674223", "1195524421"};
        System.out.println(solution(input));
    }
}


class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    boolean insert(String key) {
        TrieNode curNode = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int next = c - '0';

            if (curNode.children[next] == null) {
                curNode.children[next] = new TrieNode();
            }

            curNode = curNode.children[next];

            if (curNode.isTerminal && i + 1 < key.length()) return false; // 접미어가 중복이면 false
        }

        curNode.isTerminal = true;
        return true;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[10]; // 0~9가 10개라서 올 수 있는 자식의 수를 10개로
    boolean isTerminal;

    TrieNode() {
        isTerminal = false;
    }
}