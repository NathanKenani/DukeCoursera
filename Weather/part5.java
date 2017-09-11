
/**
 * Write a description of class part5 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part5
{
     public double averageTemperatureInFile(CSVParser parser) {
         double avgTemp = 0.0;
         double storeTemp = 0.0;
         int count = 0; 
         // CSVRecord temperature = null;
         for (CSVRecord averageTemp: parser) {
             String getTemp = averageTemp.get("TemperatureF");
        
             // System.out.println(count);
             double doubleTemp = Double.parseDouble(getTemp);
             storeTemp += doubleTemp;
             if (storeTemp >= doubleTemp) {
                 count++;
                 System.out.println(count);
             }
            
             avgTemp = storeTemp / count;
         }
         return avgTemp;  
     }
     public void testAverageTemperature() {
         FileResource fr = new FileResource();
         CSVParser parser = fr.getCSVParser();
         double avgTemperature = averageTemperatureInFile(parser);
         System.out.println("Average temperature in file is " + avgTemperature);
         
        }
}
