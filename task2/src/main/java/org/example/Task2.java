package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner circleScanner = new Scanner(new File(args[0]));
        Scanner dotsScanner = new Scanner(new File(args[1]));
        double circleX = circleScanner.nextDouble();
        double circleY = circleScanner.nextDouble();
        double radius = circleScanner.nextDouble();

        while (dotsScanner.hasNextDouble()) {
            double dotX = dotsScanner.nextDouble();
            double dotY = dotsScanner.nextDouble();
            if ((dotX - circleX) * (dotX - circleX) + (dotY - circleY) * (dotY - circleY) == radius * radius) {
                System.out.println(0);
            } else if ((dotX < circleX + radius)
                    && (dotX > circleX - radius)
                    && (dotY < circleY + radius)
                    && (dotY > circleY - radius)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}

