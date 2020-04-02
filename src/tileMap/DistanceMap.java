package tileMap;

import java.awt.*;
import java.util.*;

public class DistanceMap {
    private int[][] collisionMap;
    private int targetX;
    private int targetY;
    private boolean[][] map = new boolean[60][32];
    private double[][] distanceMap = new double[60][32];


    public DistanceMap(int[][] collisionMap, int targetX, int targetY) {
        this.collisionMap = collisionMap;
        this.targetX = targetX;
        this.targetY = targetY;

        recalculate();
    }

    public void recalculate() {
        for (int y = 0; y < 32; y++){
            for (int x = 0; x < 60; x++){
                if (collisionMap[y][x] != 0){
                    map[x][y] = true;
                }
                else map[x][y] = false;
            }
        }

        map[targetX][targetY] = false;
        for (int x = 0; x < 60; x++) {
            for (int y = 0; y < 32; y++) {
                distanceMap[x][y] = Integer.MAX_VALUE;
            }
        }

        Queue<Point> points = new LinkedList<>();
        points.offer(new Point(targetX, targetY));
        distanceMap[targetX][targetY] = 0;
        while (!points.isEmpty()) {
            Point p = points.poll();

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    // Check new point is inside field
                    if (p.x + x < 0 || p.x + x >= 60 || p.y + y < 0 || p.y + y >= 32 || Math.abs(x) == Math.abs(y)) {
                        continue;
                    }
                    double d = distanceMap[p.x][p.y] + Math.sqrt(x * x + y * y);
                    if (d < distanceMap[p.x + x][p.y + y] && !map[p.x + x][p.y + y]) {
                        distanceMap[p.x + x][p.y + y] = d;
                        points.offer(new Point(p.x + x, p.y + y));
                    }
                }
            }
        }
    }


    public double[][] getDistanceMap() {
        return distanceMap;
    }
}
