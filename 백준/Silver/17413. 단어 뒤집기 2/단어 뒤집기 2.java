import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initStr = br.readLine();

        Deque<Character> onlyWord = new ArrayDeque<>();
        boolean isTag = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < initStr.length(); i++) {
            if (initStr.charAt(i) == '<') {
                isTag = true;
                while (!onlyWord.isEmpty()) {
                    char c = onlyWord.removeLast();
                    sb.append(c);
                }
            } else if (initStr.charAt(i) == '>') isTag = false;

            if (isTag || initStr.charAt(i) == '>') {
                sb.append(initStr.charAt(i));
                continue;
            }

            if (initStr.charAt(i) != ' ' && initStr.charAt(i) != '<') {
                onlyWord.addLast(initStr.charAt(i));
                continue;
            }
            while (!onlyWord.isEmpty()) {
                char c = onlyWord.removeLast();
                sb.append(c);
            }

            sb.append(" ");
        }

        while (!onlyWord.isEmpty()) {
            char c = onlyWord.removeLast();
            sb.append(c);
        }

        System.out.println(sb);
    }
}