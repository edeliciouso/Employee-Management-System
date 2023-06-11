import java.util.HashMap;
import java.util.Scanner;

public class HashMapEMS {
    private static HashMap<String, Employees> employeesHashMap = new HashMap<>();

    private static class Employees {
        private String id;
        private String name;
        private String phone;
        private String address;
        private String department;
        private String position;
        private String gender;
        private String email;

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

    public static void addEmp(String id, String name, String phone, String address, String department, String position, String gender, String email){
        Employees newEmp = new Employees(id, name, phone, address, department, position, gender, email);
        employeesHashMap.put(id, newEmp);

        System.out.println("\nThe employee has been added successfully.");
    }

    public static void removeEmp(String id){
        if(employeesHashMap.containsKey(id)){
            employeesHashMap.remove(id);
            System.out.println("\nEmployee has been removed successfully!");
        } else{
            System.out.println("Employee with that Id does not exist");
        }
    }

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

            System.out.println("\nSuccessfully updated employee data!");
        } else{
            System.out.println("Employee with that Id does not exist");
        }
    }

    public static void viewEmp(){
        if(employeesHashMap.isEmpty()){
            System.out.println("\nThere aren't any employees yet!");
        } else{
            int n = 1;
            System.out.println("\n********************************");
            System.out.println("        Employee Details");
            System.out.println("********************************");
            for (Employees employee : employeesHashMap.values()) {
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

    public static void searchEmp(String id){
        Employees employee = employeesHashMap.get(id);
        if(employeesHashMap.containsKey(id)){
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

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            display();
            choice = input.nextLine();

            switch (choice) {
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
                }
                case "2" -> {
                    if (employeesHashMap.isEmpty()) {
                        System.out.println("\nNo employees at the moment!");
                    } else {
                        Scanner remove = new Scanner(System.in);
                        System.out.print("\nEmployee id: ");
                        String employeeToRemove = remove.nextLine();
                        removeEmp(employeeToRemove);
                    }
                }
                case "3" -> {
                    Scanner edit = new Scanner(System.in);
                    if (employeesHashMap.isEmpty()) {
                        System.out.println("\nThere aren't any employees yet!");
                    } else {
                        System.out.print("\nEmployee Id: ");
                        String employeeToEdit = edit.nextLine();

//                        boolean idFound = false;
//
//                        if (employeesHashMap.containsKey(employeeToEdit)) {
//                            idFound = true;
//                            break;
//                        }
                        if(!employeesHashMap.containsKey(employeeToEdit)){
                            System.out.println("No employee with that id exist");
                        } else {
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
            }
        } while (!choice.equals("6")) ;
    }
}
