import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();

        int sum = 0;
        int startIdx = isbn.indexOf("*");

        for (int i = 0; i < isbn.length() - 1; i++) {
            if (i == startIdx) continue;
            int weight = (i % 2 == 0) ? 1 : 3;
            sum += (isbn.charAt(i) - '0') * weight;
        }

        sum += isbn.charAt(isbn.length() - 1) - '0';
        for (int i = 0; i <= 9; i++) {
            int weight = (startIdx % 2 == 0) ? 1 : 3;
            if ((sum + weight * i) % 10 == 0) {
                System.out.println(i);
                return;
            }

        }

    }
}