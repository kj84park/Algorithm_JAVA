package Chap03;

import java.lang.*;
import java.util.*;


public class Main_3J {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 중복을 포함해 네 카드의 합으로 만들 수 있는 당첨번호들의 리스트를 반환하는 함수
     *
     * @param n      카드의 수
     * @param m      검사하려는 당첨번호의 수
     * @param cards  각 카드에 적힌 숫자들
     * @param target 검사하려는 각 당첨번호 리스트
     * @return 네 카드의 합으로 표현될 수 있는 당첨번호들의 오름차순 리스트
     */
    public static ArrayList<Integer> getPossibleTargets(int n, int m, int[] cards, int[] target) {
        ArrayList<Integer> possibleTargets = new ArrayList<>(); //만들 수 있는 당첨번호들
        List<CardPair> pairList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                pairList.add(new CardPair(cards[i], cards[j]));
            }
        }

        Collections.sort(pairList);

        for (int targetNum : target) {
            boolean possible = false;

            for (CardPair pair : pairList) {
                int candidateNum = targetNum - pair.sumOfCards;

//                    if(candidateNum > pair.sumOfCards+ (pairList.get(0).sumOfCards*2) || candidateNum < pair.sumOfCards+(pairList.get(pairList.size()-1).sumOfCards*2)){
//                        continue;
//                    }

                CardPair targetPair = new CardPair(candidateNum);
                int candidateTargetPairIndex = Collections.binarySearch(pairList, targetPair);
                if (candidateTargetPairIndex > -1) {
                    possibleTargets.add(targetNum);
                    //possible = true;
                    break;
                }
            }

//            if(possible){
//                break;
//            }
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


        if (answers.size() == 0) { // 가능한 당첨번호가 없다면 NO를 출력한다
            System.out.print("NO");
        } else { //가능한 당첨번호가 존재한다면 그 목록을 출력한다.
            for (int i = 0; i < answers.size(); i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(answers.get(i));
            }
        }
    }
}


class CardPair implements Comparable<CardPair> {   // 두 개의 카드 조합을 나타내는 클래스

    int card1;
    int card2;
    int sumOfCards; //두 카드의 합

    //두 카드의 정보를 알 때
    CardPair(int card1, int card2) {
        this.card1 = card1;
        this.card2 = card2;
        this.sumOfCards = this.card1 + this.card2;
    }

    // 두 카드의 정보를 모르고 합만 알 때
    CardPair(int sumOfCards) {
        this.sumOfCards = sumOfCards;
        this.card1 = -1;
        this.card2 = -1;
    }

    // 두 카드의 합으로 짝들의 대소 관계를 정의한다.
    @Override
    public int compareTo(CardPair o) {
        return this.sumOfCards - o.sumOfCards;
    }
}


