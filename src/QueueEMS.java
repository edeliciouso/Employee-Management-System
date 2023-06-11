import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueEMS {
    private static Queue<Employees> employeesQueue = new LinkedList<>();

    private static class Employees {
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

    // Add Employee Method
    public static void addEmp(String id, String name, String phone, String address, String department, String position, String gender, String email) {
        Employees newEmp = new Employees(id, name, phone, address, department, position, gender, email);
        employeesQueue.add(newEmp);
        System.out.println("\nEmployee has been added!");
    }

    // Remove Employee Method
    public static void removeEmp(String id) {
        Iterator<Employees> iterator = employeesQueue.iterator(); // creates iterator for the queue
        while (iterator.hasNext()) {
            Employees employee = iterator.next(); // retrieve the next element
            if (employee.getId().equals(id)) { // if employee id exists
                iterator.remove();
                System.out.println("\nEmployee has been removed!");
                return;
            }
        }
        // if employee not found
        System.out.println("\nEmployee with that Id does not exist!");
    }

    // Edit Employee Method
    public static void editEmp(String id, String newName, String newPhone, String newAddress, String newDepartment, String newPosition, String newGender, String newEmail) {
        for (Employees employee : employeesQueue) {
            if (employee.getId().equals(id)) { // if employee id exist
                employee.setName(newName);
                employee.setPhone(newPhone);
                employee.setAddress(newAddress);
                employee.setDepartment(newDepartment);
                employee.setPosition(newPosition);
                employee.setGender(newGender);
                employee.setEmail(newEmail);
                System.out.println("\nEmployee data has been updated!");
                return;
            }
        }
        // if employee not found
        System.out.println("\nEmployee with that Id does not exist!");
    }

    // View Employee Method
    public static void viewEmp() {
        // if employee list is still empty
        if (employeesQueue.isEmpty()) {
            System.out.println("\nNo employee at the moment!");
        }
        else { // if employee list is not empty
            int n = 1;
            System.out.println("\n********************************");
            System.out.println("        Employee Details");
            System.out.println("********************************");
            for (Employees employee : employeesQueue) {
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

    // Search Employee Method (by Id)
    public static void searchEmp(String id) {
        for (Employees employee : employeesQueue) {
            if (employee.getId().equals(id)) { // if employee id exist
                System.out.println("\n-Employee Details-");
                System.out.println("ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Phone: " + employee.getPhone());
                System.out.println("Address: " + employee.getAddress());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Gender: " + employee.getGender());
                System.out.println("Email: " + employee.getEmail());
                return;
            }
        }
        // if employee not found
        System.out.println("Employee with that Id does not exist!");
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
                    break;

                case "2": // remove employee
                    // if employee list is still empty
                    if (employeesQueue.isEmpty()) {
                        System.out.println("\nNo employees at the moment!");
                    }
                    else { // if employee list is not empty
                        Scanner remove = new Scanner(System.in);
                        System.out.print("\nEmployee id: ");
                        String employeeToRemove = remove.nextLine();
                        removeEmp(employeeToRemove);
                    }
                    break;

                case "3": // edit employee data
                    Scanner edit = new Scanner(System.in);
                    // if employee list is still empty
                    if (employeesQueue.isEmpty()) {
                        System.out.println("\nNo employee at the moment!");
                    }
                    else { // if employee list is not empty
                        System.out.print("\nEmployee Id: ");
                        String idEdit = edit.nextLine();
                        boolean check = false;

                        // To check if the employee id exist or not
                        for (Employees employee : employeesQueue) {
                            if (employee.getId().equals(idEdit)) {
                                check = true;
                                break;
                            }
                        }

                        if (!check) { // if id does not exist
                            System.out.println("No employee with that id exist");
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
                        }
                    }
                    break;

                case "4": // view employee
                    viewEmp();
                    break;

                case "5": // search employee
                    // if employee list is still empty
                    if (employeesQueue.isEmpty()) {
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
