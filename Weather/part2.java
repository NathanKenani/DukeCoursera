
/**
 * Write a description of class part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part2
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
    public File fileWithColdestTemperature() {
        CSVRecord coldestSoFar = null;
        File name = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) { 
            // String name = f.getName();
            FileResource fr = new FileResource(f);
            
            CSVRecord cold = coldestHourInData(fr.getCSVParser());
            double currentCold = Double.parseDouble(cold.get("TemperatureF"));
            double veryCold = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if (coldestSoFar == null || currentCold < veryCold) {
                coldestSoFar = cold;
                name = f;
            // if (coldestSoFar == null) {
                // coldestSoFar = cold;
            }
            // else {
                // double currentCold = Double.parseDouble(cold.get("TemperatureF"));
                // double veryCold = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                // if (currentCold < veryCold && currentCold != -9999) {
                    // coldestSoFar =  cold;
                    // name = f.getName();
                // }
            // }
            
        }
        // System.out.println(name);
        return name;
        
    }
    
    public void testFileWithColdest() {
       File fname = fileWithColdestTemperature();
       System.out.println("Coldest day was in file " + fname);
       FileResource fr = new FileResource();
       CSVRecord coldest = coldestHourInData(fr.getCSVParser());
       System.out.println("Coldest temperature on that day was " + coldest.get("TemperatureF"));
       System.out.println("All temperatures on the coldest day were: ");
       for (CSVRecord cold: fr.getCSVParser()) {
           System.out.println(cold.get("DateUTC") + ": " + cold.get("TemperatureF"));
        }
        
    }
}
