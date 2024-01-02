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
    public static void main(String[] args) {
        // line 13 to 20 connects to a text file, if not found, program ends
        try {
            inputStream = new Scanner(new FileInputStream("C:\\Users\\Alain E\\Desktop\\JAVA\\comp248\\Assignment-1\\learning_formula.txt"));
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

       System.out.println(getYvalue(day, time));


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
     * subroutine to get user keyboard input
     * @param message prints a message to get user input
     * @return a line of string the user entered
     */
    public static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine(); 

    }

    /**
     * subroutine to get weekday and day-night input 
     * @return an array where index[0] is weekday and index[1] is day-light or night-time
     */
    public static String[] getUserDateTimeInputs(){
        String weekdayTimeInput  = getUserInput("enter weekday and time in one sentence:  ");
        String weekdayTimeInputLowered = weekdayTimeInput.toLowerCase();
        String[] dayTimeSeperator = weekdayTimeInputLowered.split(" ");
        return dayTimeSeperator;
    }

    /**
     * checks if user inputs for day of week and time of day is correct
     * @param day
     * @param time
     * @return true if day is a key of map and if time is "day-light" or "night-time" , FALSE otherwise
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

    
    
}
