/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;


import java.util.Scanner;
import static java.time.Clock.system;

/** This class calls the method to perform 
 * arithmetic operations based on user input
 * execute the code check the output
 * @author sivagamasrinivasan
 * 
 */
enum Operation {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE
}

class ArithmeticInputOutput {
    public Operation getOperationFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter arithmetic operation to perform: ");
        String operationString = scanner.next().toUpperCase();
        
        try {
            return Operation.valueOf(operationString);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation: " + operationString);
        }
    }
    
    public int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        return scanner.nextInt();
    }
    
    public void displayResult(double result) {
        System.out.println("Result: " + result);
    }
}

class ArithmeticCalculator {
    public double calculate(double x, double y, Operation operation) {
        switch (operation) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
            default:
                throw new AssertionError("Unknown operation: " + operation);
        }
    }
}

public class Arithmetic {
    public static void main(String[] args) {
        ArithmeticInputOutput inputOutput = new ArithmeticInputOutput();
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        
        double x = inputOutput.getNumberFromUser();
        double y = inputOutput.getNumberFromUser();
        Operation operation = inputOutput.getOperationFromUser();
        
        double result = calculator.calculate(x, y, operation);
        inputOutput.displayResult(result);
    }
}
