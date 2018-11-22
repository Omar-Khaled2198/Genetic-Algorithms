package com.genetics;

public class Rule {

    public String variable1;
    public String term1;
    public String variable2;
    public String term2;
    public String operation;
    public String output;
    public String outputTerm;


    public Rule(String rule){
        String[] splitArray = rule.split("\\s+");
        this.variable1=splitArray[0];
        this.term1=splitArray[2];
        this.variable2=splitArray[4];
        this.term2=splitArray[6];
        this.operation=splitArray[3];
        this.output=splitArray[8];
        this.outputTerm=splitArray[10];
    }
}
