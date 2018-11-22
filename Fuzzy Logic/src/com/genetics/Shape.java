package com.genetics;

public class Shape {

    public String name;
    Point[] points;


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
}
