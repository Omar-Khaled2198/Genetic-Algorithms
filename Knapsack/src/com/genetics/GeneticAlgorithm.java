package com.genetics;

import java.util.ArrayList;
import java.util.Random;

public class GeneticAlgorithm{

    private Population population;
    private Item[] items;
    private int knapsackSize;
    private int numOfItems;
    private int maxBenefit;
    private int populationSize;
    private ArrayList<Integer>included;
    private static final int MAX_GENERATION = 50;
    private static final double CROSSOVER_PROBABILITY = .7;
    private static final double MUTATION_PROBABILITY = .01;


    public GeneticAlgorithm(int populationSize,int numOfItems,int knapsackSize){
        this.population=new Population(populationSize, numOfItems);
        this.populationSize=populationSize;
        this.knapsackSize=knapsackSize;
        this.items=new Item[numOfItems];
        this.included=new ArrayList<>();
        this.numOfItems=numOfItems;
        this.maxBenefit=0;
    }

    public int getMaxbenefit()
    {
        return this.maxBenefit;
    }

    public void setMaxbenefit(int maxBenefit)
    {
        this.maxBenefit = maxBenefit;
    }

    public void addItem(int index,int weight,int benefit){
        items[index]=new Item(weight,benefit);
    }

    public void calcualteFitness(){
        population.calculateFitness(items, knapsackSize);
    }

    public ArrayList<Integer> selection(){

        ArrayList<Integer>selected=new ArrayList<>();
        ArrayList<Integer> rouletteWheel = new ArrayList<>();
        rouletteWheel.add(0);
        int totalFitness=0;
        for(int i=0;i<population.getChromosomes().size();i++){
            totalFitness+=population.getChromosomes().get(i).getFitness();
            rouletteWheel.add(totalFitness);
        }
        Random random=new Random();

        int random1=random.nextInt(totalFitness),random2=random.nextInt(totalFitness);
        for(int i=0;i<rouletteWheel.size()-1;i++){
            if(selected.size()==2)
                break;
            if(random1>=rouletteWheel.get(i)&&random1<rouletteWheel.get(i+1)){
                selected.add(i);
            }
            if(random2>=rouletteWheel.get(i)&&random2<rouletteWheel.get(i+1)){
                selected.add(i);
            }
        }
        return selected;

    }


    public ArrayList<Integer> crossOver(ArrayList<Integer>selected){

        Random random=new Random();
        double rand=random.nextDouble();
        // System.out.println(rand);
        if(rand<=CROSSOVER_PROBABILITY){
            int begin=random.nextInt(numOfItems-1);
            for(int i=begin;i<numOfItems;i++){
                int temp=population.getChromosomes().get(selected.get(0)).getGenes()[i];
                population.getChromosomes().get(selected.get(0)).getGenes()[i]=population.getChromosomes().get(selected.get(1)).getGenes()[i];
                population.getChromosomes().get(selected.get(1)).getGenes()[i]=temp;
            }

        }

        return selected;
    }

    public void mutation(ArrayList<Integer>crossed){
        Random random=new Random();
        for(int i=0;i<crossed.size();i++){
            for(int x=0;x<population.getChromosomes().get(crossed.get(i)).getGenes().length;x++){
                double r=random.nextDouble();
                if(r<=MUTATION_PROBABILITY){
                    if(population.getChromosomes().get(crossed.get(i)).getGenes()[x]==1)
                        population.getChromosomes().get(crossed.get(i)).getGenes()[x]=0;
                    else
                        population.getChromosomes().get(crossed.get(i)).getGenes()[x]=1;
                }
            }
        }
    }



    public void updateBestSolution(){
        for(int i=0;i<population.getChromosomes().size();i++){
            if(maxBenefit<population.getChromosomes().get(i).getFitness()){
                maxBenefit=population.getChromosomes().get(i).getFitness();
                included=population.getChromosomes().get(i).getTaken();
            }
        }

    }

    public void applyAlgorithm(){

        for(int i=0;i<MAX_GENERATION;i++){
            calcualteFitness();
            updateBestSolution();
            ArrayList<Integer>selected=selection();
            ArrayList<Integer>crossed=crossOver(selected);
            mutation(crossed);


        }

        updateBestSolution();
    }


    public void printBestSolution(){
         System.out.println("MaxBenefit: "+maxBenefit);
         System.out.println("Number Of Items: "+included.size());
         for(int i=0;i<included.size();i++){
             System.out.println(items[included.get(i)].getWeight()+" "+items[included.get(i)].getBenefit());
         }
    }


}