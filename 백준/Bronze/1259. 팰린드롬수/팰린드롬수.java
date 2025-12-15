import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strN = br.readLine();
        while (!strN.equals("0")) {
            int start = 0;
            int end = strN.length() - 1;

            boolean isEqual = true;
            while (start <= end) {
                if (strN.charAt(start) != strN.charAt(end)) {
                    isEqual = false;
                    break;
                }
                start++;
                end--;
            }
            if (isEqual) System.out.println("yes");
            else System.out.println("no");
            strN = br.readLine();
        }


    }
}