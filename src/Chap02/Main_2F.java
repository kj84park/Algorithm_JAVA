package Chap02;

import java.lang.*;
import java.util.*;

public class Main_2F {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        Point2D[] points = new Point2D[n];

        double dist[][] = new double[n][n];
        double minDist = Double.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point2D(x, y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = points[i].getDistanceTo(points[j]);
                if (minDist > dist[i][j]) {
                    minDist = dist[i][j];
                    count = 1;
                } else if (minDist == dist[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(String.format("%.1f", minDist));
        System.out.println(count);
    }
}

class Point2D {
    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 2차원 평면 상에서 점 this부터 점 target까지 거리의 제곱을 계산하는 함수
     *
     * @param target
     * @return
     */
    public int getSquaredDistanceTo(Point2D target) {
        int dx = Math.abs(target.x - this.x);
        int dy = Math.abs(target.y - this.y);
        return dx * dx + dy * dy;
    }

    public double getDistanceTo(Point2D target) {
        double sqd = (double) this.getSquaredDistanceTo(target);
        return Math.sqrt(sqd);
    }

}
