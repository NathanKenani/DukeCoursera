
/**
 * Write a description of class wordsInFile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;
public class wordsInFile
{
    private HashMap <String,ArrayList<String>> map;
    // private ArrayList<String> words;
    public wordsInFile() {
        map = new HashMap <String, ArrayList<String>>();
        // words = new ArrayList<String>();
        
    }
    private void addWordsFromFile(File f) {
        // DirectoryResource dr = new DirectoryResource();
        // for (f: dr.selectedFiles()) {
        String fName = f.getName();
        FileResource fr = new FileResource(f);
        
        for(String w: fr.words()) {
            w = w.toLowerCase();
           
            if (map.containsKey(w)) {
                // words.add(w);
                ArrayList<String> words = map.get(w);
                // ArrayList<String> words = new ArrayList<String>();
                if(!words.contains(fName)){
                    words.add(fName);
                }
                    // map.put(w,words);
                // map.get(w).add(fName);
            }
            else {
                ArrayList<String> array = new ArrayList<String>();
                array.add(fName);
              map.put(w,array);
                
            }
        }
    } 
    public void buildWordFileMap() {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }
    private int maxNumber() {
        int num = 0;
        int max = 0;
        for(String w: map.keySet()) {
            w = w.toLowerCase();
            num = map.get(w).size();
            if(max < num) {
                max = num;
            }
        }
        // System.out.println(max);
        return max;
    }
    private ArrayList<String> wordsInNumFiles(int num) {
        int numFiles = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (String word: map.keySet()) {
            ArrayList<String> curr = map.get(word);
            numFiles = curr.size();
            // System.out.println(map.get(word).size()); 
            if (numFiles == num) {
                char ch = word.charAt(word.length()-1);
                if (Character.isLetter(ch)) {
                    list.add(word);   
                }
            }
        }
        return list;
    }
    private void printFilesIn(String word) {
        // String name = "";
        // ArrayList<String> wr= new ArrayList<String>();
        for (String w: map.keySet()) {
            if (w.equals(word)) {
                for(String str: map.get(w)) {
                     System.out.println(str);       
                }
            }
        }
        // System.out.println(wr);
    }
    public void tester() {
        buildWordFileMap();
        int great = maxNumber();
        System.out.println("The max number of files any word is in: " 
        + great);
        
        ArrayList<String> words = wordsInNumFiles(great);
        System.out.println("Total words in files: "+words.size());
        
        int num = 7;
        ArrayList<String> find = wordsInNumFiles(7);
        // find = wordsInNumFiles(7);
        System.out.println("Words in " +num+" files are: "+ find);
        System.out.println("The number of words is: "+find.size());
        for (int k =0; k <find.size();k++) {
            // System.out.println(find.get(k)+" "); 
        }
        String str = "laid";
        printFilesIn(str);
    }
}
