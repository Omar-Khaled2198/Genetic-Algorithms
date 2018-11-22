package com.genetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Variable {

    private String name;
    private float value;
    private ArrayList<Shape>shapes;
    private Map<String,Float> terms;

    public Variable(String name){
        this.name=name;
        this.value=-1;
        this.terms=new HashMap<>();
        this.shapes=new ArrayList<>();
    }

    public Variable(String name,float value){
        this.name=name;
        this.value=value;
        this.terms=new HashMap<>();
        this.shapes=new ArrayList<>();
    }

    public void addShape(String name,String type,float[] points){
        Shape shape=null;
        if(type.equals("triangle"))
            shape=new Triangular(name,points);
        else
            shape=new Trapezoidal(name,points);
        if(this.value!=-1){
            float y=shape.fuzzification(this.value);
//            System.out.println(name+" "+y);
            terms.put(name,y);
        }
        else
            terms.put(name,Float.MIN_VALUE);

        shapes.add(shape);
    }

    public String getName() {
        return name;
    }

    public float getValue(String name){
        return terms.get(name);
    }

    public void setValue(String name,float value){
        this.terms.put(name,value);
    }
}
