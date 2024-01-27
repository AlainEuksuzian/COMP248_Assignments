public class A3_Q2 {
    /**
    * Main method for testing. Runs the program with the arguments passed to it. It is expected that you have a list of strings that are separated by commas in the form COMP248|95 ENGLISH201|75 CHEMISTRY - 1|45
    * 
    * @param args - the command line arguments
    */
    public static void main(String[] args) {

        String wordtester= "COMP248|95,ENGLISH201|75,CHEMISTRY-1|45,";

        String[] allArray = wordtester.split(",");
        
        String[] classAndGrade = seperateGradeAndName(allArray);
        int[] gradeArrays = isolateGrades(classAndGrade);
        String[] classArrays = isolateClasses(classAndGrade);
        char[][] letterClasses = createClassArray(classArrays);

       print2Darray(letterClasses);

       double averageGrade = computeAverage(gradeArrays);
       char getLetterGrade = gradeLetterConvertor(averageGrade);

       printReport(averageGrade, getLetterGrade);

       
    }   

    /**
    * Takes an array of strings and separates them into grade and name. This is useful for generating a list of 
    students who have the same grade and name in the same order
    * @param arr - the array of strings to
    */
    public static String[] seperateGradeAndName(String[] arr){
        String[] outputArray = new String[arr.length * 2];
            int counter = 0;
        // This method is used to generate the class and course of the course
        for (int i = 0; i < arr.length; i++){
            String word = arr[i];
            int sepIndex = word.indexOf("|");
            String myclass = word.substring(0, sepIndex);
            String course = word.substring(sepIndex+1);
            outputArray[counter] = myclass;
            outputArray[counter+1] = course;
            counter+=2;
        }
        return outputArray;
    }

    /**
    * Returns an int array of the grades in the string array. 
    *Grades are divided by two so that the first half of the array is the grade and the second half is the total
    * @param arr - the string array to
    */
    public static int[] isolateGrades(String[] arr){
        int[] gradeArray = new int[(arr.length+1) /2 ];
        int counter = 0;
        // Grade the grade array.
        for (int i = 0; i <  arr.length; i++){
            if (i % 2 == 1){
                gradeArray[counter] = Integer.parseInt(arr[i]);
                counter++;
            }
        }
        return gradeArray;
    }

    /**
    * Returns a String array with even elements. Useful for isolating classes that are in the middle of a class name
    * 
    * @param arr - Class names to isolate
    */
    public static String[] isolateClasses(String[] arr){
        String[] classNames = new String[(arr.length + 1)/2];
        int counter = 0;
        
        for (int i = 0; i < arr.length; i++){
            if (i % 2 == 0){
                classNames[counter] = arr[i];
                counter++;
            }
        }
        return classNames;
    }

    /**
    * Creates and returns a char array of length 3. The class array is copied from the string array passed
    * @param classArr - the array to be
    */
    public static char[][] createClassArray(String[] classArr){
        char[][] courseArrayLetters = new char[3][];

        for (int i = 0; i < classArr.length; i++){
            courseArrayLetters[i] = classArr[i].toCharArray();
        }
        return courseArrayLetters;
    }

    /**
    * Prints the 2D array to System. out. This is useful for debugging. It's a helper function to be used in test
    * @param letterClasses - the 2D array to
    */
    public static void print2Darray(char[][] letterClasses){
        System.out.println("Here is the list of courses you are taking: ");
        for (int row = 0; row < letterClasses.length; row++){
            int counter = row + 1;
            System.out.print("No." + counter + " ");
            for (int col = 0; col < letterClasses[row].length; col++){
                System.out.print(letterClasses[row][col]);
            }
            System.out.println();
        }
    }

    /**
    * Computes the average of the given array of integers. This is useful for calculating the grade of a student's fraud - graded papers.
    * @param gradeArrays - an array of integers to be averaged
    * @return the average of the given array of integers as a double between 0 and 1. 0 ( inclusive )
    */
    public static double computeAverage(int[] gradeArrays){
        double average = 0;

        for (int i =0; i < gradeArrays.length; i++){
            average += gradeArrays[i];
        }
       
        return average / gradeArrays.length;
    }

    /**
    * Converts a grade to letter. This is used to determine the grade of a person based on their average value
    * @param average - the average value of the person
    * @return the letter or null if not a grade in the range of A B C D or F or if the average is
    */
    public static Character gradeLetterConvertor(double average){
        if (average >= 88){
            return 'A';
        }
        else if (average >= 80 ){
            return 'B';
        }
        else if (average >= 67){
            return 'C';
        }
        else if (average >= 60){
            return 'D';
        }
        else if (average < 60){
            return 'F';
        }
        return null;
    }

    
    /**
    * Prints a report to the console. It is used to report the average and the letter grade of the students
    * @param average - the average of the students
    * @param letter - the letter grade of the student
    */
    public static void printReport(double average, char letter) {
        
        System.out.printf("The average of your courses: %.2f "+
         " and the average courses letter grade is: " + letter, average);
    }

}
