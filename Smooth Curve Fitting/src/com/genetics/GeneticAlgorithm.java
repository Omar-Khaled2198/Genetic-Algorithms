package com.genetics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GeneticAlgorithm {

    private Population population;
    private Point[] points;
    private int numOfCoef;
    private ArrayList<Integer>select;
    private ArrayList<Chromosome>selectedChromosomes;
    private int populationSize;
    private double minError;
    private int numOfPoints;
    private double[] included;
    private static final int MAX_GENERATION = 50;
    private static final double Mutation_PROBABILITY = .001;
    private static final double CROSSOVER_PROBABILITY = .7;
    private static final double B = 1;


    public GeneticAlgorithm(int populationSize, int numOfPoints, int numOfCoef){
        this.population=new Population(populationSize, numOfCoef+1);
        this.populationSize=populationSize;
        this.numOfPoints=numOfPoints;
        this.points=new Point[numOfPoints];
        this.included=new double[numOfCoef+1];
        this.numOfCoef=numOfCoef;
        selectedChromosomes=new ArrayList<>();
        select=new ArrayList<>();
        this.minError=Double.MAX_VALUE;
    }

    public double getMinError()
    {
        return this.minError;
    }

    public void addPoint(int index,double x,double y){
        points[index]=new Point(x,y);
    }

    public void calcualteFitness(){
        population.calculateFitness(points);
    }

    public void selection(){

        double tempTotal=0;
        ArrayList<Double>total=new ArrayList<>();
        for(int i=0;i<population.getChromosomes().size();i++){
            tempTotal+=population.getChromosomes().get(i).getFitness();
        }

        for(int i=0;i<population.getChromosomes().size();i++){
            total.add(tempTotal-population.getChromosomes().get(i).getFitness());
        }

        ArrayList<Double> rouletteWheel = new ArrayList<>();
        double totalFitness=0;
        rouletteWheel.add(totalFitness);
        for(int i=0;i<total.size();i++){
            totalFitness+=total.get(i);
            rouletteWheel.add(totalFitness);
        }
        Random random=new Random();

        double random1=random.nextDouble()*totalFitness,random2=random.nextDouble()*totalFitness;
        for(int i=0;i<rouletteWheel.size()-1;i++){
            Chromosome chromosome=population.getChromosomes().get(i);
            if(selectedChromosomes.size()==2)
                break;
            if(random1>=rouletteWheel.get(i)&&random1<rouletteWheel.get(i+1)){
                selectedChromosomes.add(new Chromosome(chromosome.getGenes(),chromosome.getFitness()));
                select.add(i);
            }
            if(random2>=rouletteWheel.get(i)&&random2<rouletteWheel.get(i+1)){
                selectedChromosomes.add(new Chromosome(chromosome.getGenes(),chromosome.getFitness()));
                select.add(i);
            }
        }

    }


    public void crossOver(){

        Random random=new Random();
        double rand=random.nextDouble();
        // System.out.println(rand);
        if(rand<=CROSSOVER_PROBABILITY){
            int begin=random.nextInt(numOfCoef);
            for(int i=begin;i<=numOfCoef;i++){
                double temp=selectedChromosomes.get(0).getGenes()[i];
                selectedChromosomes.get(0).getGenes()[i]=selectedChromosomes.get(1).getGenes()[i];
                selectedChromosomes.get(1).getGenes()[i]=temp;
            }

        }
    }

    public void mutation(int index){

        Random random=new Random();

        for(int i=0;i<selectedChromosomes.size();i++){
            for(int x=0;x<selectedChromosomes.get(i).getGenes().length;x++){

                double y;
                double gene=selectedChromosomes.get(i).getGenes()[x];
                double r=random.nextDouble(),r1=random.nextDouble();
                if(r<=Mutation_PROBABILITY){
                    if(r1<=0.5)
                    {
                        y=gene+10;
                        double delta_i=(y*(1-Math.pow(r1,Math.pow(1-(index/MAX_GENERATION),B))));
                        selectedChromosomes.get(i).getGenes()[x]=gene-delta_i;
                    }
                    else{
                        y=10-gene;
                        double delta_i=(y*(1-Math.pow(r1,Math.pow(1-(index/MAX_GENERATION),B))));
                        selectedChromosomes.get(i).getGenes()[x]=gene+delta_i;
                    }

                }



            }

        }

    }



    public void updateBestSolution(){
        for(int i=0;i<population.getChromosomes().size();i++){
            if(minError>population.getChromosomes().get(i).getFitness()){
                minError=population.getChromosomes().get(i).getFitness();
                included=population.getChromosomes().get(i).getGenes();
            }
        }

    }
    public void avg(){
        double avg=0;
        for(int i=0;i<population.getChromosomes().size();i++){
            avg+=population.getChromosomes().get(i).getFitness();
        }
        System.out.println(avg/populationSize);
    }
    public void applyAlgorithm(){

        for(int i=0;i<MAX_GENERATION;i++){
            calcualteFitness();
            selection();
            crossOver();
            mutation(i);
            for(int l=0;l<selectedChromosomes.size();l++){
                selectedChromosomes.get(l).calculateFitness(points);
                //System.out.println(x+": "+selectedChromosomes.get(x).getFitness()+" ||| "+population.getChromosomes().get(select.get(x)).getFitness());
                if(selectedChromosomes.get(l).getFitness()<population.getChromosomes().get(select.get(l)).getFitness()){
                    population.getChromosomes().set(select.get(l),new Chromosome(selectedChromosomes.get(l).getGenes(),selectedChromosomes.get(l).getFitness()));
                }

            select.clear();
            selectedChromosomes.clear();

        }
        }
        updateBestSolution();

    }


    public void printBestSolution(){
        System.out.println("Min: "+minError);
        for(int i=0;i<included.length;i++){
            System.out.print(included[i]+" ");
        }
    }


}