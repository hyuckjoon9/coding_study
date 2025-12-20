import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            m.put(i, 0);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int targetIdx = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < K; j++) {
                targetIdx++;
                if (targetIdx == N + 1) targetIdx = 1;
                while (m.getOrDefault(targetIdx, 0) != 0) {
                    targetIdx++;
                    if (targetIdx == N + 1) targetIdx = 1;
                }
            }
            m.put(targetIdx, 1);
            sb.append(targetIdx);
            if (i != N) sb.append(',').append(' ');
        }
        sb.append('>');
        System.out.println(sb);
    }
}