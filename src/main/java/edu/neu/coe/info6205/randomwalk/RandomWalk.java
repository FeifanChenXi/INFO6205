/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.randomwalk;

import java.util.Random;

public class RandomWalk {

    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        x+=dx;
        y+=dy;
        // TO BE IMPLEMENTED
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        for(int z=0;z<=m;z++){
            randomMove();
        }

    }

    /**
     * Private method to generate a random move according to the rules of the situation.
     * That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
        int step = random.nextBoolean() ? 1 : -1;
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        double distance=Math.sqrt(x*x+y*y);
        return distance;
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++) {
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance /n;
    }


    // steps is the number of steps
    //mean distance is the average of total distance for every step experiment
    //when the number of the experiments is huge enough, we can assume mean distance is equal to sqrt.steps
    //error rate= |mean distance*mean distance-steps|/steps

    public static void main(String[] args) {
        double [] result= new double[101];
        for(int steps=0;steps<=100;steps++){
            result[steps]= randomWalkMulti(steps,10000);

        }
        for(int steps=0;steps<=100;steps++) {
            int stepps=steps+1;
            double errorRate=Math.abs(stepps-result[steps]*result[steps])/stepps;
            System.out.println("steps is  "+stepps +"    the square of  the mean distance is "+  result[steps]*result[steps] + "   error rate is   " +  errorRate);


        }


    }

}
