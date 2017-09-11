
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
     public double averageTemperatureWithHighHumidity(CSVParser parser, int value) {
        double avgTemp = 0.0;
        int count = 0;
        for (CSVRecord humid: parser) {
             int getHumid = Integer.parseInt(humid.get("Humidity"));
             if (getHumid >= value) {
                 count++;
                 double getTemp = Double.parseDouble(humid.get("TemperatureF"));
                 avgTemp += getTemp;
                 // System.out.println(avgTemp); 
                 // System.out.println(count); 
             }
             if (count == 0){ 
                 System.out.println("No temperature with that humidity");
                 break;
             }
                
        }
        return avgTemp / count;
    }
    public void testAverageTemperatureWithHighHumid() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureWithHighHumidity(parser, 80);
        System.out.println("Average Temp when high humidity is " + averageTemp);
    }
}
