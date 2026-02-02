/*
 * 단어는 공백으로 구분
 * 만약 태그가 있다면 태그를 제외한 문자열만 뒤집기
 * 1. '<' 를 만나면 '>'가 나올때까지 sb에 넣기
 * 2. 단어를 만나면 공백을 만나거나 '<'를 만나거나 끝나거나.
 * Character List인 onlyWord에 공백, '<', 끝나기 전까지 넣기
 * 3. 공백, '<' 을 만났다면 onlyWord에 있는거 뒤집어서 sb에 넣기
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean isTag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                result.append(word.reverse());
                word.setLength(0);
                isTag = true;
                result.append(c);
            } else if (c == '>') {
                result.append(c);
                isTag = false;
            } else if (isTag) {
                result.append(c);
            } else {
                if (c == ' ') {
                    result.append(word.reverse().append(' '));
                    word.setLength(0);
                } else {
                    word.append(c);
                }
            }
        }

        result.append(word.reverse());

        System.out.println(result);

    }
}