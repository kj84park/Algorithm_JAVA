package Chap04;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Main_4I {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_VALUE = 1000000;
    public static Sieve sieve = new Sieve(MAX_VALUE);

    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void testCase(int caseIndex) {
        int x = scanner.nextInt();

        int a = -1;
        int b = -1;

        for (int i = 3; i <= x/2 ; i++){
            if(sieve.isPrime[i]){
                int j = x - i;
                if(sieve.isPrime[j]){
                    a = i;
                    b = j;
                    break;
                }
            }
        }

        // 정답을 출력한다
        System.out.printf("Case #%d:\n", caseIndex);
        if(a > 0 && b > 0)
        {
            System.out.printf("%d = %d + %d\n", x, a, b);
        }else{
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }

    static class Sieve //소인수 분해를 빠르게
    {
        final int maximumValue;     // 에라토스테네스의 체에서 다룰 가장 큰 범위의 값
        final boolean[] isPrime;    // 각 숫자별 소수 여부

        Sieve(int maximumValue) {
            this.maximumValue = maximumValue;
            this.isPrime = new boolean[maximumValue + 1];
            this.fillSieve();
        }

        /**
         * @param num
         * @return 'num'이 소수라면 true, 그렇지 않으면 false
         */
        public boolean isPrimeNumber(int num) {
            return this.isPrime[num];
        }

        /**
         * isPrime 배열의 값을 채우는 함수
         */
        private void fillSieve() {
            isPrime[0] = false;
            isPrime[1] = false;

            for (int i = 2 ; i <= maximumValue ; i++ ) {
                isPrime[i] = true;
            }
            for (int j = 2; j * j <= maximumValue ; j++){
                if(!isPrime[j]){
                    continue;
                }
                for (int k = j*j; k <= maximumValue ; k += j){
                    isPrime[k] = false;
                }
            }
        }
    }
}
