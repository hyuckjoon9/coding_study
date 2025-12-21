import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);

        int mean = (int) Math.round((double) sum / N);
        sb.append(mean).append("\n");

        int median = arr[N / 2];
        sb.append(median).append("\n");

        int mode = 0;
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0; i < N; i++) {
            m.compute(arr[i], (k, v) -> v == null ? 1 : v + 1);
        }

        int maxFreq = 0;
        for (int i = 0; i < N; i++) {
            maxFreq = Math.max(maxFreq, m.get(arr[i]));
        }

        int countOrder = 0;
        int prevValue = 5000;
        for (int i = 0; i < N; i++) {
            if (maxFreq == m.get(arr[i])) {
                if (prevValue == arr[i]) continue;
                countOrder++;
                mode = arr[i];
                prevValue = arr[i];
            }
            if (countOrder == 2) {
                sb.append(mode).append("\n");
                break;
            }
        }
        if (countOrder == 1) sb.append(mode).append("\n");

        int range = arr[arr.length - 1] - arr[0];
        sb.append(range);
        System.out.println(sb);
    }
}