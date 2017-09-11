
/**
 * Write a description of class part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part2
{
    public int getRank(int year, String name, String gender) {
        int rank = 0;
        int tempRank = 0;
        String fName = "babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fName);
        for (CSVRecord rec: fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender) ) {
                tempRank += 1;
                if (rec.get(0).equals(name) ) {
                    rank = tempRank;
                    break;
                }    
            }
        }
        if (rank == 0) {
            rank = -1;
        }
        return rank;
    }
    public void testGetRank() {
        String name = "Frank";
        String gender = "M";
        int year = 1971;
        int rank = getRank(year,name,gender);
        System.out.println("The name " + name +" is ranked: " + rank);
        
    }
}
