package com.genetics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Variable variable1=new Variable("var1",(float)2.5);
        variable1.addShape("Left", "trapezoidal",new float[]{0,1,3,4});
        variable1.addShape("Right", "trapezoidal",new float[]{2,3,6,6});

        Variable variable2=new Variable("var2",5);
        variable2.addShape("A", "triangle",new float[]{0,3,3});
        variable2.addShape("B", "trapezoidal",new float[]{(float)2.5,3,4,6});
        variable2.addShape("C", "triangle",new float[]{(float)4.5,6,8});

        Variable variable3=new Variable("var3",6);
        variable3.addShape("A", "trapezoidal",new float[]{2,2,4,4});
        variable3.addShape("B", "triangle",new float[]{4,4,8});

        Variable variable4=new Variable("outputVar");
        variable4.addShape("X", "trapezoidal",new float[]{1,1,4,5});
        variable4.addShape("Y", "trapezoidal",new float[]{4,5,7,8});
        variable4.addShape("Z", "triangle",new float[]{7,8,9});

        InferenceSolver inferenceSolver=new InferenceSolver(variable3);
        inferenceSolver.addVariable(variable1);
        inferenceSolver.addVariable(variable2);
        inferenceSolver.addVariable(variable3);

        Rule rule1=new Rule("var1 = Left AND var2 = A then outputVar = X");
        Rule rule2=new Rule("var2 = B OR var3 = A then outputVar = Y");
        Rule rule3=new Rule("var1 = Right AND var2 = C then outputVar = Z");
        Rule rule4=new Rule("var3 = B AND var2 = B then outputVar = X");

        inferenceSolver.inferenceRule(rule1);
        inferenceSolver.inferenceRule(rule2);
        inferenceSolver.inferenceRule(rule3);
        inferenceSolver.inferenceRule(rule4);

    }
}
