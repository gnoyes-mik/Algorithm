package baekjoon.step.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] list = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            Person p = new Person(w, h);
            list[i] = p;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (list[i].compareTo(list[j]) > 0) {
                    list[i].addRank();
                }
            }
        }

        for (Person p : list)
            System.out.println(p.rank + " ");
    }

    static class Person implements Comparable<Person> {
        int weight;
        int height;
        int rank;

        public Person(int w, int h) {
            this.weight = w;
            this.height = h;
            this.rank = 1;
        }

        public void addRank() {
            this.rank++;
        }

        @Override
        public int compareTo(Person p) {
            return (this.weight < p.weight) && (this.height < p.height) ? 1 : -1;
        }
    }
}
