import java.util.Scanner;
import java.util.Arrays;

public class A3_Q1 {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        
        String[] wordArray = getSentenceAndParseToArray();
        int sentenceLength = totalSentenceLength(wordArray);  // we have sentence Length

        int[] wordLength = new int[sentenceLength];  // init array
        wordLength = individualWordLength(wordArray); // stores the length of each word in orer entered

        int[] smallestAndLargestWord = getMinAndMax(wordLength); // stores smallest and largest word

        double averageSentenceLength = getAverageWordLength(wordLength); // stores average length of the sentence
        
        // outputs final message:
        toString(wordLength, smallestAndLargestWord, averageSentenceLength);

        

    }
    /**
     * subrountine to get user input
     * @param message
     * @return a sentence 
     */
    private static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine();
    }

    /**
     * parses word and removes last letter which is a (.)
     * @param word
     * @return parsed word of type string
     */
    private static String cleanWordInput(String word){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length()-1; i++){
            char ch = word.charAt(i);
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * called userInput method to take keyboard input, called cleanwordInput to remove last dot
     * @return a string word array
     */
    public static String[] getSentenceAndParseToArray(){
        String wordInput = getUserInput("enter sentence to begin program: ");
        String cleanedWordInput = cleanWordInput(wordInput);
        String[] wordArray = cleanedWordInput.split(" ");
        return wordArray;
    }

    /**
     * counts total words in user input that was brought to an array
     * @param arr
     * @return the size of an array (sentence size by word)
     */
    public static int totalSentenceLength(String[] arr){
        return arr.length;
    }
    
    /**
     * counts the number of letter in each word and stores in an array (maintains order)
     * @param wordArr
     * @return an array of int that represents the length of each individual ord
     */
    public static int[] individualWordLength(String[] wordArr){
        int[] wordCounter = new int[wordArr.length];

        for (int i= 0; i < wordArr.length; i++){
            String word = wordArr[i];
            wordCounter[i] = word.length();
            
        }
        return wordCounter;
    }
    
    /**
     * sorts array to get smallest and largest value (index 0 and index length-1)
     * @param arr
     * @return returns an array of size 2 where index[0] smallest, index[1] largest
     */
    public static int[] getMinAndMax(int[] arr){
        int[] copyArr = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++){
            copyArr[i] = arr[i];
        }

        Arrays.sort(copyArr);

        int[] minMax = {copyArr[0], copyArr[copyArr.length-1]};
        return minMax;
    }

    /**
     * loops through array that stores length of each word, sums it up and returns the average
     * @param wordLength the array that stores the length of each word
     * @return value of type double for the average length of words
     */
    public static double getAverageWordLength(int[] wordLength){
        double sum = 0;
        for (int i = 0; i < wordLength.length; i++){
            sum += wordLength[i];
        }
        return sum / wordLength.length ;
    }

    /**
     * method to output the final message in a structured way : display how many letter each word has, the length of word,
     * the shortest length word, the largest length word and the average length of sentence
     * @param wordLength  an array that stores the length of each word in correct order
     * @param minMaxArray an array where index[0] = smallest word, index[1] = largest word
     * @param averageSentenceLength argument from previous method (like 103) for the average length of words (type double)
     */
    public static void toString(int[] wordLength, int[] minMaxArray, double averageSentenceLength) {

        for (int i = 0; i < wordLength.length; i++){
            int counter = i+1;
            System.out.println("Word "+ counter + " has " + wordLength[counter-1] + " characters.");
        }
        int sentenceSize = wordLength.length;

        System.out.println("There are " + sentenceSize + " word");
        System.out.println("The longest word has " + minMaxArray[1]);
        System.out.println("The shortest word has " + minMaxArray[0]);
        System.out.println("The average word length is " + averageSentenceLength + " characters.");
    }
    
}
