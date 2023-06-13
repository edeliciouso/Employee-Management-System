import EMS.ArrayListEMS;
import EMS.HashMapEMS;
import EMS.QueueEMS;
import EMS.TreeMapEMS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class BenchmarkTest {

    // Initializing
    static int index = 0; // counter
    static String[] empId = new String[50];
    static String[] empName = new String[50];
    static String[] empPhone = new String[50];
    static String[] empAddress = new String[50];
    static String[] empDepartment = new String[50];
    static String[] empPosition = new String[50];
    static String[] empGender = new String[50];
    static String[] empEmail = new String[50];

    // Display Method
    public static void display() {
        System.out.println("\n=======================================");
        System.out.println("  Employee Central Benchmarking System");
        System.out.println("=======================================");
        System.out.println("            MENU OPTIONS");
        System.out.println("---------------------------------------");
        System.out.println("1. Benchmark Add Employee");
        System.out.println("2. Benchmark Remove Employee");
        System.out.println("3. Benchmark Edit Employee Data");
        System.out.println("4. Benchmark Search Employee by ID");
        System.out.println("5. Exit Program");
        System.out.println("---------------------------------------");
        System.out.print("Enter the corresponding command: ");
    }

    // Method to Read TxtFile
    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/employees.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String phone = data[2];
                String address = data[3];
                String department = data[4];
                String position = data[5];
                String gender = data[6];
                String email = data[7];

                empId[index] = id;
                empName[index] = name;
                empPhone[index] = phone;
                empAddress[index] = address;
                empDepartment[index] = department;
                empPosition[index] = position;
                empGender[index] = gender;
                empEmail[index] = email;
                index++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to Measure the Time Taken
    static void measureTime(long startTime, long endTime) {
        double timeUsed = (endTime - startTime) / 1_000_000.0;
        System.out.println(timeUsed + " milisecond(s)");
    }

    // To run the program
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int n;
        int limit = Math.min(50, index); // Set the limit to the minimum of 50 and index
        long startTree, startArray, startQueue, startHash, endTree, endArray, endQueue, endHash;

        readFile(); // call the method to read txt file

        // Add Employees Data to ArrayListEMS
        ArrayListEMS arrayList = new ArrayListEMS();
        for (int i = 0; i < limit; i++) {
            arrayList.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
        }

        // Add Employees Data to HashMapEMS
        HashMapEMS hashMap = new HashMapEMS();
        for (int i = 0; i < limit; i++) {
            hashMap.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
        }

        // Add Employees Data to TreeMapEMS
        TreeMapEMS treeMap = new TreeMapEMS();
        for (int i = 0; i < limit; i++) {
            treeMap.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
        }

        // Add Employees Data to QueueEMS
        QueueEMS queue = new QueueEMS();
        for (int i = 0; i < limit; i++) {
            queue.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
        }

        boolean quit = false;
        while (quit == false) { // as long as the user hasn't chosen to quit, the program will keep on running
        display();
        String command = input.nextLine();

            switch (command) {
                case "1": // Benchmark Add Employee
                    Scanner scanAdd = new Scanner(System.in);
                    System.out.println("How many employee's data do you want to add? ");
                    n = scanAdd.nextInt();
                    System.out.println("\nHere's the time taken for each data stucture to add " + n + " employee's data");

                    // ArrayList
                    System.out.print("1. ArrayList  : ");
                    startArray = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        arrayList.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
                    }
                    endArray = System.nanoTime();
                    measureTime(startArray, endArray);

                    // Queue
                    System.out.print("2. Queue      : ");
                    startQueue = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        queue.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
                    }
                    endQueue = System.nanoTime();
                    measureTime(startQueue, endQueue);

                    // HashMap
                    System.out.print("3. HashMap    : ");
                    startHash = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        hashMap.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
                    }
                    endHash = System.nanoTime();
                    measureTime(startHash, endHash);

                    // TreeMap
                    System.out.print("4. TreeMap    : ");
                    startTree = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        treeMap.addEmp(empId[i], empName[i], empPhone[i], empAddress[i], empDepartment[i], empPosition[i], empGender[i], empEmail[i]);
                    }
                    endTree = System.nanoTime();
                    measureTime(startTree, endTree);
                    break;

                case "2": // Benchmark Remove Employee
                    Scanner scanRem = new Scanner(System.in);
                    System.out.println("How many employee's data do you want to remove? ");
                    n = scanRem.nextInt();
                    System.out.println("\nHere's the time taken for each data stucture to remove " + n + " employee's data");

                    // ArrayList
                    System.out.print("1. ArrayList  : ");
                    startArray = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        arrayList.removeEmp(empId[i]);
                    }
                    endArray = System.nanoTime();
                    measureTime(startArray, endArray);

                    // Queue
                    System.out.print("2. Queue      : ");
                    startQueue = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        queue.removeEmp(empId[i]);
                    }
                    endQueue = System.nanoTime();
                    measureTime(startQueue, endQueue);

                    // HashMap
                    System.out.print("3. HashMap    : ");
                    startHash = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        hashMap.removeEmp(empId[i]);
                    }
                    endHash = System.nanoTime();
                    measureTime(startHash, endHash);

                    // TreeMap
                    System.out.print("4. TreeMap    : ");
                    startTree = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index); i++) {
                        treeMap.removeEmp(empId[i]);
                    }
                    endTree = System.nanoTime();
                    measureTime(startTree, endTree);
                    break;

                case "3": // Benchmark Edit Employee
                    Scanner scanEd = new Scanner(System.in);
                    System.out.println("How many employee's data do you want to edit? ");
                    n = scanEd.nextInt();
                    System.out.println("\nHere's the time taken for each data stucture to edit " + n + " employee's data");

                    // ArrayList
                    System.out.print("1. ArrayList  : ");
                    startArray = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index) && (i + 2) < empId.length; i++) {
                        arrayList.editEmp(empId[i], empName[i + 2], empPhone[i + 2], empAddress[i + 2], empDepartment[i + 2], empPosition[i + 2], empGender[i + 2], empEmail[i + 2]);
                    }
                    endArray = System.nanoTime();
                    measureTime(startArray, endArray);

                    // Queue
                    System.out.print("2. Queue      : ");
                    startQueue = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index) && (i + 2) < empId.length; i++) {
                        queue.editEmp(empId[i], empName[i + 2], empPhone[i + 2], empAddress[i + 2], empDepartment[i + 2], empPosition[i + 2], empGender[i + 2], empEmail[i + 2]);
                    }
                    endQueue = System.nanoTime();
                    measureTime(startQueue, endQueue);

                    // HashMap
                    System.out.print("3. HashMap    : ");
                    startHash = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index) && (i + 2) < empId.length; i++) {
                        hashMap.editEmp(empId[i], empName[i + 2], empPhone[i + 2], empAddress[i + 2], empDepartment[i + 2], empPosition[i + 2], empGender[i + 2], empEmail[i + 2]);
                    }
                    endHash = System.nanoTime();
                    measureTime(startHash, endHash);

                    // TreeMap
                    System.out.print("4. TreeMap    : ");
                    startTree = System.nanoTime();
                    for (int i = 0; i < Math.min(n, index) && (i + 2) < empId.length; i++) {
                        treeMap.editEmp(empId[i], empName[i + 2], empPhone[i + 2], empAddress[i + 2], empDepartment[i + 2], empPosition[i + 2], empGender[i + 2], empEmail[i + 2]);
                    }
                    endTree = System.nanoTime();
                    measureTime(startTree, endTree);

                    // Notes
                    System.out.println("\nPS: We change the data other than ID to those of 2 index after");
                    break;

                case "4": // Benchmark Search Employee
                    int r = random.nextInt(50);
                    System.out.println("\nHere's the time taken for searching employee index " + r + "'s data");

                    //Array List
                    System.out.print("1. ArrayList  : ");
                    startArray = System.nanoTime();
                    arrayList.searchEmpBench(empId[r]);
                    endArray = System.nanoTime();
                    measureTime(startArray, endArray);

                    //Queue
                    System.out.print("2. Queue      : ");
                    startQueue = System.nanoTime();
                    queue.searchEmpBench(empId[r]);
                    endQueue = System.nanoTime();
                    measureTime(startQueue, endQueue);

                    //Hashmap
                    System.out.print("3. HashMap    : ");
                    startHash = System.nanoTime();
                    hashMap.searchEmpBench(empId[r]);
                    endHash = System.nanoTime();
                    measureTime(startHash, endHash);

                    //Tree Map
                    System.out.print("4. TreeMap    : ");
                    startTree = System.nanoTime();
                    treeMap.searchEmpBench(empId[r]);
                    endTree = System.nanoTime();
                    measureTime(startTree, endTree);
                    break;

                case "5": // Exit Program
                    System.out.println("Thank you for using Employee Central Benchmarking System. Hope to see you again☺️");
                    quit = true;
            }
        }
    }
}
