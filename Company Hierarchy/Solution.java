/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author marco
 *
 * Versione senza strutturare i dati in un Albero, ma con HashMap , e una Queue per il buffer di scrittura
 */
public class Solution {

    public static void printHierarchy(String rootManager, Map<String, List<String>> rootMap) {

        Queue<String> toPrint = new LinkedList<>();
        toPrint.add(rootManager);
        while (!toPrint.isEmpty()) {
            int size = toPrint.size();
            for (int i = 0; i < size; i++) {
                String empName = toPrint.poll();
                if (rootMap.containsKey(empName)) {
                    List<String> nextLevel = rootMap.get(empName);
                    for (String next : nextLevel) {
                        toPrint.add(next);
                    }
                    //rootVisited.put(empName, Boolean.TRUE);
                }
                System.out.print(empName + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream(args[0]));
        int N = scan.nextInt();
        Map<String, List<String>> rootMap = new LinkedHashMap<>(N);
        //Map<String, Boolean> rootVisited = new LinkedHashMap<>(N);
        List<String> subEmplLyst;
        String employeeM;
        String employeeN;
        String rootManager;

        //Leggo le righe e le metto in un'HashMap [Root --> <Lista sub>]
        //Creo anche un'HashMap VISITED = [Root --> Boolean]
        rootManager = scan.next();
        employeeN = scan.next();
        subEmplLyst = new ArrayList<>();
        subEmplLyst.add(employeeN);
        rootMap.put(rootManager, subEmplLyst);
        //rootVisited.put(rootManager, Boolean.FALSE);
        while (scan.hasNext()) {
            employeeM = scan.next();
            if (rootMap.containsKey(employeeM)) {
                employeeN = scan.next();
                rootMap.get(employeeM).add(employeeN);
            } else {
                employeeN = scan.next();
                subEmplLyst = new ArrayList<>();
                subEmplLyst.add(employeeN);
                rootMap.put(employeeM, subEmplLyst);
                //rootVisited.put(employeeM, Boolean.FALSE);
            }
        }

        //printHierarchy(rootManager, rootMap, rootVisited);
        printHierarchy(rootManager, rootMap);
        
    }

}

