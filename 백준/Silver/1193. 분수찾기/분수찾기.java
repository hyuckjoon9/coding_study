import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int step = 1;
        while ((step * (step + 1)) / 2 < n) {
            step++;
        }

        int startN = ((step - 1) * step) / 2 + 1;
        int numerator = 0;
        int denominator = 0;

        if (step % 2 == 0) {
            numerator = 1;
            denominator = step;
            while (startN != n) {
                numerator++;
                denominator--;
                startN++;
            }
        } else {
            numerator = step;
            denominator = 1;
            while (startN != n) {
                numerator--;
                denominator++;
                startN++;
            }
        }
        System.out.println(numerator + "/" + denominator);
    }
}