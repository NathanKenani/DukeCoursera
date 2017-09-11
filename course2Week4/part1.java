
/**
 * Write a description of class part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part1
{
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        int girlNames = 0;
        int boyNames = 0;
        int totalNames = 0;
     
        for (CSVRecord rec: fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            String gender = rec.get(1);
            if (gender.equals("F")) {
                totalGirls += numBorn;
                girlNames += 1;
            }
            else {
                totalBoys += numBorn;
                boyNames += 1;
                
            }
        }
        System.out.println("The total number of girls born is: " + totalGirls);      
        System.out.println("The total number of boys born is: " + totalBoys);
        System.out.println("The total number of births is: " + (totalGirls+totalBoys));
        System.out.println("The number of girl names is: " + girlNames);
        System.out.println("The number of boy names is: " + boyNames);
        System.out.println("The total number of names is: " + (girlNames+boyNames));
    }
    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
}
