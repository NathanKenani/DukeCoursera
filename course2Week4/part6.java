
/**
 * Write a description of class part6 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part6
{
    public int getRank(int year, String name, String gender) {
        int rank = 0;
        int tRank = 0;
        String fileName = "babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(fileName);
        for (CSVRecord rec: fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender) ) {
                rank += 1;
                if (rec.get(0).equals(name) ) {
                    tRank = rank;
                    break;
                }    
            }
        }
        // rank = -1;       
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
    public double averageRank(String name, String gender) {
        double avgRank = 0;
        int rank = -1;
        int size = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String fName = f.getName().substring(3,7);
            int year = Integer.parseInt(fName);
            for(CSVRecord rec: fr.getCSVParser(false)) {
                size = rec.size();
                int tempRank = getRank(year, name, gender);
                if (tempRank != -1){
                    rank = tempRank;
                    rank += tempRank;
                    avgRank = rank + tempRank;
                    // System.out.println(rank);
                }
                else {
                    return -1;
                }
          
            }     
        }
        // System.out.println(rank);
        return avgRank / size;
        
    }
    public void test() {
        String name = "Susan";
        String gender = "F";
        Double average = averageRank(name,gender);
        System.out.println("The average rank for the name "+
        name + " is: " + average);
    }
}
