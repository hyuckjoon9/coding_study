import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double answer = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (max < num) max = num;
            answer += num;
        }
        answer = (double) 100 * answer / (N * max);
        System.out.println(answer);
    }
}