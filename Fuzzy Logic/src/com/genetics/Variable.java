package com.genetics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Variable {

    private String name;
    private float value;
    public ArrayList<Shape>shapes;
    public Map<String,Float> terms;

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
        Shape shape=new Shape(name,type,points);
        //as there are two types of variables input and output
        //value = -1 mean this variable is output variable not input so i won't call fuzzification
        if(this.value!=-1){
            float y=shape.fuzzification(this.value);
            System.out.println(name+"("+this.value+") = "+y);
            terms.put(name,y);
        }

        shapes.add(shape);
    }

    public Shape getShape(String name){
        for(int i=0;i<shapes.size();i++)
            if(shapes.get(i).name.equals(name))
                return shapes.get(i);
        return null;
    }

    public String getName() {
        return name;
    }

    public float getTermValue(String name){
        return terms.get(name);
    }

    public void setTermValue(String name,float value){
        this.terms.put(name,value);
    }


}
