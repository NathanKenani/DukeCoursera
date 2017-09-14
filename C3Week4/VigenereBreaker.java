import java.util.*;
import edu.duke.*;
import java.io.*;

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
        // Tester for all classes and methods
        FileResource fr = new FileResource("secretmessage3.txt");
        String input = fr.asString();
        DirectoryResource dr = new DirectoryResource();
        HashMap<String, HashSet<String>> maps = new HashMap<String, HashSet<String>>();
        for (File f: dr.selectedFiles()) {
            FileResource newfr = new FileResource(f);
            maps.put(f.getName(),readDictionary(newfr));
            System.out.println(f.getName()+" language is used \n");
        }
        breakForAllLangs(input,maps);
        // int [] key = tryKeyLength(input, k, 'e');
        // System.out.println("The key is: \t"+Arrays.toString(key)+"\n");
        // // System.out.println("\nEncrypted message is: \n"+input+"\n");
        // VigenereCipher vc = new VigenereCipher(key);
        // String answer = vc.decrypt(input);
        // System.out.println("The decrypted message is: \n"+answer);
        
    }
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> dict = new HashSet<String>();
        for (String word: fr.lines()) {
            word = word.toLowerCase();
            dict.add(word);
        }
        return dict;
    }
    public int countWords(String message, HashSet<String> dictionary) {
        int count = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (String msg : message.split("\\W+")) {
            msg = msg.toLowerCase();
            if (dictionary.contains(msg)) {
                count += 1;
            }
        }
        return count;
    }
    public String breakForLanguage(String encrypted, HashSet<String>dictionary) {
        int max = 0;
        int count = 0;
        int num = 0;
        String answer = "";
        char c = mostCommonCharIn(dictionary);
        for (int k = 1; k <= 100;k++ ) {
            int[] key = tryKeyLength(encrypted,k,c);
            VigenereCipher vc = new VigenereCipher(key);
            String msg = vc.decrypt(encrypted);
            count = countWords(msg,dictionary);
            if ( count > max) {
                // num = k;
                max = count;
            } 
        }
        for (int i = 1; i<=100; i++) {
            int[] key = tryKeyLength(encrypted,i,c);
            VigenereCipher vc = new VigenereCipher(key);
            String msg = vc.decrypt(encrypted);
            count = countWords(msg,dictionary);
            if (count == max) {
                num = i;
                System.out.println("The key is: "+num);
                System.out.println("number of valid words: "+count);
                return msg;
            }
        }
        return null;

    }
    public char mostCommonCharIn(HashSet<String> dictionary) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        
        for (String s: dictionary) {
            String words = s.toLowerCase();
            for (char c: words.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c,map.get(c) +1);
                }
                else {
                    map.put(c,1);
                }
            }
        }
        int count = 0;
        for (char c: map.keySet()) {
            if (map.get(c) > count) {
                count = map.get(c);
            }
        }
        for (char c: map.keySet()) {
            if (map.get(c) == count) {
                return c;
            }
        }
        return 'n';
    
    }
    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages) {
        int num = 0;
        String lang ="";
        String str ="";
        for (String language: languages.keySet()) {
            str = breakForLanguage(encrypted,languages.get(language));
            int count = countWords(str,languages.get(language));
            if (count > num) {
                num = count;
            }
        }
        for (String language: languages.keySet()) {
            str = breakForLanguage(encrypted, languages.get(language));
            int count = countWords(str,languages.get(language));
            if (count == num) {
                lang = language;
                // System.out.println("Language used is: "+language+"\n"+str);
            }
        }
        System.out.println("Language used is: "+lang+"\n"+str);
    }
}
