package provatest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class Solution2 {

    private static class Employee {

        private String name;
        private Employee leftChild;
        private Employee rightChild;
        private boolean visited = false;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public boolean isFull() {
            if (leftChild != null && rightChild != null) {
                return true;
            }
            return false;
        }

        public boolean hasChild() {
            if (leftChild != null || rightChild != null) {
                return true;
            }
            return false;
        }

        public boolean hasLeftChild() {
            if (leftChild != null) {
                return true;
            }
            return false;
        }

        public boolean hasRightChild() {
            if (rightChild != null) {
                return true;
            }
            return false;
        }

        public boolean addChild(Employee child) {
            if (!isFull()) {
                if (leftChild == null) {
                    leftChild = child;
                } else {
                    rightChild = child;
                }
                return true;
            } else {
                return false;
            }
        }

        public Employee getLeftChild() {
            return leftChild;
        }

        public Employee getRightChild() {
            return rightChild;
        }

        public void setVisited() {
            visited = true;
        }
    }

    public static Employee populateTree(String root, Map<String, List<String>> input) {
        if (!input.containsKey(root)) {
            return new Employee(root);
        }
        List<String> childs = input.get(root);
        Employee rootNode = new Employee(root);
        if (!childs.isEmpty()) {
            for (String child : childs) {
                rootNode.addChild(populateTree(child, input));
            }
        }

        return rootNode;
    }

    public static void BFSprintTreeLevel(Employee root) {

        if (!root.hasChild()) {
            System.out.println(root.getName());
        }
        
        Queue<Employee> currentLevel = new LinkedList<>();
        currentLevel.add(root);
        
        do {
            int size = currentLevel.size();
            for (int i = 0; i < size; i++) {
                Employee temp = currentLevel.poll();
                System.out.print(temp.getName() + " ");
                if (temp.hasLeftChild()) {
                    currentLevel.add(temp.getLeftChild());
                }
                if (temp.hasRightChild()) {
                    currentLevel.add(temp.getRightChild());
                }
            }
            System.out.print("\n");
        } while (!currentLevel.isEmpty());

    }

    public static int heightOfBinaryTree(Employee node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(heightOfBinaryTree(node.leftChild), heightOfBinaryTree(node.leftChild));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new FileInputStream(args[0]));
        int N = scan.nextInt();
        Map<String, List<String>> dictionary = new HashMap<>();
        String rootManager;

        //leggo l'imput
        rootManager = scan.next();
        dictionary.put(rootManager, new ArrayList<>());
        dictionary.get(rootManager).add(scan.next());
        while (scan.hasNext()) {
            String employeeM = scan.next();
            if (dictionary.containsKey(employeeM)) {
                dictionary.get(employeeM).add(scan.next());
                continue;
            }        
            dictionary.put(employeeM, new ArrayList<>());
            dictionary.get(employeeM).add(scan.next());
        }

        Employee employeeTree = populateTree(rootManager, dictionary);

        //int heightOfBinaryTree = heightOfBinaryTree(employeeTree);

        BFSprintTreeLevel(employeeTree);
    }
}
