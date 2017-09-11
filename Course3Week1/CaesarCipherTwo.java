
/**
 * Write a description of class CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo
{
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < sb.length(); i += 2) {
            char ch = Character.toLowerCase(sb.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                char newCh = shiftedAlphabet1.charAt(index);
                sb.setCharAt(i,newCh);
            }
        }
        for (int k = 1; k < sb.length(); k += 2) {
            char ch = Character.toLowerCase(sb.charAt(k));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                char newCh = shiftedAlphabet2.charAt(index);
                sb.setCharAt(k, newCh);
            }
        }
        return sb.toString(); 
    }
    public String decrypt(String input) {
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cc2.encrypt(input);
    }
}
