package com.HW1.primeSieve;

import java.util.ArrayList;
import java.util.Objects;

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

    public void printResult() {
        // collection of numbers and their addends
        ArrayList<Integer[]> results = new ArrayList<>();

        // filling the list
        for (int num = 4; num <= limit; num += 2) {
            for (Integer i : primesInRange) {
                if (i >= (num - 1))
                    break;

                int dif = num - i;

                if (isPrime(dif))
                    //System.out.println(String.format("%s Summe: %s + %s", num, i, dif));
                    results.add(new Integer[]{num, i, dif});
            }
        }

        // filtering out duplicates
        for (int i = 0; i < results.size() - 1; i++) {
            for (int j = i + 1; j < results.size(); j++) {
                Integer[] arr1 = results.get(i);
                Integer[] arr2 = results.get(j);

                if (Objects.equals(arr1[0], arr2[0])) {
                    if (Objects.equals(arr1[1], arr2[2]))
                        results.remove(j);
                }
            }
        }

        for (Integer[] arr : results)
            System.out.printf("%s Summe: %s + %s%n", arr[0], arr[1], arr[2]);
    }
}
