import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArr[];
    static int myArr[];
    static int checkResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char dna[] = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        checkArr = new int[4];
        myArr = new int[4];

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) checkResult++;
        }

        for (int i = 0; i < p; i++) {
            add(dna[i]);
        }

        int result = 0;

        if (checkResult == 4) {
            result++;
        }

        for (int i = p; i < s; i++) {
            int j = i - p;
            add(dna[i]);
            remove(dna[j]);
            if (checkResult == 4) result++;
        }
        System.out.print(result);
    }

    public static void add(char c) {
        if (c == 'A') {
            myArr[0]++;
            if (myArr[0] == checkArr[0]) checkResult++;
        } else if (c == 'C') {
            myArr[1]++;
            if (myArr[1] == checkArr[1]) checkResult++;
        } else if (c == 'G') {
            myArr[2]++;
            if (myArr[2] == checkArr[2]) checkResult++;
        } else if (c == 'T') {
            myArr[3]++;
            if (myArr[3] == checkArr[3]) checkResult++;
        }
    }

    public static void remove(char c) {
        if (c == 'A') {
            if (myArr[0] == checkArr[0]) checkResult--;
            myArr[0]--;
        } else if (c == 'C') {
            if (myArr[1] == checkArr[1]) checkResult--;
            myArr[1]--;
        } else if (c == 'G') {
            if (myArr[2] == checkArr[2]) checkResult--;
            myArr[2]--;
        } else if (c == 'T') {
            if (myArr[3] == checkArr[3]) checkResult--;
            myArr[3]--;
        }
    }
}
