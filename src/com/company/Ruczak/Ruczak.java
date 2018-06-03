package com.company.Ruczak;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ruczak {

    static int max(int a, int b) { return (a > b)? a : b; } // максимум из 2

    // Returns the maximum value that can be put in a knapsack of capacity W
    // n - длинна массива
    // wt - вес предмета
    // val - ценность предмета
    // W - вместимост сумки
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;


        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1); // если вес предмета больше веса рюкзаке, не помещаем
        else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                knapSack(W, wt, val, n-1)
        );
    }

    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120, 250};
        int wt[] = new int[]{10, 20, 30, 40};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }


}
