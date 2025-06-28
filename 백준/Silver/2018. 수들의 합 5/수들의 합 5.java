import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        int end = 1;
        int answer = 1;
        while (end != n) {
            int sum = 0;
            sum = (end * (end + 1) - start * (start - 1)) / 2;
            if (sum < n) end++;
            else if (sum > n) start++;
            else {
                end++;
                answer++;
            }
        }
        System.out.println(answer);
    }
}