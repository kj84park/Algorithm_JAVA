package Chap05;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_5E {
    public static final Scanner scanner = new Scanner(System.in);
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int[] dirC = { 1, 0, -1 , 0};
    static final int[] dirR = { 0, 1, 0 , -1};


    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }

        writer.flush();
        writer.close();
    }

    private static void testCase(int caseIndex) throws IOException {
        int N = scanner.nextInt();

        int[][] map = new int[N][N];

        int cr = 0;
        int cc = 0;
        int cdir = 0;

        for (int i = 0 ; i < N*N ; i++){

            map [cc][cr] = (i+1);

            int nr = cr + dirR[cdir];
            int nc = cc + dirC[cdir];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nc][nr] != 0){
                cdir = (cdir +1) %4;
            }

            cr = cr + dirR[cdir];
            cc = cc + dirC[cdir];
        }


        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N ; j++){
                    if(j > 0){
                        writer.write(" ");
                    }
                writer.write(String.valueOf(map[j][i]));
            }
            writer.write("\n");
        }
        writer.flush();
    }
}
