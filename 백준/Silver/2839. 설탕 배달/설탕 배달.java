import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count5 = N / 5;
        while (count5 >= 0) {
            int rest = N - count5 * 5;
            if (rest % 3 == 0) {
                int count3 = rest / 3;
                System.out.println(count5 + count3);
                return;
            }
            count5--;
        }
        System.out.println(-1);
    }
}