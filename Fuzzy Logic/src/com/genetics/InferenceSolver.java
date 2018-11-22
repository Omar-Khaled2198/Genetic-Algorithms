package com.genetics;

import java.util.ArrayList;

public class InferenceSolver {

    private ArrayList<Variable>variables;
    private Variable outputVariable;

    public InferenceSolver(Variable outputVariable){
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
            //System.out.println(var1+" "+var2);
            float inf=Float.min(var1,var2);
            outputVariable.setValue(rule.outputTerm,inf);
            System.out.println(inf+" "+rule.outputTerm);
        }else{
            float inf=Float.max(var1,var2);
            outputVariable.setValue(rule.outputTerm,inf);
            System.out.println(inf+" "+rule.outputTerm);
        }
    }
}
