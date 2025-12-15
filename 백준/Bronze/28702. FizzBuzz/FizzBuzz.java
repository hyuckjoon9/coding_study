import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int targetNum = 0;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();

            boolean isDigit = isDigit(str);
            if (isDigit) {
                targetNum = Integer.parseInt(str);
                targetNum += (3 - i);
            }
        }

        if (targetNum % 3 == 0 && targetNum % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (targetNum % 3 == 0) {
            System.out.println("Fizz");
        } else if (targetNum % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(targetNum);
        }


    }

    public static boolean isDigit(String str) {
        try {
            int num = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}