import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> answer = new ArrayDeque<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int questionNum = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            int[] q = split(questionNum);
            int strikeCount = 0;
            int ballCount = 0;

            if (i == 0) {
                for (int j = 100; j <= 999; j++) {
                    int[] comp = split(j);

                    if (comp[0] == 0 || comp[1] == 0 || comp[2] == 0) continue;
                    if (comp[0] == comp[1] || comp[0] == comp[2] || comp[1] == comp[2]) continue;

                    strikeCount = strikeCount(q, comp);
                    ballCount = ballCount(q, comp);

                    if (strikeCount == strike && ballCount == ball) answer.addLast(j);
                }
            } else {
                int r = answer.size();
                for (int j = 0; j < r; j++) {
                    int num = answer.removeFirst();

                    int[] comp = split(num);

                    strikeCount = strikeCount(q, comp);
                    ballCount = ballCount(q, comp);

                    if (strikeCount == strike && ballCount == ball) answer.addLast(num);
                }
            }
        }

        System.out.println(answer.size());

    }

    public static int[] split(int num) {
        int[] arr = new int[3];
        arr[0] = num / 100;
        arr[1] = num / 10 % 10;
        arr[2] = num % 10;

        return arr;
    }

    public static int strikeCount(int[] a, int[] b) {
        int strikeCount = 0;

        if (a[0] == b[0]) strikeCount++;
        if (a[1] == b[1]) strikeCount++;
        if (a[2] == b[2]) strikeCount++;
        return strikeCount;
    }

    public static int ballCount(int[] a, int[] b) {
        int ballCount = 0;
        if (a[0] == b[1] || a[0] == b[2]) ballCount++;
        if (a[1] == b[0] || a[1] == b[2]) ballCount++;
        if (a[2] == b[0] || a[2] == b[1]) ballCount++;

        return ballCount;
    }
}