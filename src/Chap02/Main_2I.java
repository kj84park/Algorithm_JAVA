package Chap02;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Main_2I {
    public static final Scanner scanner = new Scanner(System.in);
    //static boolean table[] = new boolean[1000000];

    /**
     * 배열의 N개의 원소가 연속적인 정수 수열로 표현될 수 있는지 판단하는 함수
     * @param data
     * @param n
     * @return
     */
//    public static boolean isConsecutive(int[] data, int n)
//    {
//        int min = Integer.MAX_VALUE;
//        for(int i = 0 ; i < n ; i++){
//         if( min > data[i]){
//             min = data[i];
//            }
//            table[data[i]] = true;
//        }
//
//        for(int i = min ; i <min+n-1 ; i++){
//            if(!table[i + 1]){
//                return false;
//            }
//        }
//
//        return true;
//
//    }

    public static boolean isConsecutive(int[] data, int n)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(min > data[i]){
                min = data[i];
            }
            if(max < data[i]){
                max = data[i];
            }
        }

        return max - min == n - 1;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i ++)
        {
            data[i] = scanner.nextInt();
        }

        boolean result = isConsecutive(data, n);

        if(result)
        {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
