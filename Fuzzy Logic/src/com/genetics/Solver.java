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

    //substitute variables with values already calcualted before in fuzzifiaction then apply rules AND OR (MIN / MAX)
    public void inferenceRule(Rule rule){
        float var1,var2;
        var1=var2=0;
        ArrayList<Float>results=new ArrayList<>();
        ArrayList<String>operations=new ArrayList<>();
        while(rule.inputVariables.size()>0){
            for(int x=0;x<variables.size();x++){
                if(variables.get(x).getName().equals(rule.inputVariables.get(0))){
                    var1=variables.get(x).getTermValue(rule.inputTerms.get(0));
                }
                if(variables.get(x).getName().equals(rule.inputVariables.get(1))){
                    var2=variables.get(x).getTermValue(rule.inputTerms.get(1));
                }
            }

            results.add(var1);
            results.add(var2);
            operations.add(rule.operations.get(0));
            rule.operations.remove(0);
            rule.inputVariables.remove(0);
            rule.inputVariables.remove(0);
            rule.inputTerms.remove(0);
            rule.inputTerms.remove(0);

        }
        while (operations.size()>0){
            float temp;
            if(operations.get(0).equals("AND")){
                temp=Float.min(results.get(0),results.get(1));
            }else{
                temp=Float.max(results.get(0),results.get(1));
            }
            operations.remove(0);
            results.remove(0);
            results.set(0,temp);
        }
        System.out.println(results.get(0)+" "+rule.outputTerm);
        if(results.get(0)!=Float.MIN_VALUE){

            outputVariable.setTermValue(rule.outputTerm,results.get(0));
        }
    }

    public void defuzzification(){

        float sum1=0;
        float sum2=0;
        for(String term:outputVariable.terms.keySet()){
            System.out.print(outputVariable.terms.get(term)+"*"+term+" + ");
            sum1+=outputVariable.terms.get(term);
            sum2+=outputVariable.terms.get(term)*outputVariable.getShape(term).calculateCentroid();;
        }
        System.out.println("\n____________________________________________________");
        System.out.println("\t\t\t\t"+sum1);
        System.out.println("=");
        System.out.println(sum2/sum1);
    }
}
