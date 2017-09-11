
/**
 * Write a description of class part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part1
{
    public CSVRecord coldestHourInData(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord cold: parser) {
            if (coldestSoFar == null) {
                coldestSoFar = cold;
            }
            else {
                double currentCold = Double.parseDouble(cold.get("TemperatureF"));
                double veryCold = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currentCold < veryCold && currentCold != -9999) {
                    coldestSoFar =  cold;
                }
            }
        }
        return coldestSoFar;
    }
    public void testColdestHour() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord rec = coldestHourInData(parser);
        System.out.println("Coldest hour is : " + rec.get("TemperatureF") + 
        " at " + rec.get("TimeEDT"));
        
    }
  
}
