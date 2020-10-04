package com.HW1.primeSieve;

import java.util.ArrayList;

public class EratosthenesPrimeSieve implements PrimeSieve {
    private int limit;
    private ArrayList<Integer> primesInRange;

    // initializes variables and populates the list of prime numbers
    public EratosthenesPrimeSieve(int limit) {
        this.limit = limit;
        this.primesInRange = new ArrayList<>();

        for (int i = 2; i < limit; i++)
            if (isPrime(i))
                primesInRange.add(i);
    }

    @Override
    public boolean isPrime(int p) {
    }

    @Override
    public void printPrimes() {
    }
}
