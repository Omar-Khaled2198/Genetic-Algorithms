package com.genetics;

import java.util.ArrayList;
import java.util.Random;

public class Chromosome{
    
    private int [] genes;
    private int fitness;
    private ArrayList<Integer>taken;


    public Chromosome(int chromosomeLength){
        this.genes=new int[chromosomeLength];
        this.fitness=0;
        this.taken=new ArrayList<>();
    }

    public void generateGenes(){
        
        Random rand = new Random();
        for(int i=0;i<genes.length;i++){
            double value = rand.nextDouble();
            if(value<=0.7)
            {
                genes[i]=1;
                taken.add(i);
            }
            else
                genes[i]=0;
        }
    }

    public void calculateFitness(Item[] items,int knapsackSize){
        int totalWeigth=0,totalBenefit=0;
        for(int i=0;i<genes.length;i++){
            totalWeigth+=items[i].getWeight()*genes[i];
            totalBenefit+=items[i].getBenefit()*genes[i];
        }
        if(totalWeigth>knapsackSize){
            fitness=1;
        }
        else{
            fitness=totalBenefit;
        }
        
    }

    public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness){
		this.fitness = fitness;
    }

    public int[] getGenes(){
        return this.genes;
    }

    public void setGenes(int [] genes){
        this.genes=genes;
    }

    public ArrayList<Integer> getTaken(){
        return this.taken;
    }

    public void setTaken(ArrayList<Integer>taken){
        this.taken=taken;
    }

    
    

}