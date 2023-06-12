package EMS;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEMS {
    private static HashMap<String, Employees> employeesHashMap = new HashMap<>();
    public static boolean c;

    private static class Employees {
        private String id;
        private String name;
        private String phone;
        private String address;
        private String department;
        private String position;
        private String gender;
        private String email;

        // constructors
        public Employees(String id, String name, String phone, String address, String department, String position, String gender, String email) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.address = address;
            this.department = department;
            this.position = position;
            this.gender = gender;
            this.email = email;
        }

        // setters and getters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    // display method
    public static void display() {
        System.out.println("\n=======================================");
        System.out.println("  Employee Central Management System");
        System.out.println("=======================================");
        System.out.println("            MENU OPTIONS");
        System.out.println("---------------------------------------");
        System.out.println("(1) Add employee");
        System.out.println("(2) Remove employee");
        System.out.println("(3) Edit employee data");
        System.out.println("(4) View employee list");
        System.out.println("(5) Search employee by id");
        System.out.println("(6) Exit system");
        System.out.println("---------------------------------------");
        System.out.print("Enter the corresponding number for your command: ");
    }

    // add employee
    public static void addEmp(String id, String name, String phone, String address, String department, String position, String gender, String email){
        Employees newEmp = new Employees(id, name, phone, address, department, position, gender, email);
        employeesHashMap.put(id, newEmp);
    }

    // remove employee
    public static void removeEmp(String id){
        if(employeesHashMap.containsKey(id)){ // if the hashmap has the id key
            employeesHashMap.remove(id);
            c = true;
        }
        else{
            c = false;
        }
    }

    // edit employee
    public static void editEmp(String id, String newName, String newPhone, String newAddress, String newDepartment, String newPosition, String newGender, String newEmail){
        if(employeesHashMap.containsKey(id)){
            Employees nowEmp = employeesHashMap.get(id);
            nowEmp.setName(newName);
            nowEmp.setPhone(newPhone);
            nowEmp.setAddress(newAddress);
            nowEmp.setDepartment(newDepartment);
            nowEmp.setPosition(newPosition);
            nowEmp.setGender(newGender);
            nowEmp.setEmail(newEmail);
        }
    }

    // view employee
    public static void viewEmp(){
        if(employeesHashMap.isEmpty()){ // if hashmap empty
            System.out.println("\nThere aren't any employees yet!");
        } else{
            int n = 1; // to put numbers
            System.out.println("\n********************************");
            System.out.println("        Employee Details");
            System.out.println("********************************");
            for (Employees employee : employeesHashMap.values()) { // just get the values from the hashmap
                System.out.println(n + ".  Id: " + employee.getId());
                System.out.println("\tName: " + employee.getName());
                System.out.println("\tPhone: " + employee.getPhone());
                System.out.println("\tAddress: " + employee.getAddress());
                System.out.println("\tDepartment: " + employee.getDepartment());
                System.out.println("\tPosition: " + employee.getPosition());
                System.out.println("\tGender: " + employee.getGender());
                System.out.println("\tEmail: " + employee.getEmail());
                System.out.println();
                n++;
            }
        }
    }

    // search employee based on id
    public static void searchEmp(String id){
        Employees employee = employeesHashMap.get(id);
        if(employeesHashMap.containsKey(id)){ // if hashmap has the id, print out the contents of the employee class
            System.out.println("\n-Employee Details-");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Phone: " + employee.getPhone());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Department: " + employee.getDepartment());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Gender: " + employee.getGender());
            System.out.println("Email: " + employee.getEmail());
        } else{
            System.out.println("No employee with that id exist!");
        }
    }

    // Search Method for Benchmarking
    public static void searchEmpBench(String id){
        Employees employee = employeesHashMap.get(id);
        if(employeesHashMap.containsKey(id)){} // if hashmap has the id, print out the contents of the employee class
        else{}
    }

    // to run the program
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String command;
        boolean quit = false;

        while(quit == false) {
            display();
            command = input.nextLine();

            switch (command) {
                case "1" -> {
                    Scanner read = new Scanner(System.in);
                    System.out.print("\nId: ");
                    String id = read.nextLine();
                    System.out.print("Name: ");
                    String name = read.nextLine();
                    System.out.print("Phone: ");
                    String phone = read.nextLine();
                    System.out.print("Address: ");
                    String address = read.nextLine();
                    System.out.print("Department: ");
                    String department = read.nextLine();
                    System.out.print("Position: ");
                    String position = read.nextLine();
                    System.out.print("Gender: ");
                    String gender = read.nextLine();
                    System.out.print("Email: ");
                    String email = read.nextLine();
                    addEmp(id, name, phone, address, department, position, gender, email);
                    System.out.println("\nEmployee has been added!");
                }
                case "2" -> {
                    if (employeesHashMap.isEmpty()) {
                        System.out.println("\nNo employees at the moment!");
                    } else {
                        Scanner remove = new Scanner(System.in);
                        System.out.print("\nEmployee id: ");
                        String employeeToRemove = remove.nextLine();
                        removeEmp(employeeToRemove);
                        if (c) {
                            System.out.println("Employee has been removed!");
                        }
                        else {
                            System.out.println("Employee with that Id does not exist");
                        }
                    }
                }
                case "3" -> {
                    Scanner edit = new Scanner(System.in);
                    // if employee list is still empty
                    if (employeesHashMap.isEmpty()) {
                        System.out.println("\nNo Employees at the moment!");
                    }
                    else { // if employee list is not empty
                        System.out.print("\nEmployee Id: ");
                        String employeeToEdit = edit.nextLine();

                        // To check if the employee id exist or not
                        if(!employeesHashMap.containsKey(employeeToEdit)){
                            System.out.println("Employee with that id does not exist");
                        }
                        else {
                            System.out.println("\nEnter new employee information: ");
                            System.out.print("Name: ");
                            String newName = input.nextLine();
                            System.out.print("Phone: ");
                            String newPhone = input.nextLine();
                            System.out.print("Address: ");
                            String newAddress = input.nextLine();
                            System.out.print("Department: ");
                            String newDepartment = input.nextLine();
                            System.out.print("Position: ");
                            String newPosition = input.nextLine();
                            System.out.print("Gender: ");
                            String newGender = input.nextLine();
                            System.out.print("Email: ");
                            String newEmail = input.nextLine();
                            editEmp(employeeToEdit, newName, newPhone, newAddress, newDepartment, newPosition, newGender, newEmail);
                            System.out.println("Employee data has been updated!");
                        }
                    }
                }
                case "4" -> viewEmp();
                case "5" -> {
                    if (employeesHashMap.isEmpty()) {
                        System.out.println("\nNo employees at the moment!");
                    } else {
                        Scanner search = new Scanner(System.in);
                        System.out.print("\nEmployee id: ");
                        String empID = search.nextLine();
                        searchEmp(empID);
                    }
                }
                case "6" -> {
                    System.out.println("\nThank you for using Employee Central. Hope to see you again ☺️");
                    quit = true;
                }
            }
        }
    }
}
