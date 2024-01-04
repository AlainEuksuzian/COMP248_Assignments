public class A3_Q2 {
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

    public static String[] seperateGradeAndName(String[] arr){
        String[] outputArray = new String[arr.length * 2];
            int counter = 0;
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

    public static int[] isolateGrades(String[] arr){
        int[] gradeArray = new int[(arr.length+1) /2 ];
        int counter = 0;
        for (int i = 0; i <  arr.length; i++){
            if (i % 2 == 1){
                gradeArray[counter] = Integer.parseInt(arr[i]);
                counter++;
            }
        }
        return gradeArray;
    }

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

    public static char[][] createClassArray(String[] classArr){
        char[][] courseArrayLetters = new char[3][];

        for (int i = 0; i < classArr.length; i++){
            courseArrayLetters[i] = classArr[i].toCharArray();
        }
        return courseArrayLetters;
    }

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

    public static double computeAverage(int[] gradeArrays){
        double average = 0;

        for (int i =0; i < gradeArrays.length; i++){
            average += gradeArrays[i];
        }
       
        return average / gradeArrays.length;
    }

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


    public static void printReport(double average, char letter) {
        
        System.out.printf("The average of your courses: %.2f "+
         " and the average courses letter grade is: " + letter, average);
    }

}
