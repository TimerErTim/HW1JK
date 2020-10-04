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
        if (p <= 1)
            return false;

        for (int i = 2; i <= p / 2; i += 2)
            if ((p % i) == 0)
                return false;

        return true;
    }

    @Override
    public void printPrimes() {
        for (Integer i : primesInRange)
            System.out.println(i);
    }
}

