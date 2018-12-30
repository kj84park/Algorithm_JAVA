package Chap05;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main_5P {

    public static final Scanner scanner = new Scanner(System.in);

    public static boolean isPossibleName(String fullName, int N, String[] words) {

        for (int i = 0 ; i < N ; i++){
            String prefix = words[i];

            if(!fullName.startsWith(prefix)){
                continue;
            }

            for (int j = 0 ; j < N; j++){
                String suffix = words[j];
                if(j == i || !fullName.endsWith(suffix)){
                    continue;
                }

                for (int k = 0 ; k < N; k++){
                    String middle = words[k];

                    if(j == k || k == i){
                        continue;
                    }

                    if(fullName.equals(prefix+middle+suffix)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();
        String fullName = scanner.next();
        String[] words = new String[N];
        for (int i = 0; i < N; i += 1) {
            words[i] = scanner.next();
        }

        boolean possible = isPossibleName(fullName, N, words);

        if (possible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}
