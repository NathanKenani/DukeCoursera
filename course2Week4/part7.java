
/**
 * Write a description of class part7 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part7
{
    public int getRank(int year, String name, String gender) {
        int rank = 0;
        int tempRank = 0;
        String fName = "babynames/us_babynames_by_year/yob"+year+".csv";
        
        FileResource fr = new FileResource(fName);
        for (CSVRecord rec: fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                tempRank += 1;
                if (rec.get(0).equals(name)) {
                    rank = tempRank;
                    break;
                }
            }
        }
        if (rank == 0){
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
    public int totalBirthsRankedHigher(int year,String name,String gender) {
        int totalBirths = 0;
        int rank = 0;
        int tempRank = 0;
        String fName = "babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fName); 
        rank = getRank(year,name,gender);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)) {
                tempRank += 1;
                if (tempRank < rank) {
                    totalBirths += Integer.parseInt(rec.get(2));
                }
            }
        }
        return totalBirths;
        
    }
    public void test() {
        String name = "Emily";
        String gender = "F";
        int year = 1990;
        int births = totalBirthsRankedHigher(year,name,gender);
        System.out.println("The total births ranked higher: " + births);
    }
}
