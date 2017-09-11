
/**
 * Write a description of class part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class part4
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
        String filename = "babynames/us_babynames_by_year/yob"+year+".csv";
        int nRank = 0;
        FileResource fr = new FileResource(filename);
        for (CSVRecord rec: fr.getCSVParser(false)) {
            nRank = getRank(year, rec.get(0), gender);
            if (rec.get(1).equals(gender) ) {
                if (nRank == rank) {
                    name = rec.get(0);
                    break;
                } 
            }
        }
        return name;
    }
    public void whatIsNameInYear(String name,int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " born in " + year + " Would be " +
       newName + " if she was born in 2014");
    }
    public void test() {
        String name = "Owen";
        int year = 1974;
        int newYear = 2014;
        String gender = "M";
        whatIsNameInYear(name,year,newYear,gender);
    }
       
}
