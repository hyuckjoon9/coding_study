import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> m = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            int check = m.getOrDefault(number, 0);
            if (check == 0) {
                m.put(number, 1);
            } else {
                int value = m.get(number) + 1;
                m.put(number, value);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            int value = m.getOrDefault(number, 0);
            sb.append(value).append(' ');
        }
        System.out.println(sb);
    }
}