package lab1;

/**
 *
 * @author Lavric Adrian-Gabriel
 */


public class Lab1 {


    public static void main(String[] args) {

        Lab1 lab1 = new Lab1();
        lab1.compulsory();

        int a, b, k;
        if(args.length != 3) {
            System.out.println("Syntax: java Lab1 a b k.");
            return;
        }

        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            k = Integer.parseInt(args[2]);
        } catch(NumberFormatException e) {
            System.out.println("The values must be integers.");
            return;
        }

        if(k >= 10 || k < 0) {
            System.out.println("k must be a digit.");
            return;
        }

        if(a > b) {
            System.out.println("a >= b.");
        }

        lab1.homework(a, b, k);

        int n = 4;
        lab1.bonus(n);

    }

    public void compulsory() {

        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);

        int result = n * 3;
        result += Integer.parseInt("10101", 2);
        result += Integer.parseInt("FF", 16);
        result *= 6;

        int sumCif = 0;
        while(result > 0 || sumCif > 9) {

            if(result == 0) {

                result = sumCif;
                sumCif = 0;

            }

            sumCif += result % 10;
            result /= 10;

        }

        result = sumCif;

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }
    void homework(int a, int b, int k) {

        long startTime = System.currentTimeMillis();
        StringBuilder kReductibleNumbers = new StringBuilder();

        for(int i = a; i <= b; i++) {
            int currentNumber = i;
            while(currentNumber > 9) {
                int reducedNumber = 0;
                while(currentNumber > 0) {

                    reducedNumber += (currentNumber % 10) * (currentNumber % 10);
                    currentNumber /= 10;

                }
                currentNumber = reducedNumber;
            }
            if(currentNumber == k) {
                kReductibleNumbers.append(i);
                kReductibleNumbers.append(", ");
            }
        }

        System.out.println();
        if(!kReductibleNumbers.isEmpty()) {
            System.out.println("k-reductible numbers between " + a + " and " + b +  ": " + kReductibleNumbers);
        } else {
            System.out.println("There is no k-reductible number in [a, b].");
        }

        long finishTime = System.currentTimeMillis();
        System.out.println("Running time: " + (finishTime - startTime) + "  milliseconds.");

    }

    int numberOfCycles = 0;
    void printCycles(int n, int[][] adjacencyMatrix, boolean[] visited, int[] currentCycle, int currentNode, int start, int count) {

        visited[currentNode] = true;
        currentCycle[count - 1] = currentNode;

        if(adjacencyMatrix[currentNode][start] == 1 && count > 2) {
            for(int i = 0; i < count; i++) {
                System.out.print(currentCycle[i] + ", ");
            }
            System.out.println(currentCycle[0]);
            numberOfCycles++;

        } else {
            for(int i = 0; i < n; i++) {
                if(adjacencyMatrix[currentNode][i] == 1 && !visited[i]) {
                    printCycles(n, adjacencyMatrix, visited, currentCycle, i, start, count + 1);
                }
            }
        }

    }

    void bonus(int n) {

        int[][] adjacencyMatrix = new int[n][n];

        for(int i = 1; i < n; i++) {
            adjacencyMatrix[0][i] = 1;
            adjacencyMatrix[i][0] = 1;
        }
        adjacencyMatrix[1][n - 1] = 1;
        adjacencyMatrix[n - 1][1] = 1;

        for(int i = 1; i < n - 1; i++) {

            adjacencyMatrix[i][i + 1] = 1;
            adjacencyMatrix[i + 1][i] = 1;

        }

        System.out.println();
        System.out.println("Adjacency matrix of wheel graph W" + n + ":");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Cycles: ");
        boolean[] visited = new boolean[n];
        int[] currentCycle = new int[n];
        for(int i = 1; i < n; i++) {

            printCycles(n, adjacencyMatrix, visited, currentCycle, i, i, 1);
            visited = new boolean[n];

        }

        for(int i = 1; i < n; i++) {
            System.out.print(i + ", ");
        }
        System.out.println(1);
        numberOfCycles++;

        System.out.println(numberOfCycles);
        if(numberOfCycles == n * n - 3 * n + 3) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }



}
