package com.genetics;

import java.util.ArrayList;

public class Population{
    
    private ArrayList<Chromosome>chromosomes;

    public Population(){
        chromosomes=new ArrayList<>();
    }
    
    public Population(int populationSize,int chromosomeLength){

        chromosomes=new ArrayList<>();
        for(int i=0;i<populationSize;i++){
            chromosomes.add(new Chromosome(chromosomeLength));
            chromosomes.get(i).generateGenes();
        }
    }

    public ArrayList<Chromosome> getChromosomes()
	{
		return this.chromosomes;
	}

	public void setChromosomes(ArrayList<Chromosome>chromosomes)
	{
		this.chromosomes = chromosomes;
	}

    public void calculateFitness(Item[] items,int knapsackSize){
        for(int i=0;i<chromosomes.size();i++){
            chromosomes.get(i).calculateFitness(items, knapsackSize);
        }
    }

}