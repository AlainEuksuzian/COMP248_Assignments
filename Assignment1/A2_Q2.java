import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class A2_Q2 {
    private static HashMap<String, Double[]> formulas = new HashMap<>();
    private static Scanner inputStream = null;
    private static final double OMEGA = 0.567143; 
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * The main function reads a text file, prompts the user for input, validates the input, calculates
     * the values of y and z, and prints the value of z.
     */
    public static void main(String[] args) {
        // line 13 to 20 connects to a text file, if not found, program ends
        try {
            inputStream = new Scanner(new FileInputStream("C:\\Users\\Alain E\\Desktop\\vscode-files\\JAVA\\comp248\\Assignment1\\learning_formula.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

        convertToHashMap(); // convers the inputStream into hashmap called "formulas"

        // parses user input for weekday and time, if any of the 2 inputs are invalid, program ends
        String[] dayTimeSeperator = getUserDateTimeInputs();
        String day = dayTimeSeperator[0];
        String time = dayTimeSeperator[1];

       if (!inputValidator(day, time)){
        System.out.println("input is invalid, program we end");
        System.exit(0);
       }

       double yValue = getYvalue(day,time);
       double Zvalue = getZvalue(yValue);
       
       System.out.printf("Value of Prototype Learning Function, Z is: %.3f", Zvalue );


    }

    /**
     * subroutine parses learning_formula.txt into string (key) and 2 doubles as an array (value) and inputs to hashmap formulas
     * no return statement
     */
    public static void convertToHashMap(){
        while(inputStream.hasNext()){
            String nextLine = inputStream.nextLine();
            
            String[] parsedLine = nextLine.split(" ");
            String day = parsedLine[0].toLowerCase();
            Double valueDay = Double.parseDouble(parsedLine[1]);
            Double valueNight = Double.parseDouble(parsedLine[2]);
            Double[] array = {valueDay, valueNight};
            formulas.put(day, array);
        }
    }

    /**
     * subroutine to prints hashmap as a presentable form as (key => value1, value2 \n)
     * no return statement
     */
    public static void printDataset(){

        for (Map.Entry<String, Double[]> entries: formulas.entrySet()){
            String day = entries.getKey();
            Double[] values = entries.getValue();
            System.out.print(day + " => ");
            for (Double value : values){
                System.out.print(value  + ", ");
            }
            System.out.println();
        }
    }

    /**
     * The function "getUserInput" in Java prompts the user with a message and returns their input as a
     * string.
     * 
     * @param message A string message that will be displayed to the user as a prompt for input.
     * @return The method is returning a String value.
     */
    public static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine(); 
    }

    
/**
 * The function `getUserDateTimeInputs` takes user input for a weekday and time in one sentence,
 * converts it to lowercase, splits it into separate words, and returns an array of the words.
 * 
 * @return The method is returning an array of strings.
 */
    public static String[] getUserDateTimeInputs(){
        String weekdayTimeInput  = getUserInput("enter weekday and time in one sentence:  ");
        String weekdayTimeInputLowered = weekdayTimeInput.toLowerCase();
        String[] dayTimeSeperator = weekdayTimeInputLowered.split(" ");
        return dayTimeSeperator;
    }

   
/**
 * The function checks if the input day and time are valid based on certain conditions.
 * 
 * @param day A string representing the day of the week.
 * @param time The time parameter is a string that represents either "day-light" or "night-time".
 * @return The method is returning a boolean value.
 */
    public static boolean inputValidator(String day, String time){
        if ((!formulas.containsKey(day))){
            return false;
        }
         if (!time.equals("day-light") && !time.equals("night-time")){
           return false;
        }
        return true;
    }

    /**
     * queries hashmap to get the respective Y value based on day and time
     * @param day for weekday
     * @param time for time
     * @return y_value from hashmap value
     */
    public static double getYvalue(String day, String time){

        int time_index = 0; // set to day-time for default (as input validation already done at this point)
        if (time.equalsIgnoreCase("night-time")){
            time_index = 1;
        }
        return formulas.get(day)[time_index];

    }
    /**
     * computes z value with omega instance
     * @param yValue
     * @return computes final Z value
     */
    public static double getZvalue(double yValue){
        double valueZ = OMEGA * yValue;
        return valueZ; 
    }

    
    
}
