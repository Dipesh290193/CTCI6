package src.Google;

import java.util.ArrayList;
import java.util.List;

public class FindRetangle {


    public static void main(String args[]){
        List<Point> points = new ArrayList<>();

        points.add(new Point(-1,3));
        points.add(new Point(-4,-3));
        points.add(new Point(-1,-2));
        points.add(new Point(-3,4));
        points.add(new Point(2,-2));
        points.add(new Point(3,4));
        points.add(new Point(-3,3));
        points.add(new Point(-4,-5));
        points.add(new Point(-3,-2));
        points.add(new Point(3,1));
        points.add(new Point(2,3));

        List<Point[]> verticalLine = getLine(points, true);
        List<Point[]> horizontalLine = getLine(points, false);

    }

    public static List<Point[]> getMinRectangle(List<Point[]> verticleLines, List<Point[]> horizontalLines){
        return null;
    }

    public static List<Point[]> getLine(List<Point> points, boolean isVertical){
        List<Point[]> lines = new ArrayList<>();
        for(int i = 0 ; i< points.size(); i++){
            for(int j = i+1; j < points.size(); j++){
                Point a = points.get(i);
                Point b = points.get(j);
                if(isVertical && a.x == b.x){
                    Point[] verticalPoints = new Point[2];
                    verticalPoints[0] = a;
                    verticalPoints[1] = b;
                    lines.add(verticalPoints);
                }
                if(!isVertical && a.y == b.y){
                    Point[] horizontalPoint = new Point[2];
                    horizontalPoint[0] = a;
                    horizontalPoint[1] = b;
                    lines.add(horizontalPoint);
                }
            }
        }
        return lines;
    }

    public static int getArea(Rectangle r){
        return Math.abs(r.A.x - r.B.x) * Math.abs(r.A.y - r.C.y);
    }
}

class Point{

    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }


}

class Rectangle{
    Point A;
    Point B;
    Point C;
    Point D;
}
