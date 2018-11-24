package com.genetics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        System.out.println("Fuzzification");
//        System.out.println("================");
//        Variable variable1=new Variable("OP",30);
//        variable1.addShape("Low","triangle",new float[]{0,0,50});
//        variable1.addShape("Medium","triangle",new float[]{0,50,100});
//        variable1.addShape("High","triangle",new float[]{50,100,100});
//        System.out.println();
//        Variable variable2=new Variable("PDP",80);
//        variable2.addShape("Low","triangle",new float[]{0,0,50});
//        variable2.addShape("Medium","triangle",new float[]{0,50,100});
//        variable2.addShape("High","triangle",new float[]{50,100,100});
//        System.out.println();
//        Variable variable3=new Variable("CP");
//        variable3.addShape("Very Low","triangle",new float[]{0,0,25});
//        variable3.addShape("Low","triangle",new float[]{0,25,50});
//        variable3.addShape("Medium","triangle",new float[]{25,50,75});
//        variable3.addShape("High","triangle",new float[]{50,75,100});
//        variable3.addShape("Very High","triangle",new float[]{75,100,100});
//
//        System.out.println();
//        System.out.println("Inference");
//        System.out.println("===========");
//        Rule rule1=new Rule("OP = Low AND PDP = Medium then CP = Low");
//        Rule rule2=new Rule("OP = Medium AND PDP = Medium then CP = Medium");
//        Rule rule3=new Rule("OP = Medium AND PDP = High then CP = High");
//
//        Solver solver=new Solver(variable3);
//        solver.addVariable(variable1);
//        solver.addVariable(variable2);
//
//        solver.inferenceRule(rule1);
//        solver.inferenceRule(rule2);
//        solver.inferenceRule(rule3);
//
//        System.out.println();
//        System.out.println("Defuzzification");
//        System.out.println("=================");
//        solver.defuzzification();


//        System.out.println("Fuzzification");
//        System.out.println("================");
//        Variable variable1=new Variable("position",10);
//        variable1.addShape("Left","trapezoidal",new float[]{0,0,10,35});
//        variable1.addShape("LeftCenter","triangle",new float[]{30,40,50});
//        variable1.addShape("Center","triangle",new float[]{40,50,55});
//        System.out.println();
//
//
//        Variable variable2=new Variable("Angel",-45);
//        variable2.addShape("RBelow","triangle",new float[]{-90,-45,9});
//        variable2.addShape("RUpper","triangle",new float[]{-9,23,54});
//        variable2.addShape("LBelow","triangle",new float[]{171,255,270});
//        System.out.println();
//
//
//
//        Variable variable3=new Variable("firePosition");
//        variable3.addShape("NegBig","triangle",new float[]{-30,-30,-15});
//        variable3.addShape("NegMed","triangle",new float[]{-25,-15,-5});
//        variable3.addShape("NegSm","triangle",new float[]{-12,-6,0});
//        variable3.addShape("PosSm","triangle",new float[]{0,6,12});
//        variable3.addShape("PosMed","triangle",new float[]{5,15,25});
//
//        System.out.println();
//        System.out.println("Inference");
//        System.out.println("===========");
//        Rule rule1=new Rule("position = Left AND Angel = RBelow then firePosition = PosSm");
//        Rule rule2=new Rule("Angel = RBelow OR position = LeftCenter then firePosition = PosMed");
//        Rule rule3=new Rule("position = Center AND Angel = RBelow then firePosition = NegSm");
//        Rule rule4=new Rule("position = Center OR Angel = LBelow then firePosition = NegMed");
//
//        Solver solver=new Solver(variable3);
//        solver.addVariable(variable1);
//        solver.addVariable(variable2);
//
//        solver.inferenceRule(rule1);
//        solver.inferenceRule(rule2);
//        solver.inferenceRule(rule3);
//        solver.inferenceRule(rule4);
//
//        System.out.println();
//        System.out.println("Defuzzification");
//        System.out.println("=================");
//        solver.defuzzification();

//         System.out.println("Fuzzification");
//         System.out.println("================");
//         Variable variable1=new Variable("temp",65);
//         variable1.addShape("freezing","trapezoidal",new float[]{ 0,0,30,50});
//         variable1.addShape("cool","triangle",new float[]{30,50,70});
//         variable1.addShape("warm","triangle",new float[]{50,70,90});
//         variable1.addShape("hot","trapezoidal",new float[]{70,90,100,100});
//         System.out.println();
//
//         Variable variable2=new Variable("cover",25);
//         variable2.addShape("sunny","trapezoidal",new float[]{0,0,20,40});
//         variable2.addShape("partly","triangle",new float[]{20,50,80});
//         variable2.addShape("overcast","triangle",new float[]{60,80,100});
//         System.out.println();
//
//
//         Variable variable3=new Variable("speed");
//         variable3.addShape("slow","trapezoidal",new float[]{0,0,25,75});
//         variable3.addShape("fast","trapezoidal",new float[]{25,75,100,100});;
//
//         System.out.println();
//         System.out.println("Inference");
//         System.out.println("===========");
//
//         Rule rule1=new Rule("temp = warm AND cover = sunny then speed = fast");
//         Rule rule2=new Rule("temp = cool AND cover = overcast then speed = slow");
//
//
//         Solver solver=new Solver(variable3);
//        solver.addVariable(variable1);
//        solver.addVariable(variable2);
//
//        solver.inferenceRule(rule1);
//        solver.inferenceRule(rule2);
//
//        System.out.println();
//        System.out.println("Defuzzification");
//        System.out.println("=================");
//        solver.defuzzification();

        System.out.println("Fuzzification");
        System.out.println("================");
        Variable variable1=new Variable("var1",(float)2.5);
        variable1.addShape("Left", "trapezoidal",new float[]{0,1,3,4});
        variable1.addShape("Right", "trapezoidal",new float[]{2,3,6,6});
        System.out.println();
        Variable variable2=new Variable("var2",5);
        variable2.addShape("A", "triangle",new float[]{0,3,3});
        variable2.addShape("B", "trapezoidal",new float[]{(float)2.5,3,4,6});
        variable2.addShape("C", "triangle",new float[]{(float)4.5,6,8});
        System.out.println();
        Variable variable3=new Variable("var3",6);
        variable3.addShape("A", "trapezoidal",new float[]{2,2,4,4});
        variable3.addShape("B", "triangle",new float[]{4,4,8});
        System.out.println();
        Variable variable4=new Variable("outputVar");
        variable4.addShape("X", "trapezoidal",new float[]{1,1,4,5});
        variable4.addShape("Y", "trapezoidal",new float[]{4,5,7,8});
        variable4.addShape("Z", "triangle",new float[]{7,8,9});

        System.out.println();
        System.out.println("Inference");
        System.out.println("===========");
        Solver solver=new Solver(variable4);
        solver.addVariable(variable1);
        solver.addVariable(variable2);
        solver.addVariable(variable3);

        Rule rule1=new Rule("var1 = Left AND var2 = A then outputVar = X");
        Rule rule2=new Rule("var2 = B OR var3 = A then outputVar = Y");
        Rule rule3=new Rule("var1 = Right AND var2 = C then outputVar = Z");
        Rule rule4=new Rule("var3 = B AND var2 = B then outputVar = X");

        solver.inferenceRule(rule1);
        solver.inferenceRule(rule2);
        solver.inferenceRule(rule3);
        solver.inferenceRule(rule4);


        System.out.println();
        System.out.println("Defuzzification");
        System.out.println("=================");
        solver.defuzzification();



    }

}


