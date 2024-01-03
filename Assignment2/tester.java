import java.util.Arrays;

public class tester {
    public static void main(String[] args) {
        String word = "my quiz2 was graded";
        String[] wordarr = word.split(" ");

        int[] counter = individualWordLength(wordarr);

        for (int e: counter){
            System.out.println(e);
        }
    }   



    public static int[] individualWordLength(String[] wordArr){
        int[] wordCounter = new int[wordArr.length];

        for (int i= 0; i < wordArr.length; i++){
            String word = wordArr[i];
            wordCounter[i] = word.length();
            
        }
        return wordCounter;
    }
    public static int[] getMinAndMax(int[] arr){
        int[] copyArr = new int[arr.length];
        
        for (int i =0; i < arr.length; i++){
            copyArr[i] = arr[i];
        }

        Arrays.sort(copyArr);

        int[] minMax = {copyArr[0], copyArr[copyArr.length-1]};
        return minMax;
    }

    public static int[] getMinAndMax2(int[] arr){
        Arrays.sort(arr);
         int[] minMax = {arr[0], arr[arr.length-1]};
        return minMax;
    }
}
