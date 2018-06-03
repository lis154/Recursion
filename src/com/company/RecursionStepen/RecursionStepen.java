package com.company.RecursionStepen;

public class RecursionStepen {

    public static void main(String[] args) {
        System.out.println(stepen(5,3));
    }

    public static int stepen (int n, int step)
    {
        if (step > 1) {
            return n * stepen(n, step-1);
        }
        else if ( step == 1) return n;
        else if (step == 0)  return 1;
        else return 0;
    }
}
