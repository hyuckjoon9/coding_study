import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < N; testCase++) {
            Deque<Character> dq = new ArrayDeque<>();
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (dq.isEmpty()) dq.push(str.charAt(i));
                else if (str.charAt(i) == '(') dq.push(str.charAt(i));
                else if (str.charAt(i) == ')') {
                    if (dq.getLast() != '(') {
                        dq.push(str.charAt(i));
                    }
                    dq.pollLast();
                }
            }
            if (dq.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}