import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sliced = new StringBuilder();
        for (int k = whichSlice; k < message.length(); k += totalSlices) {
            sliced.append(message.charAt(k));
        }
        return sliced.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker(mostCommon);
        for (int i =0; i < klength; i++) {
            String sliced = sliceString(encrypted, i, klength);
            key[i] = cc.getKey(sliced);
        } 
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    } 
    public void test() {
        String sliced = sliceString("abcdefghijklm",4,5);
        System.out.println(sliced);
        
        FileResource fr = new FileResource("athens_keyflute.txt");
        String input = fr.asString();
        int[] key = tryKeyLength(input,5,'e');
        System.out.println(Arrays.toString(key));
        
        
    }
}
