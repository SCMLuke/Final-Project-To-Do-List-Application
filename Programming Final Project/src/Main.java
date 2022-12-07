import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Array listObj = new Array();
        Scanner userinput = new Scanner(System.in);
        String title;
        String date;
        String status;
        String description;
        int id;

        int power = 1;
        while (power < 2) {
            System.out.println("To-Do List / What would you like to do?");
            System.out.println("1 = Add Task / 2 = Mark Task as Done / 3 = Remove Task / 4 = Edit Task / 5 = Display Tasks / 6 = Exit");
            int selection = userinput.nextInt();


            if (selection == 1) {
                System.out.print("Enter Title: ");
                userinput.nextLine();
                title = userinput.nextLine();
                System.out.print("Enter Due Date: ");
                date = userinput.nextLine();
                System.out.print("Enter Status (Complete or Incomplete): ");
                status = userinput.nextLine();
                if (status.equals("Incomplete")) {
                    System.out.print("Enter Description: ");
                    description = userinput.nextLine();
                    listObj.list.add(title + " /// " + date + " /// " + status + " /// " + description);
                } else if (status.equals("Complete")) {
                    System.out.print("Enter Description: ");
                    description = userinput.nextLine();
                    listObj.list.add(title + " /// " + date + " /// " + status + " /// " + description);
                }else {
                    System.out.println("Status not set as Complete/Incomplete!");
                }
            }
            if (selection == 2) {
                int idinput;
                System.out.println("Enter Project position on the list to Toggle Complete/Incomplete: ");
                idinput = (userinput.nextInt() - 1);
                String thelist = listObj.list.get(idinput);
                System.out.println();
                System.out.println(listObj.list.get(idinput));
                System.out.println();
                System.out.println("What is the status of this assignment?: ");
                String toggleselect = userinput.next();
                if (toggleselect.equals("Incomplete")) {
                    thelist = thelist.replace("Incomplete", "Complete");
                } else if (toggleselect.equals("Complete")) {
                    thelist = thelist.replace("Complete", "Incomplete");
                } else {
                    System.out.println();
                    System.out.println("Status is not Complete/Incomplete");
                }
                System.out.println();
                System.out.println(thelist);
                listObj.list.set(idinput, thelist);
                System.out.println();
            }
            if (selection == 3) {
                System.out.print("Enter the position on the list of the project you want to delete: ");
                userinput.nextLine();
                id = userinput.nextInt();
                try {
                    listObj.list.remove((id - 1));
                    System.out.println();
                    System.out.println("Task removed!");
                    System.out.println();
                }
                catch (Exception e) {
                    System.out.println();
                    System.out.println("Item not found at the list number!");
                    System.out.println();
                }
            }
            if (selection == 4) {
                System.out.print("Enter the position on the list of the project you want to edit: ");
                userinput.nextLine();
                id = userinput.nextInt();
                System.out.print("Enter Title: ");
                userinput.nextLine();
                title = userinput.nextLine();
                System.out.print("Enter Due Date: ");
                date = userinput.nextLine();
                System.out.print("Enter Status (Complete or Incomplete): ");
                status = userinput.nextLine();
                if (status.equals("Incomplete")) {
                    System.out.print("Enter Description: ");
                    description = userinput.nextLine();
                    try {
                        listObj.list.set((id-1), title + " /// " + date + " /// " + status + " /// " + description);
                    }
                    catch (Exception e) {
                        System.out.println();
                        System.out.println("Item not found at the list number!");
                        System.out.println();
                    }
                } else if (status.equals("Complete")) {
                    System.out.print("Enter Description: ");
                    description = userinput.nextLine();
                    try {
                        listObj.list.set((id-1), title + " /// " + date + " /// " + status + " /// " + description);
                    }
                    catch (Exception e) {
                        System.out.println();
                        System.out.println("Item not found at the list number!");
                        System.out.println();
                    }
                }else {
                    System.out.println("Status not set as Complete/Incomplete!");
                }
                System.out.println("Row updated!");
            }
            if (selection == 5) {
                System.out.println();
                System.out.println("Name /// Due Date /// Completion Status /// Description");
                System.out.println("-------------------------------------------------------------------------");
                listObj.list.forEach(System.out::println);
                System.out.println();
                System.out.println();
            }
            if (selection == 6) {
                System.out.println("Goodbye!");
                power = 2;
            }
        }
    }
}
