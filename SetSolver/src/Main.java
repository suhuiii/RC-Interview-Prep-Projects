import solver.*;
import solver.Card;
import solver.Card.*;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static setsolver solver;

    public static void main(String[] args) {
        solver = new setsolver();
        scanner = new Scanner(System.in);

        System.out.println("--- Set Solver ---");
        checkThreeCards();
    }

    static void checkThreeCards(){
        System.out.println("Input three cards to check if it is a set");
        Card setOfThree[] = new Card[3];

        for(int i = 1; i<=3; i++){
            setOfThree[i-1] = new Card(getColorFromUser(i), getSymbolFromUser(i), getNumbersFromUser(i));
        }

        if(solver.checkMatches(setOfThree))
            System.out.println("SET!");
        else
            System.out.println("Not a set...");
    }

    private static Colors getColorFromUser(int num) {
        System.out.println("Enter Color of Card " + num);
        Colors colors[] = Colors.values();
        for (int i = 0; i < colors.length; i++) {
            System.out.println( (i+1) + ":" + colors[i].name());
        }
        return colors[getvalidUserInput(colors.length)];
    }

    private static Symbols getSymbolFromUser(int num) {
        System.out.println("Enter Number of Card " + num);
        Symbols symbols[] = Symbols.values();
        for (int i = 0; i < symbols.length; i++) {
            System.out.println( (i+1) + ":" + symbols[i].name());
        }
        return symbols[getvalidUserInput(symbols.length)];
    }

    private static Numbers getNumbersFromUser(int num) {
        System.out.println("Enter Number of Card " + num);
        Numbers numbers[] = Numbers.values();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println( (i+1) + ":" + numbers[i].name());
        }
        return numbers[getvalidUserInput(numbers.length)];
    }

    static Integer getvalidUserInput(int maxVal){
        boolean validInput = false;
        do{
            try{
                int choice = Integer.parseInt(scanner.nextLine()) - 1;
                if(choice >= maxVal || choice < 0)
                    System.out.println("User input out of range...");
                else
                    return choice;
            }catch (NumberFormatException ex){
                System.out.println("Please enter a number");
            }
        }while (!validInput);
        return null;
    }
}
