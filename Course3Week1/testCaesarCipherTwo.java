
/**
 * Write a description of class testCaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class testCaesarCipherTwo
{
   public String halfOfString(String input, int start) {
       String half = "";
       for (int k = start; k < input.length(); k +=2) {
           char ch = Character.toLowerCase(input.charAt(k));
           half += Character.toString(ch);
       }
       return half;
   }
   public int[] countLetters(String input) {
       int[] counts = new int[26];
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
       for(int k = 0; k < input.length(); k++) {
            char ch = Character.toLowerCase(input.charAt(k));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index] += 1;
            }
       }
       return counts;
    }
    public int maxIndex(int[] vals) {
        int max = 0;
        int maxPos = vals[0];
        for (int k = 0; k < vals.length; k++) {
            if (vals[k] > maxPos) {
                max = k;
                maxPos = vals[k];
            }
        }
        // System.out.println("The max is: " + max);
        return max;
    }
    public int getKey(String input) {
        int[] freq = countLetters(input);
        int max = maxIndex(freq);
        int dKey = max - 4;
        if (max < 4) {
            dKey = 26 - (4 - max);
        }
        return dKey;
    }
    public String breakCaesarCipherTwo(String input) {
       
        String msg1 = halfOfString(input,0);
        String msg2 = halfOfString(input,1);
        
        int key1 = getKey(msg1);
        int key2 = getKey(msg2);
        
        System.out.println("Keys found are : " + key1  + "  " + key2);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26-key1, 26-key2);   
        String answer = cc2.decrypt(input);
        
        return answer;
    }
    public void simpleTest() {
        // FileResource fr = new FileResource("wordsLotsOfEs.txt");
        // String input = fr.asString();
        String input = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        // input = input.toLowerCase();
        // CaesarCipherTwo cc2 = new CaesarCipherTwo(21,8);
        // String encry = cc2.encrypt(input);
        // String decry = cc2.decrypt(encry);
        // System.out.println("The encrypted message is: \n" + encry);
        // System.out.println("\nThe decrypted message is: \n" + decry);
        // String name = breakCaesarCipherTwo(encry);
        // System.out.println("The answer is: \n" + name);
        
        String name = breakCaesarCipherTwo(input);
        System.out.println("The answer is: \n" + name);
    }
}
