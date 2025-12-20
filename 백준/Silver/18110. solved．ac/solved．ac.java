import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double excludeTotal = (double) n * 0.3;
        int excludeHalf = (int) Math.round(excludeTotal / 2);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = excludeHalf; i < n - excludeHalf; i++) {
            sum += arr[i];
        }

        int result = (int) Math.round((double) sum / (n - excludeHalf * 2));
        System.out.println(result);
    }
}