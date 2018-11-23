package com.genetics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Rule rule1=new Rule("var1 = Left AND var2 = A OR var3 = B then outputVar = X");
//        for(int i=0;i<rule1.variables.size();i++)
//            System.out.print(rule1.variables.get(i)+" ");
//        System.out.println();
//        for(int i=0;i<rule1.terms.size();i++)
//            System.out.print(rule1.terms.get(i)+" ");
//        System.out.println();
//        for(int i=0;i<rule1.operations.size();i++)
//            System.out.print(rule1.operations.get(i)+" ");
//        System.out.println();
//        System.out.println(rule1.outputVariable+" "+rule1.outputTerm);


        Variable variable1=new Variable("OP",30);
        variable1.addShape("Low","triangle",new float[]{0,0,50});
        variable1.addShape("Medium","triangle",new float[]{0,50,100});
        variable1.addShape("High","triangle",new float[]{50,100,100});

        Variable variable2=new Variable("PDP",80);
        variable2.addShape("Low","triangle",new float[]{0,0,50});
        variable2.addShape("Medium","triangle",new float[]{0,50,100});
        variable2.addShape("High","triangle",new float[]{50,100,100});

        Variable variable3=new Variable("CP");
        variable3.addShape("Very Low","triangle",new float[]{0,0,25});
        variable3.addShape("Low","triangle",new float[]{0,25,50});
        variable3.addShape("Medium","triangle",new float[]{25,50,75});
        variable3.addShape("High","triangle",new float[]{50,75,100});
        variable3.addShape("Very High","triangle",new float[]{75,100,100});

        Rule rule1=new Rule("OP = Low AND PDP = Medium then CP = Low");
        Rule rule2=new Rule("OP = Medium AND PDP = Medium then CP = Medium");
        Rule rule3=new Rule("OP = Medium AND PDP = High then CP = High");

        Solver solver=new Solver(variable3);
        solver.addVariable(variable1);
        solver.addVariable(variable2);

        solver.inferenceRule(rule1);
        solver.inferenceRule(rule2);
        solver.inferenceRule(rule3);

        solver.defuzzification();


//        Variable variable1=new Variable("var1",(float)2.5);
//        variable1.addShape("Left", "trapezoidal",new float[]{0,1,3,4});
//        variable1.addShape("Right", "trapezoidal",new float[]{2,3,6,6});
//
//        Variable variable2=new Variable("var2",5);
//        variable2.addShape("A", "triangle",new float[]{0,3,3});
//        variable2.addShape("B", "trapezoidal",new float[]{(float)2.5,3,4,6});
//        variable2.addShape("C", "triangle",new float[]{(float)4.5,6,8});
//
//        Variable variable3=new Variable("var3",6);
//        variable3.addShape("A", "trapezoidal",new float[]{2,2,4,4});
//        variable3.addShape("B", "triangle",new float[]{4,4,8});
//
//        Variable variable4=new Variable("outputVar");
//        variable4.addShape("X", "trapezoidal",new float[]{1,1,4,5});
//        variable4.addShape("Y", "trapezoidal",new float[]{4,5,7,8});
//        variable4.addShape("Z", "triangle",new float[]{7,8,9});
//
//        Solver solver=new Solver(variable4);
//        solver.addVariable(variable1);
//        solver.addVariable(variable2);
//        solver.addVariable(variable3);
//
//        Rule rule1=new Rule("var1 = Left AND var2 = A then outputVar = X");
//        Rule rule2=new Rule("var2 = B OR var3 = A then outputVar = Y");
//        Rule rule3=new Rule("var1 = Right AND var2 = C then outputVar = Z");
//        Rule rule4=new Rule("var3 = B AND var2 = B then outputVar = X");
//
//        solver.inferenceRule(rule1);
//        solver.inferenceRule(rule2);
//        solver.inferenceRule(rule3);
//        solver.inferenceRule(rule4);
//
//        solver.defuzzification();



    }

}


