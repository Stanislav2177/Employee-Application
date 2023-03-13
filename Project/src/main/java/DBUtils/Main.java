package DBUtils;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        /*
        From this main class can be started console variant of this application.
        All logic is based on references if and switch statements.
         */

        EmployeeDBInConsole employeeDBInConsole = new EmployeeDBInConsole();
        TaskDBInConsole taskDBInConsole = new TaskDBInConsole();
        DepartmentDBInConsole departmentDBInConsole = new DepartmentDBInConsole();

        while (true) {
            System.out.println("Menu");
            System.out.println("1. Open Employee");
            System.out.println("2. Open Task");
            System.out.println("3. Open Department");
            System.out.println("0. Exit");
            System.out.print("Enter your choice :");

            Scanner scanner = new Scanner(System.in);
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        employeeDBInConsole.start();
                        break;
                    case 2:
                        taskDBInConsole.start();
                        break;
                    case 3:
                        departmentDBInConsole.start();
                        break;
                    case 0:
                        return;
                }
            }catch (InputMismatchException e){
                System.out.println("While using the menu only integers are accepted");
                start();
            }
        }
    }
}