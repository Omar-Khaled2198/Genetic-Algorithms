package com.genetics;

public class Shape {

    public String name;
    Point[] points;


    public float fuzzification(int value){
        for(int i=0;i<points.length-1;i++){
            if(points[i].x!=points[i+1].x) {
                float slope = ((float) points[i + 1].y - (float) points[i].y) / ((float) points[i + 1].x - (float) points[i].x);
                float b = (float) points[i].y - (slope * (float) points[i].x);
                float y = slope * (float) value + b;
                if (y <= 1 && y > 0)
                    return y;
            }
        }
        return Float.MIN_VALUE;
    }
}
