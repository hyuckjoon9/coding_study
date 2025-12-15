import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[L];
        int MOD = 1_234_567_891;

        for (int i = 0; i < L; i++) {
            arr[i] = str.charAt(i) - 'a' + 1;
        }

        long sum = 0;
        long r = 1;
        for (int i = 0; i < L; i++) {
            sum = (sum + (arr[i] * r)) % MOD;
            r = (r * 31) % MOD;
        }
        System.out.println(sum);
    }
}