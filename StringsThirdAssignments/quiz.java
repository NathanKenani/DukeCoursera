
/**
 * Write a description of class quiz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class quiz
{
   
    public void youtube() {
        
        URLResource page = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        // String you = "youtube";
        for (String s: page.lines()) {
            System.out.println(s);
            // s = s.toLowerCase();
            int pos = s.indexOf("youtube");
            // if ( s.equalsIgnoreCase("y")) {
            if (pos != -1){
                System.out.println(s);
            }
           
            
        }
    }
    public String mystery(String dna) {
        int pos = dna.indexOf("T");
        int count = 0;
        int startPos = 0;
        String newDna = "";
        if (pos == -1) {
            return dna;
        }
        while (count < 3) {
            count += 1;
            newDna = newDna + dna.substring(startPos,pos);
            startPos = pos+1;
            pos = dna.indexOf("T", startPos);
            if (pos == -1) {
                break;
            }
        }
        newDna = newDna + dna.substring(startPos);
        return newDna;
    }
    public void test() {
        String dna = "ATCTGTTCGAGTTT";  
        String gene = mystery(dna);
        System.out.println(gene);
        
    }
    
}
