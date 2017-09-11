
/**
 * Write a description of class quizColdest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class quizColdest
{
    public CSVRecord coldestHourInFile(CSVParser parser){
		
		CSVRecord codestR = null;
		
		for(CSVRecord record : parser){
			
			
			
			double currTemp = Double.parseDouble(record.get("TemperatureF"));
			
			if(currTemp < -100){
				//do nothing
				
			} else if (codestR == null || Double.parseDouble(codestR.get("TemperatureF")) > currTemp ){
				
				codestR = record;
				
			}//end if-else conditions
			
		}
		
		
		return codestR;
	}//end coldestHourInFile() method;
    public void fileWithColdestTemperature (){
		
		System.out.println("\n\n\n");
		System.out.println("****************************************************");
		System.out.println("Part Two: ");
		
		System.out.println("Select the files to find out the codest temperature:");
		
		System.out.println("****************************************************");		
		
		//select the CSV file
		DirectoryResource dr = new DirectoryResource();

		CSVRecord codestR = null;
		File codestF = null;
		
		for( File f : dr.selectedFiles()){
			
			
		//	System.out.println("The codest temperature in file: " + f.getName());
			
			FileResource fr = new FileResource(f);
			CSVParser parse = fr.getCSVParser();
			
			CSVRecord currRecord = coldestHourInFile(parse);
			
			if(codestR == null || Double.parseDouble( currRecord.get("TemperatureF") ) < Double.parseDouble( codestR.get("TemperatureF") )){
				
				codestR = currRecord;
				codestF = f;
			}
			
		}//end for loop;
		
		
		//Printout the name of the File contains the codes temperature, and the temperature.
		System.out.println("\n The codest hour is in File: " + codestF.getName() + ". \nThe temperature is: " + codestR.get("TemperatureF"));
		
		
		//Printout all the temperatures in that file:
		System.out.println("\nAll the Temperatures on the coldest day were: ");
		
		FileResource fr = new FileResource(codestF);
		CSVParser parse = fr.getCSVParser();
		
		for(CSVRecord R : parse){
			
			System.out.println(codestF.getName() + " " + R.get("DateUTC") + "  " + R.get("TemperatureF") );
		}
		
		//String file_name = f;
		//get the CSV data table
		//
		
		
	}//end fileWithColdestTemperature() method;
}
