import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<String>> strings = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            strings.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            int wordCnt = strings.get(word.length()).size();
            strings.get(word.length()).add(word);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(i).size() == 0) {
                continue;
            }
            Collections.sort(strings.get(i));

            String prevStr = "";
            for (String str : strings.get(i)) {
                if (prevStr.equals(str)) continue;
                sb.append(str).append("\n");
                prevStr = str;
            }
        }
        System.out.println(sb);
    }


}