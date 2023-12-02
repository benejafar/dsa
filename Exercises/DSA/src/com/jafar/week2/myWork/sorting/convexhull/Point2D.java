package com.jafar.week2.myWork.sorting.convexhull;

public class Point2D {
    private final double x;
    private final double y;

    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static int ccw(Point2D a, Point2D b, Point2D c){
        double area = (b.x - a.x)*(c.y - a.y) - (b.y - a.y)*(c.x - a.x);
        if (area < 0) return -1;
        else if(area > 0) return +1;
        else return 0;
    }
}
