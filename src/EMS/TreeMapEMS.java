package EMS;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapEMS {
    private static TreeMap<String, Employees> employeesMap = new TreeMap<>();
    public static boolean c;
    public static class Employees {
        private String id;
        private String name;
        private String phone;
        private String address;
        private String department;
        private String position;
        private String gender;
        private String email;

        // Constructor
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

        // Getters
        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public String getPhone() {
            return phone;
        }
        public String getAddress() {
            return address;
        }
        public String getDepartment() {
            return department;
        }
        public String getPosition() {
            return position;
        }
        public String getGender() {
            return gender;
        }
        public String getEmail() {
            return email;
        }

        // Setters
        public void setId(String id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public void setPosition(String position) {
            this.position = position;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    }

    // Display Method
    public static void display() {
        System.out.println("\n=======================================");
        System.out.println("  Employee Central Management System");
        System.out.println("=======================================");
        System.out.println("            MENU OPTIONS");
        System.out.println("---------------------------------------");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Edit Employee Data");
        System.out.println("4. View Employee List");
        System.out.println("5. Search Employee by ID");
        System.out.println("6. Exit System");
        System.out.println("---------------------------------------");
        System.out.print("Enter the corresponding number for your command: ");
    }

    // Add Employees Method
    public static void addEmp(String id, String name, String phone, String address, String department, String position, String gender, String email) {
        Employees newEmp = new Employees(id, name, phone, address, department, position, gender, email);
        employeesMap.put(id, newEmp);
    }

    // Remove Employees Method
    public static void removeEmp(String id) {
        // iterate over the TreeMap entries
        for (Map.Entry<String, Employees> entry : employeesMap.entrySet()) {
            String empId = entry.getKey(); // get id from the entry key
            Employees employee = entry.getValue(); // get the other data from the entry value

            if (empId.equals(id)) { // if employee id exist
                employeesMap.remove(empId);
                c = true;
                return;
            }
        }
        // if employee not found
        c = false;
    }

    // Edit Employees Method
    public static void editEmp(String id, String newName, String newPhone, String newAddress, String newDepartment, String newPosition, String newGender, String newEmail) {
        // iterate over the TreeMap entries
        for (Map.Entry<String, Employees> entry : employeesMap.entrySet()) {
            String empId = entry.getKey();
            Employees employee = entry.getValue();

            if (empId.equals(id)) { // if employee id exist
                employee.setName(newName);
                employee.setPhone(newPhone);
                employee.setAddress(newAddress);
                employee.setDepartment(newDepartment);
                employee.setPosition(newPosition);
                employee.setGender(newGender);
                employee.setEmail(newEmail);
                return;
            }
        }
    }

    // View Employees Method
    public static void viewEmp() {
        // if employee list is still empty
        if (employeesMap.isEmpty()) {
            System.out.println("\nNo employee at the moment!");
        }
        else { // if employee list is not empty
            int n = 1;
            System.out.println("\n********************************");
            System.out.println("        Employee Details");
            System.out.println("********************************");

            for (Map.Entry<String, Employees> entry : employeesMap.entrySet()) {
                String empId = entry.getKey();
                Employees employee = entry.getValue();

                System.out.println(n + ". Id: " + employee.getId());
                System.out.println("   Name: " + employee.getName());
                System.out.println("   Phone: " + employee.getPhone());
                System.out.println("   Address: " + employee.getAddress());
                System.out.println("   Department: " + employee.getDepartment());
                System.out.println("   Position: " + employee.getPosition());
                System.out.println("   Gender: " + employee.getGender());
                System.out.println("   Email: " + employee.getEmail());
                System.out.println();
                n++;
            }
        }
    }

    // Search Employees Method
    public static void searchEmp(String id) {
        for (Map.Entry<String, Employees> entry : employeesMap.entrySet()) {
            String empId = entry.getKey();
            Employees employee = entry.getValue();

            if (employee.getId().equals(id)) { // if employee id exist
                System.out.println("\n********************************");
                System.out.println("        Employee Details");
                System.out.println("********************************");
                System.out.println("\tID: " + employee.getId());
                System.out.println("\tName: " + employee.getName());
                System.out.println("\tPhone: " + employee.getPhone());
                System.out.println("\tAddress: " + employee.getAddress());
                System.out.println("\tDepartment: " + employee.getDepartment());
                System.out.println("\tPosition: " + employee.getPosition());
                System.out.println("\tGender: " + employee.getGender());
                System.out.println("\tEmail: " + employee.getEmail());
                return;
            }
        }
        // if employee not found
        System.out.println("Employee with that Id does not exist!");
    }

    // Search Method for Benchmarking
    public static void searchEmpBench(String id) {
        for (Map.Entry<String, Employees> entry : employeesMap.entrySet()) {
            String empId = entry.getKey();
            Employees employee = entry.getValue();

            if (employee.getId().equals(id)) { // if employee id exist
                return;
            }
        }
    }

    // To run the program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command;
        boolean quit = false;

        while (quit == false) { // as long as the user hasn't chosen to quit, the program will keep on running
            display();
            command = input.nextLine();
            switch (command) {
                case "1": // add employee
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
                    break;

                case "2": // remove employee
                    // if employee list is still empty
                    if (employeesMap.isEmpty()) {
                        System.out.println("\nNo employees at the moment!");
                    }
                    else { // if employee list is not empty
                        Scanner remove = new Scanner(System.in);
                        System.out.print("\nEmployee id: ");
                        String employeeToRemove = remove.nextLine();
                        removeEmp(employeeToRemove);
                        if (c) {
                            System.out.println("Employee has been removed!");
                        }
                        else {
                            System.out.println("Employee with that ID does not exist!");
                        }
                    }
                    break;

                case "3": // edit employee data
                    Scanner edit = new Scanner(System.in);
                    // if employee list is still empty
                    if (employeesMap.isEmpty()) {
                        System.out.println("\nNo employee at the moment!");
                    }
                    else { // if employee list is not empty
                        System.out.print("\nEmployee Id: ");
                        String idEdit = edit.nextLine();
                        boolean check = false;

                        // To check if the employee id exist or not
                        for (Map.Entry<String, Employees> entry : employeesMap.entrySet()) {
                            String empId = entry.getKey();
                            Employees employee = entry.getValue();

                            if (employee.getId().equals(idEdit)) {
                                check = true;
                                break;
                            }
                        }

                        if (!check) { // if id does not exist
                            System.out.println("Employee with that id does not exist");
                        }
                        else { // if id exist
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
                            editEmp(idEdit, newName, newPhone, newAddress, newDepartment, newPosition, newGender, newEmail);
                            System.out.println("Employee data has been updated!");
                        }
                    }
                    break;

                case "4": // view employee
                    viewEmp();
                    break;

                case "5": // search employee
                    // if employee list is still empty
                    if (employeesMap.isEmpty()) {
                        System.out.println("\nNo employee at the moment!");
                    }
                    else { // if employee list is not empty
                        Scanner search = new Scanner(System.in);
                        System.out.print("\nEmployee id: ");
                        String empID = search.nextLine();
                        searchEmp(empID);
                    }
                    break;

                case "6": // quit program
                    System.out.println("Thank you for using Employee Central. Hope to see you again☺️");
                    quit = true;
            }
        }
    }
}
