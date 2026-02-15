import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();


        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
                continue;
            } else if (command.equals("empty")) {
                set.clear();
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if (command.equals("add")) {
                set.add(num);
            } else if (command.equals("check")) {
                sb.append(set.contains(num) ? 1 : 0).append("\n");
            } else if (command.equals("remove")) {
                set.remove(num);
            } else if (command.equals("toggle")) {
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            }
        }
        System.out.println(sb);
    }
}