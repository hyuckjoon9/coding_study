import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] curState = new int[4];
    static int[] checkDna = new int[4];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String dna = st.nextToken();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkDna[i] = Integer.parseInt(st.nextToken());
            if (checkDna[i] == 0) checkSecret++;
        }
        for (int j = 0; j < p; j++) {
            char c = dna.charAt(j);
            add(c);
        }

        int answer = 0;
        if (checkSecret == 4) answer++;

        for (int i = p; i < s; i++) {
            int prevIdx = i - p;
            int nextIdx = i;
            remove(dna.charAt(prevIdx));
            add(dna.charAt(nextIdx));
            if (checkSecret == 4) answer++;
        }
        System.out.println(answer);
    }

    static public void add(char c) {
        if (c == 'A') {
            curState[0]++;
            if (curState[0] == checkDna[0]) checkSecret++;
        } else if (c == 'C') {
            curState[1]++;
            if (curState[1] == checkDna[1]) checkSecret++;
        } else if (c == 'G') {
            curState[2]++;
            if (curState[2] == checkDna[2]) checkSecret++;
        } else if (c == 'T') {
            curState[3]++;
            if (curState[3] == checkDna[3]) checkSecret++;
        }
    }

    static public void remove(char c) {
        if (c == 'A') {
            if (curState[0] == checkDna[0]) checkSecret--;
            curState[0]--;
        } else if (c == 'C') {
            if (curState[1] == checkDna[1]) checkSecret--;
            curState[1]--;
        } else if (c == 'G') {
            if (curState[2] == checkDna[2]) checkSecret--;
            curState[2]--;
        } else if (c == 'T') {
            if (curState[3] == checkDna[3]) checkSecret--;
            curState[3]--;
        }
    }
}