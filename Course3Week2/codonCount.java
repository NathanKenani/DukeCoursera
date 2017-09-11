
/**
 * Write a description of class codonCount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class codonCount
{
    private HashMap<String,Integer> map;
    
    public codonCount() {
        map = new HashMap<String, Integer>();
    }
    private void buildCodonMap(int start, String dna) {
        map.clear();
        String str = "";
        // int length = dna.length();
        for (int k = start; k < dna.length(); k+=3){
            str = dna.substring(k,k+3);   
            // System.out.println(str);
            if(map.keySet().contains(str)) {
                map.put(str, map.get(str)+1);
            }
            else {
                map.put(str,1);  
            }
        }
        for (String s: map.keySet()) {
        int num = map.get(s);
            if (num > 0) {
                System.out.println(s + "  "+map.get(s));
            }
        }
        int num = 0;
        for (String w: map.keySet()) {
            num += 1;
        }
        System.out.println("The number of unique coddons is: "+num);   
    }
    private void range(int start, String str) {
        String dna = "";
        int length = str.length();    
        if ((length - start) % 3 != 0) {
            int rem = (str.length() - start) % 3;
            str = str.substring(0,length-rem);
            buildCodonMap(start,str);
            // System.out.println(dna);
        }
        else { 
            buildCodonMap(start,str);
        }
    }
    private void getMostCommonCodon() {
        String most = "";
        int num = 0;
        int max = 0;
        for (String s: map.keySet()) {
            // num = map.get(s);
            if (map.get(s) > num) {
                max = map.get(s);
                num = map.get(s);
                most = s;
            }
        }
        System.out.println("Most common dna is: "+ most + " with count "+max);      
        
    }
    private void printCodonCount(int start, int end) {
        String w = "";
        int count = 0;
        for(String s: map.keySet()) {
            int num = map.get(s);
            if(num >= start && num <= end) {
                System.out.println(s +"  "+map.get(s));
            }
        }
    }
    public void tester() {
       
        int start = 1;
        // String dna = "CGTTCAAGTTCAA";
        FileResource fr = new FileResource("dnaMystery2.txt");
        String dna = fr.asString();
        dna = dna.trim();
        range(start,dna);
        getMostCommonCodon();
        // int starts = 1;
        // int end = 5;
        // System.out.println("Codons between "+starts+" and "+end
                // +" inclusive are:");
        // printCodonCount(1,5);
    }
}
