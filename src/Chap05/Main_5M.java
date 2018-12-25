package Chap05;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main_5M {

    public static final Scanner scanner = new Scanner(System.in);
//    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int N = scanner.nextInt();

        String pattern = scanner.next();

        String inputs[] = new String[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = scanner.next();
        }

        List<String> matchedStrings = getMatchedStrings(pattern, inputs, N);

        for (String strings : matchedStrings) {
            System.out.println(strings);
        }

    }

    private static List<String> getMatchedStrings(String pattern, String[] inputs, int N) {

        List<String> matched = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (isMatched(pattern, inputs[i])) {
                matched.add(inputs[i]);
            }
        }

        return matched;
    }

    private static boolean isMatched(String pattern, String input) {
        if (pattern.length() != input.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            char inputChar = input.charAt(i);

            if (patternChar != inputChar && patternChar != '?') {
                return false;
            }
        }
        return true;
    }
}
