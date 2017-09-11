
/**
 * encrypt and decrypt using a Caesar Cipher
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key) {
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for ( int k = 0; k< sb.length(); k++) {
            char ch = Character.toLowerCase(sb.charAt(k));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                char newCh = shiftedAlphabet.charAt(index);
                sb.setCharAt(k, newCh);
            }
        }
        return sb.toString();
    }
    public String decrypt (String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
        
        
}
