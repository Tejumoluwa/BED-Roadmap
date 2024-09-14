import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class ToDoList {
    private final Scanner reader = new Scanner(System.in);
    private final LinkedList<String> incompleteTasks = new LinkedList<>();
    private final LinkedList<String> completeTasks = new LinkedList<>();
    private String task;

    public int getIntInput(){
        int choice = 0;
        while(choice == 0){
            try{
                choice = reader.nextInt();
                if(choice == 0) throw new InputMismatchException();
                reader.nextLine();
            }catch (InputMismatchException e){
                System.out.println("\nInvalid input");
                reader.nextLine();
            }
        }
        return choice;
    }

    public void displayCompletedTasks(){
        System.out.println();
        System.out.println("Completed Tasks");
        System.out.println("================");
        if(completeTasks.size() != 0) {
            for (String completeTask : completeTasks) {
                System.out.println(completeTask + "\n");
            }
        }else{
            System.out.println("No Tasks");
        }
    }

    public void displayUncompletedTasks(){
        System.out.println();
        System.out.println("Uncompleted Tasks");
        System.out.println("================");
        if(incompleteTasks.size() != 0) for (String incompleteTask : incompleteTasks) {
            System.out.println(incompleteTask + "\n");
        }
        else{
            System.out.println("No Tasks");
        }
    }

    public void addTasks(){
        System.out.println();
        task = getTask();
        incompleteTasks.add(task);
        System.out.println("Task added successfully\n");
    }

    public void deleteTasks(){
        System.out.println();
        task = getTask();
        int choice = 3;
        while(choice > 2){
            System.out.println("\n1) Delete from incomplete tasks");
            System.out.println("2) Delete from complete tasks");
            choice = getIntInput();
        }
        if(choice == 1 && incompleteTasks.contains(task)){
            incompleteTasks.remove(task);
            System.out.println("Successfully deleted task\n");
        }
        else if(completeTasks.contains(task)){
            completeTasks.remove(task);
            System.out.println("Successfully deleted task\n");
        }else{
            System.out.println("No such task");
        }
    }

    public void markComplete(){
        System.out.println();
        task = getTask();
        if(incompleteTasks.contains(task)){
            incompleteTasks.remove(task);
            completeTasks.add(task);
            System.out.println("Task successfully completed\n");
        }else{
            System.out.println("Unsuccessful\n");
        }
    }

    public void printChoice(){
        System.out.println("To Do List");
        System.out.println("=============");
        System.out.println("1) Add task ");
        System.out.println("2) Delete task");
        System.out.println("3) Mark task complete");
        System.out.println("4) Display completed task ");
        System.out.println("5) Display uncompleted task");
        System.out.println("Please enter 1-5 (or -1 to exit programme)");
    }

    public String getTask(){
        System.out.println("Task: ");
        task = reader.nextLine();
        return task;
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.printChoice();
        int choice = toDoList.getIntInput();
        while(choice != -1){
            switch (choice) {
                case 1 -> toDoList.addTasks();
                case 2 -> toDoList.deleteTasks();
                case 3 -> toDoList.markComplete();
                case 4 -> toDoList.displayCompletedTasks();
                case 5 -> toDoList.displayUncompletedTasks();
                default -> System.out.println("Invalid input");
            }
            toDoList.printChoice();
            choice = toDoList.getIntInput();
        }
        System.out.println("Good Bye");
    }
}
