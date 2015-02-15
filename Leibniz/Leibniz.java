/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class Leibniz {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(new FileInputStream(args[0]));
        int T = scan.nextInt();
        int N;
        double result;
        //DecimalFormat df = new DecimalFormat("#.###############");
        DecimalFormat df = new DecimalFormat("0.000000000000000");
        while (scan.hasNext()) {
            N = scan.nextInt();
            result = 0;
            for (int i = 0; i < N; i++) {
                result += (Math.pow(-1, i)) / ((2 * i) + 1);
            }
            System.out.println(df.format(result));
        }
    }
}
