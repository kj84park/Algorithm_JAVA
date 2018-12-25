package Chap01;

import java.lang.*;
import java.util.*;


public class Main_1J {
    public static final Scanner scanner = new Scanner(System.in);
    static int num[] = new int[2001];
    /**
     * 1부터 N까지의 자연수의 합을 계산하는 함수
     * @param i
     * @return
     */
    public static int getRangeSumFromOne(int i) {

        if(i == 1){
            num[0] = 0;
            num[1] = 1;
            return num[1];
        }

        if(num[i-1] != -1){
            num[i] =  num[i-1] + i;
            return num[i];
        } else {
            return -1;
        }
    }


    public static long getAnswer(int N)
    {
        long sum = 0;
        for(int i = 1 ; i <= N ; i++){
             sum += getRangeSumFromOne(i);
        }
        return sum;
    }


    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();

        for(int i = 0 ; i < num.length; i++){
            num[i] = -1;
        }

        long answer = getAnswer(n);

        System.out.println(answer);
    }

}
