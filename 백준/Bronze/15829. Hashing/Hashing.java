import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[L];
        int MOD = 1234567891;

        for (int i = 0; i < L; i++) {
            arr[i] = str.charAt(i) - 'a' + 1;
        }


        int ratioCnt = 0;
        int sum = 0;
        for (int i = 0; i < L; i++) {
            sum += arr[i] * (int) Math.pow(31, ratioCnt++);
        }
        System.out.println(sum % MOD);
    }


}