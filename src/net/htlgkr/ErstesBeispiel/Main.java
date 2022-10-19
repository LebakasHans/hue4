package net.htlgkr.ErstesBeispiel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        CsvIO csvIO = new CsvIO();
        ArrayList<Integer> numbers = csvIO.readCsv();
        System.out.println("Chunks: ");
        int chunks = sc.nextInt();
        System.out.println("Divider: ");
        int divider = sc.nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(chunks);
        List<Integer> chunk;
        int lastIndex = 0;
        int magicNumber = numbers.size()/chunks;

        for (int i = 0; i < chunks;) {
            if(i == chunks-1){
            chunk = numbers.subList(lastIndex, numbers.size()-1);
            }
            else{
            chunk = numbers.subList(lastIndex, magicNumber * (i+1));
            }
            i++;
            lastIndex = (magicNumber * (i))+1;
            Runnable worker = new MyRunnable(chunk, divider);
            executor.execute(worker);
        }

    }
}
