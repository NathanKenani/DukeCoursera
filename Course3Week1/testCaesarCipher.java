
/**
 * Write a description of class testCaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class testCaesarCipher
{
    private int[] countLetters(String input) {
        int [] counts = new int [26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < input.length(); i++ ) {
            char ch = Character.toLowerCase(input.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index] += 1;
            }
        }
        // System.out.println(counts[2]);
        return counts;
    } 
    private int maxIndex(int[] vals) {
        int max = 0;
        int maxPos = vals[0];
        for ( int k = 1; k < vals.length; k++){
            if (vals[k] > maxPos) {
                max = k;
                maxPos = vals[k];
            }
        }
        // System.out.println(max);
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
    public String breakCaesarCipher(String input) {
        int keyFound = getKey(input);
        System.out.println("The key found is: "+ keyFound);
        CaesarCipher cc = new CaesarCipher(26 - keyFound);
        String answer = cc.encrypt(input);
        //System.out.println(answer);
      
        return answer;
    }
    public void simpleTest() {
       // FileResource fr = new FileResource("smallHamlet.txt");
       // String input = fr.asString();
       String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
       input = input.toLowerCase();
       CaesarCipher cc = new CaesarCipher(15);
       String encry = cc.encrypt(input);
       String decry = cc.decrypt(encry);
       System.out.println("The encrypted message is: \n" + encry);
       System.out.println("\nThe decrypted message is: \n" + decry);
       String answer = breakCaesarCipher(encry);
       System.out.println("answer is: \n" + answer);

    }
    
}
