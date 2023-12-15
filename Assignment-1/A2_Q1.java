import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.HashMap;


public class A2_Q1 {
   private static Scanner inputStream = null;
   private static Scanner keyboard = new Scanner(System.in);
   private  static HashMap<Integer, String> covidSymptoms = new HashMap<>();
   public static void main(String[] args) {

      /*
       * tries to connect to text file : like 17 to 23
       */
      try {
         inputStream = new Scanner(new FileInputStream("C:\\Users\\Alain E\\Desktop\\JAVA\\comp248\\Assignment-1\\covid.txt"));
      }
      catch (FileNotFoundException e) {
         System.out.println("the file has not been found, code has to end");
         System.exit(0);
      }

      System.out.println("the covid symtoms and their respective numbers are:");
      convertToMap(); /* <- this method should always be called before printSymptoms() */
      printSymptoms();
      inputStream.close();
      
      /*
       * as long as user input is invalid, code will continue asking for valid input, if valid will out symptoms
       */
        int symptomCode = Integer.parseInt(getUserInput("enter a symtom Code: ")); /*gets user code for symtom */
        boolean correctSymptomInput = symptomSeverity(symptomCode);

        while(!correctSymptomInput){
         symptomCode = Integer.parseInt(getUserInput("the code entered is invalid, please try again: "));

         if (symptomCode >= 10 && symptomCode <= 23 || (symptomCode <= 9 && symptomCode >= -128)){
           correctSymptomInput = true;
            symptomSeverity(symptomCode);
            
          }
        }

        if (symptomCode >= 10 && symptomCode <= 23){
         System.out.println(covidSymptoms.get(symptomCode));
        }
      
   }

   /**
    * no param.
    * loops through the text file, seperates numbers and symtpoms and adds it to hashmap as K-V pair
    */
   public static void convertToMap(){

      while(inputStream.hasNext()){
         String line = inputStream.nextLine();
         int indexSeperator = line.indexOf("-");
         int covidNumber = Integer.parseInt(line.substring(0, indexSeperator));
         String remainingSymptoms = line.substring(indexSeperator+2);
         covidSymptoms.put(covidNumber, remainingSymptoms);
      }
   }

   /*
    * ****************** ALL METHODS BELOW MUST BE USED AFTER calling convertToMap() *******************
    */

   /*
    * no param
    *prints the hashmap to show symptoms 
    */
   public static void printSymptoms(){
      covidSymptoms.forEach((key,value) -> System.out.println(key + "=>" + value));
   }

   /**
    * gets user input with keyboard input
    * @param message
    * @return keyboard input (user input)
    */
   public static String getUserInput(String message){
      System.out.print(message);
      return keyboard.nextLine();
   }

   /**
    * gets user code(symptom) argument and checks for validity
    * @param code integer for symptom
    * @return True if code input value, false otherwise
    */
   public static boolean symptomSeverity(int code){
      String messageSeverity = "";
      boolean correctInput = false;

      if (code >= 10 && code <= 13){
         messageSeverity = "Most Common";
         correctInput = true;
      }
      else if (code >= 14 && code <= 20){
         messageSeverity = "less common";
         correctInput = true;
      }
      else if (code >= 21 && code <= 23){
         messageSeverity = "Critical Symptoms";
         correctInput = true;
      }
      else if ((code >= 24 && code <= 128) || (code <= 9 && code >= -128)){
         messageSeverity = "No Obvious Symptoms";
         correctInput = true;
      }
      System.out.println(messageSeverity);
      return correctInput;
      
      
   }
}