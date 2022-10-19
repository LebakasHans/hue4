package net.htlgkr.ZweitesBeispiel;

import java.util.List;
import java.util.concurrent.Callable;

public class MyRunnable implements Callable<Integer> {
    int startingNumber;
    int endNumber;

    public MyRunnable(int startingNumber, int endNumber) {
        this.startingNumber = startingNumber-1;
        this.endNumber = endNumber;
    }

    @Override
    public Integer call(){
        return (((endNumber * endNumber)+ endNumber)/2) - (((startingNumber * startingNumber)+ startingNumber)/2);
    }
}
