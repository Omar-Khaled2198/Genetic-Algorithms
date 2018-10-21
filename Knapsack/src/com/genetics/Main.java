package com.genetics;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        int numOfTests,numOfItems,knapsackSize;
        Scanner scanner=new Scanner(System.in);
        numOfTests=scanner.nextInt();
        for(int x=0;x<numOfTests;x++){

            numOfItems=scanner.nextInt();
            knapsackSize=scanner.nextInt();
            GeneticAlgorithm geneticAlgorithm=new GeneticAlgorithm(15000, numOfItems, knapsackSize);
            for(int i=0;i<numOfItems;i++){
                int weight,benefit;
                weight=scanner.nextInt();
                benefit=scanner.nextInt();
                geneticAlgorithm.addItem(i, weight, benefit);
            }
            geneticAlgorithm.applyAlgorithm();
            System.out.println("Case: "+(x+1));
            geneticAlgorithm.printBestSolution();
        }

    }
}