import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
        }

        Collections.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        String prevWord = "";
        for (String word : words) {
            if (prevWord.equals(word)) continue;
            sb.append(word).append("\n");
            prevWord = word;
        }
        System.out.println(sb);
    }


}