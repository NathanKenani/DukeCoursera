
/**
 * Lowest humidity in file
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class part3
{
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidity = null;
        for (CSVRecord lowH: parser) {
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
        }
        return lowestHumidity;
    }
    public void testLowestHumidity() {
        FileResource fr = new FileResource();
        CSVRecord humidity = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Lowest humidity was " + humidity.get("Humidity")
        + " at " + humidity.get("DateUTC"));
        
        
    }
}
