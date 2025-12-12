import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        StringBuilder sb = new StringBuilder();

        int result1 = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);
        int result2 = Integer.parseInt(a + b) - Integer.parseInt(c);

        sb.append(result1).append("\n").append(result2);
        System.out.println(sb);
    }
}