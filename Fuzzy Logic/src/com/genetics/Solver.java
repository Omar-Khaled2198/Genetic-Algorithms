package com.genetics;

import java.util.ArrayList;

public class Solver{

    private ArrayList<Variable>variables;
    private Variable outputVariable;

    public Solver(Variable outputVariable){
        variables=new ArrayList<>();
        this.outputVariable=outputVariable;
    }

    public void addVariable(Variable variable){
        this.variables.add(variable);
    }

    public void inferenceRule(Rule rule){
        float var1,var2;
        var1=var2=0;
        for(int i=0;i<variables.size();i++){

            if(variables.get(i).getName().equals(rule.variable1)){
                var1=variables.get(i).getValue(rule.term1);
            }
            if(variables.get(i).getName().equals(rule.variable2))
                var2=variables.get(i).getValue(rule.term2);
        }

        if(rule.operation.equals("AND")){
            float inf=Float.min(var1,var2);
            if(inf!=Float.MIN_VALUE){
//                System.out.println(inf+" "+rule.outputTerm);
                outputVariable.setValue(rule.outputTerm,inf);
            }
        }else{
            float inf=Float.max(var1,var2);
            if(inf!=Float.MIN_VALUE) {
//                System.out.println(inf+" "+rule.outputTerm);
                outputVariable.setValue(rule.outputTerm, inf);
            }
        }
    }

    public void defuzzification(){

        float sum1=0;
        float sum2=0;
        for(String term:outputVariable.terms.keySet()){
            System.out.println(term);
            sum1+=outputVariable.terms.get(term);
            sum2+=outputVariable.terms.get(term)*outputVariable.getShape(term).calculateCentroid();;
        }
        System.out.println(sum2/sum1);
    }
}
