package Chap06;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main_6A {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 괄호들의 정보가 차례로 배열로 주어질 때, 올바른 괄호 문자열인지 판단하는 함수
     *
     * @param n             괄호 문자열의 길이
     * @param parentheses   괄호 문자에 대한 배열
     * @return
     */
    public static boolean isValidParentheses(int n, Parenthesis[] parentheses) {
        // 현재 짝을 찾지 못한 열린 괄호들
        Stack<Parenthesis> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){

            if(parentheses[i].type == Parenthesis.OPEN){
                stack.push(parentheses[i]);
            } else {

                if(stack.size() > 0 && stack.peek().type == Parenthesis.OPEN){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }

        if(stack.size() != 0){
            return false;
        }
        return true;
    }

    public static void testCase(int caseIndex) {
        String input = scanner.next();
        int n = input.length();

        Parenthesis[] parentheses = new Parenthesis[n];

        for (int i = 0; i < n; i++) {
            parentheses[i] = new Parenthesis(i, input.charAt(i));
        }

        boolean isValid = isValidParentheses(n, parentheses);

        if (isValid) {
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

class Parenthesis {
    public static final boolean OPEN = true;
    public static final boolean CLOSE = false;

    public final boolean type;  // 열린 괄호면 true, 닫힌 괄호면 false
    public final int index;     // 해당 괄호의 인덱스

    public Parenthesis(int index, boolean type) {
        this.index = index;
        this.type = type;
    }

    public Parenthesis(int index, char c) {
        this.index = index;
        if (c == '(') {
            this.type = OPEN;
        } else {
            this.type = CLOSE;
        }
    }
}