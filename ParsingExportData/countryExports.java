
/**
 * Write a description of class countryExports here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class countryExports
{
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        // countryInfo(parser, "Nauru");
        // parser = fr.getCSVParser();
        // listExportersTwoProducts(parser, "cotton", "flowers");
        // parser = fr.getCSVParser();
        // numberOfExporters(parser,"cocoa");
        // parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
        parser = fr.getCSVParser();
        
       
        
    }
    public void countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String info = record.get("Country");
            if (info.contains(country)) {
                System.out.print(info + ": ");
                String exports = record.get("Exports");
                System.out.print(exports + ": ");
                String value = record.get("Value (dollars)");
                System.out.println(value);
                break;
                // continue;
            }
            else {
                // continue;
                System.out.println("NOT FOUND");      
            }
            
        }       
    }
    public void listExportersTwoProducts(CSVParser parser, String item1, String item2) {
        for (CSVRecord record: parser) {
            String export = record.get("Exports");
            if (export.contains(item1) && export.contains(item2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }            
    }
    public void numberOfExporters(CSVParser parser, String exportItem) {
        int num = 0;
        for (CSVRecord record: parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                String country = record.get("Country");
                num += 1; 
                // System.out.println(num);
                
            }
          
        }
        System.out.println(num);
    }
    public void bigExporters (CSVParser parser, String amount) {
        for (CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println(country + ": " + value);
            }
        }
    }
}
