package com.genetics;

public class Triangular extends Shape {

    public Triangular(String name,float[] points){
        this.name=name;
        this.points=new Point[3];
        for(int i=0;i<points.length;i++){
            if(i==0||i==points.length-1)
                this.points[i]=new Point(points[i],0);
            else
                this.points[i]=new Point(points[i],1);
        }
    }


}
