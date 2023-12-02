import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class BruteCollinearPoints {

    private final LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        // 1.null check
        if (points == null)
            throw new IllegalArgumentException("Input is null");
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null)
                throw new IllegalArgumentException("Input contains null");
        }

        // copy input parameter to avoid direct modify
        Point[] localPoints = points.clone();

        // sort local point to avoid mutate input
        Arrays.sort(localPoints);

        // 2.duplicate check
        if (localPoints.length > 1) {
            for (int m = 1; m < localPoints.length; m++) {
                if (localPoints[m].compareTo(localPoints[m - 1]) == 0)
                    throw new IllegalArgumentException("Input contains duplicate");
            }
        }

        ArrayList<LineSegment> res = new ArrayList<>();

        if (localPoints.length > 3) {
            Point[] temp = new Point[4];
            for (int i = 0; i < localPoints.length - 3; i++) {
                temp[0] = localPoints[i];
                for (int j = i + 1; j < localPoints.length - 2; j++) {
                    temp[1] = localPoints[j];
                    for (int k = j + 1; k < localPoints.length - 1; k++) {
                        temp[2] = localPoints[k];
                        for (int p = k + 1; p < localPoints.length; p++) {
                            temp[3] = localPoints[p];
                            if (collinear(temp)) {
                                LineSegment segment = getSeg(temp);
                                res.add(segment);
                            }

                        }
                    }
                }
            }
        }

        segments = res.toArray(new LineSegment[res.size()]);

    }

    private boolean collinear(Point[] temp) {
        double slop1 = temp[0].slopeTo(temp[1]);
        double slop2 = temp[0].slopeTo(temp[2]);
        double slop3 = temp[0].slopeTo(temp[3]);
        if ((Double.compare(slop1, slop2) == 0) && (Double.compare(slop1, slop3) == 0))
            return true;
        return false;
    }

    private LineSegment getSeg(Point[] temp) {
        Arrays.sort(temp);
        return new LineSegment(temp[0], temp[3]);
    }

    //the number of line segments
    public int numberOfSegments(){
        return segments.length;
    }

    //the line segments
    public LineSegment[] segments(){
        return segments.clone();
    }

    public static void main(String[] args){
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points  = new Point[n];
        for(int i = 0 ; i < n ; i ++ ){
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x,y);
        }

        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0,32768);
        StdDraw.setYscale(0,32768);

        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);

        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }

        // for (LineSegment segment : collinear.segments()) {
        //     StdOut.println(segment);
        //     segment.draw();
        // }
        StdDraw.show();

    }

  


}
