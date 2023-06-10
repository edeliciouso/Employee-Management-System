import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListEMP {
    //create a courseList arrayList that will store all courses
    private static ArrayList<Employees> employeesList = new ArrayList<>();

    //create a course class as a collection of courses for arraylist
    private static class Employees {
        private String id;
        private String name;
        private String phone;
        private String address;
        private String department;
        private String position;
        private String gender;
        private String email;

        //constructor for Course class
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

        //setters and getters method
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

    public static void display() {
        System.out.println("\nWelcome to Employee Central, an Employee Management System!");
        System.out.println("\n******************************");
        System.out.println("(1) Add employee");
        System.out.println("(2) Remove employee");
        System.out.println("(3) Edit employee data");
        System.out.println("(4) View employee list");
        System.out.println("(5) Search employee by id");
        System.out.println("(6) Exit system");
        System.out.println("******************************");
        System.out.print("Choose a command: ");
    }


    // add employee
    public static void addEmp(String id, String name, String phone, String address, String department, String position, String gender, String email) {
        //create a new course object and add it to the courseList
        Employees newEmp = new Employees(id, name, phone, address, department, position, gender, email);
        employeesList.add(newEmp);

        System.out.println("\nThe employee has been added successfully");
    }

    // remove employee
    public static void removeEmp(String id) {
        //check if the course list is empty
//        if (employeesList.isEmpty()) {
//            System.out.println("\nNo employees at the moment!");
//            return;
//        }

        //iterate over the course list in reverse order to find the matching course name
        for (int i = employeesList.size() - 1; i >= 0; i--) {
            Employees employee = employeesList.get(i);
            //if found, remove the course from the courseList
            if (employee.getId().equals(id)) {
                employeesList.remove(i);
                System.out.println("\nEmployee has been removed successfully!");
                return;
            }
        }

        //if no matching course is found
        System.out.println("Employee with that Id does not exist");
    }

    // edit employee data
    public static void editEmp(String id, String newName, String newPhone, String newAddress, String newDepartment, String newPosition, String newGender, String newEmail) {
        //search for course with matching course name
        for (Employees employee : employeesList) {
            if (employee.getId().equals(id)) {
                //update the course by setting all the modified course information
                employee.setName(newName);
                employee.setPhone(newPhone);
                employee.setAddress(newAddress);
                employee.setDepartment(newDepartment);
                employee.setPosition(newPosition);
                employee.setGender(newGender);
                employee.setEmail(newEmail);

                System.out.println("\nSuccessfully updated employee data!");
                return;
            }
        }

        //if no matching course is found
        System.out.println("There aren't any employees with that name!");
    }

    // view the list of all employees
    public static void viewEmployee() {
        //check whether course list is empty
        if (employeesList.isEmpty()) {
            System.out.println("\nThere aren't any employees yet!");
        } else {
            //iterate over the course list to print out all the courses information
            for (Employees employee : employeesList) {
                System.out.println("\n-Employee Details-");
                System.out.println("Id: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Phone: " + employee.getPhone());
                System.out.println("Address: " + employee.getAddress());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Gender: " + employee.getGender());
                System.out.println("Email: " + employee.getEmail());
            }
        }
    }

    // Search an Employee by their id
    public static void searchEmp(String empSearch) {
        //iterate over the course list to find the specified course
        for (Employees employee : employeesList) {
            //if found, print the course details
            if (employee.getId().equals(empSearch)) {
                System.out.println("\n-Employee Details-");
                System.out.println("ID: " + employee.getId());
                System.out.println("Name: " + employee.getName());
                System.out.println("Phone: " + employee.getPhone());
                System.out.println("Address: " + employee.getAddress());
                System.out.println("Department: " + employee.getDepartment());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Gender: " + employee.getGender());
                System.out.println("Email: " + employee.getEmail());
            }
            return;
        }

        //if no matching course is found
        System.out.println("No employee with that id exist!");
    }


    //Main Method and Program Execution//
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            display();
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    Scanner read = new Scanner(System.in);
                    //prompt for course details
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
                case "2":
                    if (employeesList.isEmpty()) {
                        System.out.println("\nNo employees at the moment!");
                    }
                    else {
                        Scanner remove = new Scanner(System.in);
                        //prompt for a course to be removed
                        System.out.print("\nEmployee id: ");
                        String employeeToRemove = remove.nextLine();
                        removeEmp(employeeToRemove);
                    }
                    break;
                case "3":
                    Scanner edit = new Scanner(System.in);
                    //check if the course list is empty
                    if (employeesList.isEmpty()) {
                        System.out.println("\nThere aren't any employees yet!");
                    } else {
                        //prompt for a course to be modified
                        System.out.print("\nEmployee Id: ");
                        String employeeToEdit = edit.nextLine();

                        boolean idFound = false;

                        for (Employees employee : employeesList) {
                            if (employee.getId().equals(employeeToEdit)) {
                                idFound = true;
                                break;
                            }
                        }

                        if (!idFound) {
                            System.out.println("No employee with that id exist");
                        } else {
                            //modify the specified course with new information
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
                    break;
                case "4":
                    viewEmployee();
                    break;
                case "5":
                    if (employeesList.isEmpty()) {
                        System.out.println("\nNo employees at the moment!");
                    }
                    else {
                        Scanner search = new Scanner(System.in);
                        //prompt for a course to search
                        System.out.print("\nEmployee id: ");
                        String empID = search.nextLine();
                        searchEmp(empID);
                    }
                    break;

            }
        } while (!choice.equals("6")) ;
    }
}
