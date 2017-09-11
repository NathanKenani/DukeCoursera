
/**
 * Write a description of class part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part4
{
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidity = null;
        for (CSVRecord lowH: parser) {
            lowestHumidity = lowestHumidityOfTwo(lowH, lowestHumidity);
        }
        return lowestHumidity;
    }

    public CSVRecord lowestHumidityInMany() {
        CSVRecord lowestHumidity = null;
        
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord lowH = lowestHumidityInFile(fr.getCSVParser());
            lowestHumidity = lowestHumidityOfTwo(lowH, lowestHumidity);
        }
        return lowestHumidity;
        
    }
    public CSVRecord lowestHumidityOfTwo(CSVRecord lowH, CSVRecord lowestHumidity) {
        if (lowestHumidity == null ) {
            lowestHumidity = lowH;
        }
        else {
            int currHumidity = Integer.parseInt(lowH.get("Humidity"));
            int lowHumidity = Integer.parseInt(lowestHumidity.get("Humidity"));
            if (currHumidity < lowHumidity) {
                lowestHumidity = lowH;
            }
        }
        return lowestHumidity;
    }
    
     public void testLowestHumidity() {
        // FileResource fr = new FileResource();
        CSVRecord humidity = lowestHumidityInMany();
        
        System.out.println("Lowest humidity was " + humidity.get("Humidity")
        + " at " + humidity.get("DateUTC"));   
    }
}
