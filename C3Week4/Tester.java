
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Tester
{
    public void testCaesarCipher() {
        CaesarCipher cc = new CaesarCipher(7);
        FileResource fr = new FileResource("titus-small.txt");
        String input = fr.asString();
        System.out.println(cc.encrypt(input));
        System.out.println(cc.decrypt(input));
       
    }
    public void testCaesarCracker() {
        CaesarCracker cc = new CaesarCracker();
        FileResource fr = new FileResource("athens_keyflute.txt");
        String input = fr.asString();
        System.out.println(cc.decrypt(input));
       
        int key = cc.getKey(input);
        System.out.println(key);
       
      
    }
    public void testVigenereCipher() {
        int[] key = {17,14,12,4};
        VigenereCipher vc = new VigenereCipher(key);
        FileResource fr = new FileResource("titus-small.txt");
        String input = fr.asString();
        System.out.println(vc.encrypt(input));
    }
        
}
