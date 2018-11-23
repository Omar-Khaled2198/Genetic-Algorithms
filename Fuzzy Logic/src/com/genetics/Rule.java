package com.genetics;

import java.util.ArrayList;

public class Rule {

    public ArrayList<String>inputVariables;
    public ArrayList<String>inputTerms;
    public ArrayList<String>operations;
    public String outputVariable;
    public String outputTerm;


    public Rule(String rule){
        inputVariables=new ArrayList<>();
        inputTerms=new ArrayList<>();
        operations=new ArrayList<>();
        String[] split = rule.split("\\s+");
        boolean equal=false,then=false;
        for(int i=0;i<split.length-1;i++){
            if(split[i].equals("then"))
                then=true;
            if(split[i+1].equals("=")&&!then){
                inputVariables.add(split[i]);
                equal=true;
            }
            else if(!split[i].equals("=")&&equal&&!then){
                inputTerms.add(split[i]);
                equal=false;
            }
            else if(!split[i+1].equals("=")&&!equal&&!then){
                operations.add(split[i]);
            }
            else if(split[i+1].equals("=")&&then){
                outputVariable=split[i];
                equal=true;
            }
            else if(split[i].equals("=")&&equal&&then){
                outputTerm=split[i+1];
            }
        }
    }

}
