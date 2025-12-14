import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String strNum = String.valueOf(Math.abs(i));
            int[] arr = new int[strNum.length()];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = strNum.charAt(j) - '0';
            }

            int sum = i;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
            }
            if (sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

}