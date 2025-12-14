import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int leftSum = 1;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (N <= leftSum) {
                System.out.println(i);
                return;
            }
            leftSum += i * 6;
        }
    }

}