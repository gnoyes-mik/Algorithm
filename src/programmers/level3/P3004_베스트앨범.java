package programmers.level3;

import java.util.*;

public class P3004_베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreMap = new HashMap<>();
        Song[] songList = new Song[plays.length];

        for (int i = 0; i < genres.length; i++) {
            if (genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            } else {
                genreMap.put(genres[i], plays[i]);
            }

            songList[i] = new Song(i, genres[i], plays[i]);
        }
        Arrays.sort(songList);

        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreMap.entrySet());
        genreList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<String, Integer> e : genreList) {
            int cnt = 0;
            for (Song song : songList) {
                if (song.genre.equals(e.getKey())) {
                    result.add(song.number);
                    cnt++;
                    if (cnt == 2) {
                        cnt = 0;
                        break;
                    }
                }
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    static class Song implements Comparable<Song> {
        int number;
        String genre;
        int play;

        Song(int n, String g, int p) {
            this.number = n;
            this.genre = g;
            this.play = p;
        }

        @Override
        public String toString() {
            return number + "번 " + genre + " " + play + "번";
        }

        @Override
        public int compareTo(Song targetSong) {
            return this.play <= targetSong.play ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        String[] genres1 = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] play1 = new int[]{500, 600, 150, 800, 2500};

        for (int x :solution(genres1, play1)){
            System.out.print(x +" ");
        }
        System.out.println();
        String[] genres2 = new String[]{"classic", "pop", "classic", "classic"};
        int[] play2 = new int[]{500, 6000, 150, 800};

        for (int x :solution(genres2, play2)){
            System.out.print(x +" ");
        }
    }
}
