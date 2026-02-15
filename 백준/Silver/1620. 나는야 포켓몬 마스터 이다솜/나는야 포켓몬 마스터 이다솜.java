import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToIndex = new HashMap<>();
        String[] indexToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToIndex.put(name, i);
            indexToName[i] = name;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String query = br.readLine();

            if (Character.isDigit(query.charAt(0))) {
                int idx = Integer.parseInt(query);
                sb.append(indexToName[idx]).append("\n");
            } else {
                sb.append(nameToIndex.get(query)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
