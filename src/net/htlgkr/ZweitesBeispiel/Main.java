package net.htlgkr.ZweitesBeispiel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Future<Integer>> futures = new ArrayList<>();
        System.out.println("n>");
        int number = sc.nextInt();
        int firstNumber = 1;
        int lastNumber;
        if (number <= 100){
            lastNumber = number;
        }else {
            lastNumber = 100;
        }
        for (int i = 0; i < (number/100)+1; ++i) {

            ExecutorService executor = Executors.newCachedThreadPool();
            futures.add(executor.submit(new MyRunnable(firstNumber, lastNumber)));

            firstNumber = lastNumber + 1;
            if (lastNumber + 100 > number){
                lastNumber = number;
            }else {
                lastNumber += 100;
            }
        }

        int sum = 0;
        for (Future<Integer> future : futures) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum: " + sum);
    }
}
