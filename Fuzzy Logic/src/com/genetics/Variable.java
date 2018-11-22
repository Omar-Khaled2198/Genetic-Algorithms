package com.genetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Variable {

    private String name;
    private int value;
    private ArrayList<Shape>shapes;
    private Map<String,Float> set;

    public Variable(String name,int value){
        this.name=name;
        this.value=value;
        this.set=new HashMap<>();
        this.shapes=new ArrayList<>();
    }

    public void addShape(String name,String type,int[] points){
        Shape shape=null;
        if(type.equals("triangle"))
            shape=new Triangular(name,points);
        else
            shape=new Trapezoidal(name,points);
        float y=shape.fuzzification(this.value);
        System.out.println(name+" "+y);
        set.put(name,y);
        shapes.add(shape);

    }
}
