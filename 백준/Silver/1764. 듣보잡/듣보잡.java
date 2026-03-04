import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Boolean> m1 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            m1.put(br.readLine(), true);
        }

        int cnt = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (m1.containsKey(str)) {
                cnt++;
                strings.add(str);
            }
        }

        Collections.sort(strings);
        int size = strings.size();

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb2.append(strings.get(i));
            } else {
                sb2.append(strings.get(i)).append("\n");
            }
        }

        sb1.append(cnt).append("\n").append(sb2);
        System.out.println(sb1);
    }
}
