package Chap05;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Main_5B {
    public static final Scanner scanner = new Scanner(System.in);

    public static void testCase(int caseIndex) {
        int N = scanner.nextInt();  // 지도의 크기
        int K = scanner.nextInt();  // 놀이공원의 크기

        int[][] wastes = new int[N][N]; // 각 칸의 쓰레기 존재 여부
        for (int r = 0; r < N; r += 1) {
            for (int c = 0; c < N; c += 1) {
                wastes[r][c] = scanner.nextInt();
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int r = 0 ; r + K -1 <= N -1 ; r++){
            int count = 0;

            for (int c = 0 ; c < N ; c++){

                for (int dr = 0 ; dr < K ; dr++){
                    count += wastes[r+dr][c];
                }

                if(c >= K){
                    for (int dr = 0 ; dr < K ; dr++){
                        count -= wastes[r+dr][c-K];
                    }
                }

                if(c >= K-1){
                    if(answer > count){
                        answer = count;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }

    }

}
