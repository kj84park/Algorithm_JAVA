package Chap06;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Main_6C {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 왼쪽에서 오른쪽으로 차례로 세워진 히스토그램들 내부에 만들 수 있는
     * 최대의 직사각형 넓이를 계산하는 함수
     *
     * @param n          히스토그램의 수
     * @param histograms 히스토그램이 차례로 저장된 배열
     * @return
     */
    public static long getLargestRectangleArea(int n, Histogram[] histograms) {
        long answer = 0;    // 최대 직사각형의 넓이

        // 현재 우측으로 확장 가능성이 있는 히스토그램들
        Stack<Histogram> continuedHistograms = new Stack<>();
        continuedHistograms.push(new Histogram(-1, 0));

        for (int i = 0; i <= n; i++) {

            Histogram h;

            if (i < n) {
                h = histograms[i];
            } else {
                h = new Histogram(n, 0);
            }

            while (continuedHistograms.size() > 1 && continuedHistograms.peek().height >= h.height) {
                Histogram leftH = continuedHistograms.pop();
                Histogram bh = continuedHistograms.peek();

                long width = Math.abs(h.leftX - bh.rightX);
                long height = leftH.height;
                long area = width * height;

                answer = Math.max(area, answer);
            }

            continuedHistograms.push(h);
        }
        return answer;
    }

    public static void testCase(int caseIndex) {
        int n = scanner.nextInt();

        Histogram[] histograms = new Histogram[n];
        for (int i = 0; i < n; i++) {
            int height = scanner.nextInt();
            histograms[i] = new Histogram(i, height);
        }

        long answer = getLargestRectangleArea(n, histograms);
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}

class Histogram {
    public final int height;    // 히스토그램의 높이
    public final int leftX;     // 인덱스 혹은 히스토그램의 왼쪽 변의 x 좌표
    public final int rightX;    // 히스토그램의 오른쪽 변의 x좌표

    public Histogram(int index, int height) {
        this.leftX = index;
        this.rightX = this.leftX + 1;   // 각 히스토그램은 너비가 1이므로
        this.height = height;
    }
}