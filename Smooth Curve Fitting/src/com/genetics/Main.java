package com.genetics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {
        int numOfTests,numOfPoints,numOfCoef;
        Scanner scanner=new Scanner(System.in);
        numOfTests=scanner.nextInt();
        Point[] points;
        for(int l=0;l<numOfTests;l++){

            numOfPoints=scanner.nextInt();
            numOfCoef=scanner.nextInt();
            GeneticAlgorithm geneticAlgorithm=new GeneticAlgorithm(10000, numOfPoints, numOfCoef);
            points=new Point[numOfPoints];
            for(int i=0;i<numOfPoints;i++){
                double x,y;
                x=scanner.nextDouble();
                y=scanner.nextDouble();
                points[i]=new Point(x,y);
                geneticAlgorithm.addPoint(i, x, y);
            }

            long startTime = System.nanoTime();
            geneticAlgorithm.applyAlgorithm();
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(TimeUnit.NANOSECONDS.toSeconds(totalTime)+" second");

            System.out.println("Case: "+(l+1));
            geneticAlgorithm.printBestSolution();

        }

    }
}
