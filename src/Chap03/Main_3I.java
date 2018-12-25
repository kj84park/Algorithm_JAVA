package Chap03;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Main_3I {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 중복을 포함해 세 카드의 합으로 만들 수 있는 당첨번호들의 리스트를 반환하는 함수
     *
     * @param n      카드의 수
     * @param m      검사하려는 당첨번호의 수
     * @param cards  각 카드에 적힌 숫자들
     * @param target 검사하려는 각 당첨번호 리스트
     * @return 세 카드의 합으로 표현될 수 있는 당첨번호들의 오름차순 리스트
     */
    public static ArrayList<Integer> getPossibleTargets(int n, int m, int[] cards, int[] target) {
        ArrayList<Integer> possibleTargets = new ArrayList<>(); //만들 수 있는 당첨번호들
        Arrays.sort(cards);

        for (int num : target) {
            for (int i = 0; i < n; i++) {

                if(cards[i] + cards[n-1]*2 < num || cards[i]+cards[0]*2 > num){
                    continue;
                }

                boolean hasNum = false;
                for (int j = 0; j < n; j++) {
                    int candidateNum = num - (cards[i] + cards[j]);

                    if(candidateNum < cards[0] || candidateNum > cards[n-1]){
                        continue;
                    }

                    if(candidateNum > 0) {
                        int resultIndex = Arrays.binarySearch(cards, candidateNum);
                        if (resultIndex > -1) {
                            possibleTargets.add(cards[i] + cards[j] + cards[resultIndex]);
                            hasNum = true;
                            break;
                        }
                    }
                }

                if(hasNum){
                    break;
                }
            }
        }

        Collections.sort(possibleTargets);
        return possibleTargets;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();  // 카드의 수
        int m = scanner.nextInt();  // 검사 할 후보 당첨번호의 수

        int[] cards = new int[n];
        int[] targets = new int[m];

        // 각 카드 정보를 입력받는다
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        // 각 당첨번호를 입력받는다
        for (int i = 0; i < m; i++) {
            targets[i] = scanner.nextInt();
        }

        ArrayList<Integer> answers = getPossibleTargets(n, m, cards, targets);

        if (answers.size() == 0) {
            System.out.print("NO");
        } else {
            for (int i = 0; i < answers.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(answers.get(i));
            }
        }
    }

}
