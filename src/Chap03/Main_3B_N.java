package Chap03;

import java.lang.*;
import java.util.*;


public class Main_3B_N {
    public static final Scanner scanner = new Scanner(System.in);
    public static final int MAX_SEAT_NUMBER = 1000;
    public static final int MAX_COLOR_NUMBER = 100;

    /**
     * @param n         : 좌석의 수. 좌석은 0~(n-1)번의 번호를 가진다.
     * @param m         : 좌석을 칠한 횟수.
     * @param paintings : 좌석들을 색칠한 이벤트들의 정보
     */
    public static void solve(int n, int m, Painting[] paintings) {
        int[] seats = new int[n]; //seats[i] := i번 좌석의 최종 색상
        int[] colorList = new int[MAX_COLOR_NUMBER];


        for (int i = 0; i < m; i++) {
            for (int j = paintings[i].left; j <= paintings[i].right; j++) {
                seats[j] = paintings[i].color;
            }
        }

        for (int i = 0; i < n; i++) {
                colorList[seats[i]]++;
        }

        int minColor = seats[0]; //가장 적게 등장한 색상
        int maxColor = seats[0]; //가장 많이 등장한 색상

        for (int i = 0; i < MAX_COLOR_NUMBER; i++) {

            if(colorList[i] == 0){
                continue;
            }

            if (colorList[minColor] > colorList[i]) {
                minColor = i;
            }
            if (colorList[maxColor] < colorList[i]) {
                maxColor = i;
            }
        }

        System.out.println(maxColor);
        System.out.println(minColor);
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //paintings[i] := i번째에 일어난 색칠 이벤트의 정보
        Painting[] paintings = new Painting[m];


        for (int i = 0; i < m; i++) {
            //좌석의 번호는 1번부터 시작하므로, 0 ~ (n-1)범위로 맞추기 위하여 1씩 빼준다
            int left = scanner.nextInt() - 1;
            int right = scanner.nextInt() - 1;
            int color = scanner.nextInt();
            paintings[i] = new Painting(left, right, color);
        }

        //문제의 정답을 구한다
        solve(n, m, paintings);
    }

}

//좌석들을 한 번 색칠하는 이벤트에 대한 정보
class Painting {
    int left;
    int right;
    int color;

    Painting(int left, int right, int color) {
        this.left = left;
        this.right = right;
        this.color = color;
    }
}