package org.example;
import java.util.Scanner;

public class InputValidation {
    public Integer Validate(Scanner scanner, int lowerBound, int upperBound,
                            String prompt, String errorMsg,
                            Integer defaultVal, boolean abortProgram)
    {
        while (true){
            System.out.println(prompt 
                            + (defaultVal != null ? "Enter 'default' for the default value of " + defaultVal + "\n" : "")
                            + (abortProgram ? "Enter 'exit to abort program \n" : ""));

            String input = scanner.nextLine().trim().toLowerCase();
                
            if (abortProgram && input.equals("exit")){
                return null;
            }
            if (defaultVal != null && input.equals("default")){
                return defaultVal;
            }
            try {
                int value = Integer.parseInt(input);
                if (value >= lowerBound && value <= upperBound){
                    return value;
                } else{
                    System.out.println(errorMsg);
                }
            } catch(NumberFormatException e){
                System.out.println(errorMsg);
            }
        }
    }
}