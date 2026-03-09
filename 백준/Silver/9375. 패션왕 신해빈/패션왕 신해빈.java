import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> m = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = n;
            int comb = 1;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String value = st.nextToken();
                String key = st.nextToken();

                if (!m.containsKey(key)) m.put(key, 2);
                else m.put(key, m.get(key) + 1);
            }

            for (String string : m.keySet()) {
                comb *= m.get(string);
            }
            sb.append(comb - 1).append("\n");
            m.clear();
        }
        System.out.println(sb);
    }
}