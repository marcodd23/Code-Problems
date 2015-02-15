/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatest;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marco
 */
public class PrimeNumbers {

    static int getNumberOfPrimes(int N) {

        if (N <= 1) {
            return 0;
        }
        Integer[] arrayAux = new Integer[N];
        List<Integer> setaccio = new LinkedList<>();
        List<Integer> nums = new LinkedList<>();
        for (int i = 2; i < N; i++) {
            //setaccio.add(i + 2);
            arrayAux[i] = i;
        }
       
        for(int i = 2; i*i<N; i++){
            if(arrayAux[i] == null){
                continue;
            }
            int nextPrim = arrayAux[i];
            for (int j = i*i; j < N; j+=i) {
                arrayAux[j] = null; 
            }
        }

        int count = 0;
        for (int i = 0; i < arrayAux.length; i++) {
            if (arrayAux[i] != null) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("1000000000");
        System.out.println(getNumberOfPrimes(1000000));
    }
}
