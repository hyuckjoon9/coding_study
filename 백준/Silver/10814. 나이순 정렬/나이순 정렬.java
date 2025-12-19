import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person();
            people[i].age = Integer.parseInt(st.nextToken());
            people[i].name = st.nextToken();
        }

        Arrays.sort(people, (a, b) -> a.age - b.age);

        StringBuilder sb = new StringBuilder();
        for (Person p : people) {
            sb.append(p.age).append(' ').append(p.name).append("\n");
        }
        System.out.println(sb);


    }
}

class Person {
    int age;
    String name;
}