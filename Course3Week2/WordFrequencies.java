
/**
 * Write a description of class WordFrequencies here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for (String s: fr.words()) {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int pos = myFreqs.get(index);
                myFreqs.set(index,pos+1);
            }
        }
    }
    public int findIndexOfMax() {
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for (int k = 0; k < myFreqs.size(); k++) {
            if (myFreqs.get(k) > max) {
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
                
    public void tester() {
        findUnique();
        System.out.println("# of unique words: " + myWords.size());
        for(int k =0; k < myWords.size(); k++) {
            if (myFreqs.get(k) > 100) {
                System.out.println(myFreqs.get(k) + "  " +  myWords.get(k));
            }
        }
        int max = findIndexOfMax();
        if (max > 10) { 
            System.out.println("The word that occurs most often and its count are: " +
            myWords.get(max) + "  " + myFreqs.get(max));
        }
    }      
}
