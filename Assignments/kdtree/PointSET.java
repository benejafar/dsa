import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdOut;

public class PointSET {

    private SET<Point2D> pointSet;

    public PointSET() {
        pointSet = new SET<>();
    }

    public boolean isEmpty() {
        return pointSet.size() == 0;
    }

    public void insert(Point2D p) {
        if (!pointSet.contains(p)) {
            pointSet.add(p);
        }
    }

    public boolean contains(Point2D p) {
        return pointSet.contains(p);
    }

    public void draw() {
        Iterator<Point2D> pointsIterator = pointSet.iterator();
        while (pointsIterator.hasNext()) {
            pointsIterator.next().draw();
        }
    }

    //return the points which are inside the rectange
    public Iterable<Point2D> range(RectHV rect){
        SET<Point2D> insideRect = new SET<>();

        Iterator<Point2D> pointSetIterator = pointSet.iterator();
        while(pointSetIterator.hasNext()){
            Point2D temp = pointSetIterator.next();
            if (rect.contains(temp)){
                insideRect.add(temp);
            }
        }
        return insideRect;
    }

    public Point2D nearest(Point2D p){
        Iterator<Point2D> pointIterator = pointSet.iterator();
        Point2D nearestPoint2d = (pointIterator.hasNext() ? pointIterator.next() : null);
        while (pointIterator.hasNext()){
            Point2D temp = pointIterator.next();
            // distance to temp point
            double d1 = temp.distanceTo(p);
            double d2 = nearestPoint2d.distanceSquaredTo(p);
            if (d1 < d2){
                nearestPoint2d = temp;
            }
        }
        return nearestPoint2d;
    }



    public static void main(String[] args) {
        
    }
}
