package net.htlgkr.ErstesBeispiel;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable{
    private List<Integer> numbers;
    private int divider;

    public MyRunnable(List<Integer> numbers, int divider) {
        this.numbers = numbers;
        this.divider = divider;
    }

    @Override
    public void run() {
        numbers.forEach(integer -> {
            if(integer % divider == 0) {
                System.out.println(integer);
            }
        });
    }
}
