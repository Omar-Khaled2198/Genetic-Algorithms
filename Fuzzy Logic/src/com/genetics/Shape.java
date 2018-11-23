package com.genetics;

public class Shape {

    public String name;
    public Point[] points;

    public Shape(String name,String type,float[] points){
        this.name=name;
        if(type.equals("triangle"))
            this.points=new Point[3];
        else
            this.points=new Point[4];
        for(int i=0;i<points.length;i++){
            if(i==0||i==points.length-1)
                this.points[i]=new Point(points[i],0);
            else
                this.points[i]=new Point(points[i],1);
        }
    }

    public float fuzzification(float value){
        for(int i=0;i<points.length-1;i++){
            if(points[i].x!=points[i+1].x) {
                float slope = (points[i + 1].y - points[i].y) / (points[i + 1].x - points[i].x);
                float b = points[i].y - (slope * points[i].x);
                float y = slope * value + b;
                if (y <= 1 && y > 0)
                    return y;
            }
        }
        return Float.MIN_VALUE;
    }

    public float calculateCentroid(){

        float centroidX = 0, centroidY = 0;
        for(Point knot : points) {
            centroidX += knot.x;
//            centroidY += knot.y;
        }
//        System.out.println(centroidX/(float)points.length+" "+centroidY/(float)points.length);
        return centroidX/(float)points.length;

    }
}
