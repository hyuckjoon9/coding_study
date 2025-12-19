import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 665;
        int order = 0;
        while (true) {
            num++;
            String strNum = String.valueOf(num);


            int cnt = 0;
            for (int i = strNum.length() - 1; i > 1; i--) {
                // 1666
                if (strNum.charAt(i) == '6' && strNum.charAt(i - 1) == '6' && strNum.charAt(i - 2) == '6') cnt += 3;
                if (cnt >= 3) {
                    order++;
                    break;
                }
            }
            if (order == N) break;
        }
        System.out.println(num);
        
    }


}