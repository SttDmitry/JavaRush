package com.example.http.utils;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private static List<Long> cachedValues;

    public enum OperationType {
        RECURSIVE,
        CYCLIC
    }

    static {
        cachedValues = new ArrayList<>() {
        };
        cachedValues.add(0L);
        cachedValues.add(1L);
    }

    public Long getFibonacciByPosition(int n, OperationType operationType) {
        if (n > 0) {
            if (cachedValues.size() >= n) {
                System.out.println("Result from cache");
                return cachedValues.get(n - 1);
            }

            switch (operationType) {
                case CYCLIC -> {
                    return getFibonacciCyclic(n);
                }
                case RECURSIVE -> {
                    return getFibonacciRecursive(n);
                }
            }
        }
        return -1L;
    }

    private long getFibonacciCyclic(int n) {
        long temp1 = cachedValues.get(cachedValues.size()-2);
        long temp2 = cachedValues.get(cachedValues.size()-1);
        long result = -1L;
        for (int i = cachedValues.size(); i <= n; i++) {
            result = temp1 + temp2;
            cachedValues.add(result);
            temp1 = temp2;
            temp2 = result;
        }
        return result;
    }

    private long getFibonacciRecursive(int n) {
        long result;
        if (cachedValues.size() > n) {
            return cachedValues.get(n);
        } else if (cachedValues.size() == n) {
            result = cachedValues.get(n-1) + cachedValues.get(n-2);
            cachedValues.add(result);
            return result;
        }
        result = getFibonacciRecursive(n - 2) + getFibonacciRecursive(n - 3);
        cachedValues.add(result);
        return result;
    }

}
