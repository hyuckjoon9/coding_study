import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] cArr = new Node[n];
        for (int i = 0; i < n; i++) {
            cArr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(cArr);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, cArr[i].index + 1 - i);
        }
        System.out.println(max);
    }
}

class Node implements Comparable<Node> {
    int value;
    int index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Node n) {
        return this.value - n.value;
    }
}