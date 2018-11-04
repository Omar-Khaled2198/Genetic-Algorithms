package com.genetics;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Random;

public class Chromosome {
    
    private double [] genes;
    private double fitness;

    public Chromosome(int length){

        this.genes=new double[length];
    }

    public Chromosome(double[] genes,double fitness){
        this.genes=new double[genes.length];
        this.genes=genes;
        this.fitness=fitness;
    }

    public void generateGenes(){

        Random rand = new Random();
        for(int i=0;i<genes.length;i++)
            genes[i]=-10 + rand.nextDouble() * (20);
    }

    public void calculateFitness(Point[] points){

        double totalY=0;
        for(int i=0;i<points.length;i++){
            double yCalc=0;
            for(int x=0;x<genes.length;x++){
                yCalc+=genes[x]*Math.pow(points[i].getX(),x);
            }
            totalY+=Math.pow(yCalc-points[i].getY(),2);
        }
        fitness=totalY/points.length;


    }

    public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness){
		this.fitness = fitness;
    }

    public double[] getGenes(){
        return this.genes;
    }

    public void setGenes(double [] genes){
        this.genes=genes;
    }


    
    

}