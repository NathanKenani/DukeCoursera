
/**
 * Write a description of class CharactersInPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay
{
    private ArrayList<String> characters;
    private ArrayList<Integer> counts;
    public CharactersInPlay() {
        characters = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    public void update(String person) {
        person = person.trim();
        int index = characters.indexOf(person);
        if (index == -1) {
            characters.add(person);
            counts.add(1);    
        }
        else {
            int pos = counts.get(index);
            counts.set(index,pos+1);
        }
        // for (int s: counts) {
            // System.out.println(s);
        // }
    }
    public void findAllCharacters() {
        characters.clear();
        counts.clear();
        int count = 0;
        String name = "";
        FileResource fr = new FileResource();
        for (String s: fr.lines()) {
            s = s.toUpperCase();
            int index = s.indexOf(".");
            int length = s.length();
            // count += 1;
            if (index != -1 ) {
                name = s.substring(0,index).trim();
                update(name);
                
            }
        }
        // System.out.println(count);
    }
    public void tester() {
        int num1 = 10;
        int num2 = 200;
        CharactersWithNumParts(num1,num2);
        int max = findMax();
        System.out.println("Character with most speaking parts are: " 
          + counts.get(max)+"  "+characters.get(max));
        
    }
    public void CharactersWithNumParts(int num1, int num2) {
        findAllCharacters();
        for (int k = 0; k < characters.size();k++) {
            if (counts.get(k) >= num1 && counts.get(k) <= num2) {
                System.out.println(characters.get(k) +"   "+ counts.get(k));
            }
        }
  
    }
    public int findMax() {
        int max = counts.get(0);
        int most = 0;
        for (int k = 0; k < counts.size();k++) {
            if (counts.get(k) > max) {
                max = counts.get(k);
                most = k;   
            }
        }
        return most;
    }
}
