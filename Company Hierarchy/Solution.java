/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provatest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author marco
 * 
 * Versione senza strutturare i dati in un Albero, ma una doppia HashMap
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream(args[0]));
        int N = scan.nextInt();
        Map<String, List<String>> rootMap = new HashMap<>(N);
        Map<String, Boolean> rootVisited = new HashMap<>(N);
        List<String> subEmplLyst;
        String employeeM;
        String employeeN;

        //Leggo le righe e le metto in un'HashMap [Root --> <Lista sub>]
        //Creo anche un'HashMap VISITED = [Root --> Boolean]
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
                rootVisited.put(employeeM, Boolean.FALSE);
            }
        }

        //Stampo a video
        for (Map.Entry<String, List<String>> root : rootMap.entrySet()) {
            employeeM = root.getKey();
            if(!rootVisited.get(employeeM)){
                System.out.println(employeeM);
                subEmplLyst = root.getValue();
                for (String subEmpl : subEmplLyst) {
                    System.out.print(subEmpl + " ");
                    if (rootVisited.containsKey(subEmpl)) {
                        rootVisited.put(subEmpl, Boolean.TRUE);
                    }
                }
                System.out.print("\n");
                rootVisited.put(employeeM, Boolean.TRUE);
            }
        }
    }
}
