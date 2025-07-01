import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> {
            int firstAbs = Math.abs(a);
            int secondAbs = Math.abs(b);
            if (firstAbs == secondAbs) return a > b ? 1 : -1;
            else return firstAbs - secondAbs;

        });
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                sb.append(p.isEmpty() ? "0\n" : p.poll() + "\n");
                continue;
            }
            p.add(num);
        }
        System.out.println(sb);
    }
}