import com.suhuitan.TodoApp;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    private static TodoApp app;
    private static Scanner scanner;


    public static void main(String[] args) {
        app = new TodoApp();
        scanner = new Scanner(System.in);

        System.out.println("Todo App");
        System.out.println("type \"help\" for a list of commands");

        while(true){
            String userInput =  scanner.nextLine();
            String[] commands = userInput.split("\\s+", 2);
            switch (commands[0].toLowerCase()){
                case "help": printHelpSection(); break;
                case "create": createATask(commands[1]); break;
                case "print": printTasks(); break;
                case "delete": deleteATask(commands[1]); break;
                case "done":doneATask(commands[1]); break;
                case "edit": editATask(commands[1]); break;
                default: System.out.println("Instruction unknown. Type \"help\" for a list of commands");
            }
        }
    }

    private static void editATask(String taskNo) {
        System.out.println("Edit: ");
        String userInput = scanner.nextLine();
        app.editTask(Integer.parseInt(taskNo)-1, userInput);
    }

    private static void doneATask(String taskNo) {
        System.out.println();
        app.toggleDone(Integer.parseInt(taskNo));
        printTasks();
    }

    private static void deleteATask(String taskNo) {
        System.out.println();
        app.deleteTask(Integer.parseInt(taskNo));
        System.out.println("Task deleted..");
        printTasks();
    }

    private static void printTasks() {
        List<String> tasks = app.getTasksAsListOfString();
        System.out.println("No \tDetails");
        IntStream.range(0, tasks.size())
                 .forEach(i -> System.out.println( (i+1) +" \t" + tasks.get(i)));
    }

    private static void createATask(String taskDetails) {
        app.addTask(taskDetails);
        System.out.println("Task added.. \n");
    }

    private static void printHelpSection() {
        System.out.println();
        System.out.println("--List of commands--");
        System.out.println("create <task details>");
        System.out.println("print");
        System.out.println("delete <task num>");
        System.out.println("done <task num>");
        System.out.println("edit <task num>");
    }
}
