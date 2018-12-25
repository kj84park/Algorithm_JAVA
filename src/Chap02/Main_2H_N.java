package Chap02;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Main_2H_N {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 왼쪽 아래 좌표가 (x,y)인 픽셀이 반지름 R인 원에 포함되는가?
     * @param x
     * @param y
     * @param R
     * @return  포함된다면 true, else false
     */
    public static boolean isInside(long x, long y, long R)
    {
        if( (x*x + y*y ) < R*R ){
            return true;
        }
        return false;
    }

    public static void testCase(int caseIndex) {
        long R = scanner.nextLong();
        long y = R;
        long sum = 0;

        for (long x  = 0 ; x <= R; x++){
            long height = 0;
            for ( ; y >= 0 ; y-- ){
                if(isInside(x,y,R)){
                    height = (y+1);
                    break;
                }
            }

            sum+=height;
//            while(!isInside(i,h,R) && h > 1){
//                h--;
//            }
//            sum += h;
        }

        System.out.printf("#%d\n", caseIndex);
        System.out.println(sum*4);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }

}
