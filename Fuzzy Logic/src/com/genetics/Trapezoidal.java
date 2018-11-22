package com.genetics;

public class Trapezoidal extends Shape{

    public Trapezoidal(String name,int[] points){
        this.name=name;
        this.points=new Point[4];
        for(int i=0;i<points.length;i++){
            if(i==0||i==points.length-1)
                this.points[i]=new Point(points[i],0);
            else
                this.points[i]=new Point(points[i],1);
        }
    }
}
