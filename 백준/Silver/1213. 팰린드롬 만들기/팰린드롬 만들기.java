import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Map<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!m.containsKey(c)) {
                m.put(c, 1);
                continue;
            }

            m.put(c, m.get(c) + 1);
        }

        boolean isOdd = false;
        for (Integer v : m.values()) {
            if (v % 2 != 0) {
                if (isOdd) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                isOdd = true;
            }
        }

        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (Character c : m.keySet()) {
            pq.add(c);
        }

        char mid = 0;
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int v = m.get(c);
            if (v % 2 == 0) {
                for (int i = 0; i < v / 2; i++) {
                    sb.append(c);
                }
            } else {
                mid = c;
                for (int i = 0; i < (v - 1) / 2; i++) {
                    sb.append(c);
                }
            }
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        if (mid != 0) sb.append(mid);
        sb.append(reverse);
        System.out.println(sb);
    }
}