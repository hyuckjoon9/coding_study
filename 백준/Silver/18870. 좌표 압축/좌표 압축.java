import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> m = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            m.put(i, 0);
        }

        int[] copyArr = Arrays.copyOf(arr, N);
        Arrays.sort(copyArr);

        int prevIdx = 0;
        int diff = 0;
        for (int i = 0; i < N; i++) {
            if (copyArr[i] == copyArr[prevIdx]) {
                m.put(copyArr[i], diff);
            } else {
                prevIdx = i;
                diff++;
                m.put(copyArr[i], diff);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(m.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}