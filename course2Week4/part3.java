
/**
 * Write a description of class part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part3
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
    public String getName(int year, int rank, String gender) {
        String name = "";
        int nRank = 0;
        String fName = "babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fName);
        for (CSVRecord rec: fr.getCSVParser(false)) {
            nRank = getRank(year, rec.get(0), gender);
            if (rec.get(1).equals(gender) ) {
                if (nRank == rank) {
                    name = rec.get(0);
                    break;
                } 
            }
        }
        if (name.isEmpty()) {
            name = "NO NAME";
        }
        return name;
    }
    public void testGetName() {
        int year = 1982;
        int rank = 450;
        String gender ="M";
        String name = getName(year,rank,gender);
        System.out.println("The name ranked at " + rank +
        " is: " + name);
    }
}
