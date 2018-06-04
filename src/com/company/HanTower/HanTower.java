package com.company.HanTower;

import java.util.Scanner;

public class HanTower {

    public void TOH(int n, String start, String aux, String end) {

        if (n == 1) {
            System.out.println(start + " -> " + end);
        } else {
            TOH(n - 1, start, end, aux);
            System.out.println(start + " -> " + end);
            TOH(n - 1, aux, start, end);
        }
    }

    public static void main(String[] args) {

        HanTower towersOfHanoi = new HanTower();

        System.out.print("Enter number of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        towersOfHanoi.TOH(discs, "A", "B", "C");
    }
}
