package Chap03;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Main_3H {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 중복을 포함해 두 카드의 합으로 만들 수 있는 당첨번호의 수를 계산하는 함수
     * @param n     카드의 수
     * @param m     검사하려는 당첨번호의 수
     * @param cards   각 카드에 적힌 숫자들
     * @param target  검사하려는 각 당첨번호 리스트
     * @return
     */
    public static int getPossibleTargetNumber(int n, int m, int[] cards, int[] target)
    {
        int answer = 0; //만들 수 있는 당첨번호의 수
        Arrays.sort(cards);

        for (int targetNum : target) {
            for (int i = 0; i < n; i++) {
                int candidate = targetNum - cards[i];
                int candidateIndex = Arrays.binarySearch(cards, candidate);
                if(candidateIndex > -1 ){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();  // 카드의 수
        int m = scanner.nextInt();  // 검사 할 후보 당첨번호의 수

        int[] cards = new int[n];
        int[] targets = new int[m];

        // 각 카드 정보를 입력받는다
        for(int i = 0 ; i < n ; i ++)
        {
            cards[i] = scanner.nextInt();
        }

        // 각 당첨번호를 입력받는다
        for(int i = 0 ; i < m ; i ++)
        {
            targets[i] = scanner.nextInt();
        }

        int answer = getPossibleTargetNumber(n, m, cards, targets);

        System.out.println(answer);
    }

}
