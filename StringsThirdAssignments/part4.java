/**
 * Find all the genes from a DNA string file and using StorageResource class.
 * 
 * @author (Elvis Morales) 
 * @version (1.0)
 */

import edu.duke.*;
import java.io.File;

public class part4 {
    
    public int findStopIndex(String dna, int index) {
        int taaIndex = dna.indexOf("taa", index);
        if (taaIndex == -1 || (taaIndex - index) % 3 != 0) {
            taaIndex = dna.length();
            // dna.length()
        }
        int tagIndex = dna.indexOf("tag", index);
        if (tagIndex == -1 || (tagIndex - index) % 3 != 0) {
            tagIndex = dna.length();
        }
        int tgaIndex = dna.indexOf("tga", index);
        if (tgaIndex == -1 || (tgaIndex - index) % 3 != 0) {
            tgaIndex = dna.length();
        }
        return Math.min(Math.min(taaIndex, tagIndex), tgaIndex);
       
    }
    public StorageResource storeAll(String dna) {
        dna = dna.toLowerCase();
        int start = 0;
        StorageResource genes = new StorageResource();
        while (true) {
            int startIndex = dna.indexOf("atg", start);
            if (startIndex == -1) {
                break;
            }
            int stopIndex = findStopIndex(dna,startIndex+3);
      
            if (stopIndex != dna.length() ) {
                genes.add(dna.substring(startIndex,stopIndex+3));
                start = stopIndex + 3;
            }
            else {
                start = startIndex + 3;
            }
            
        }
        return genes;
        
    }
    public double cgRatio (String dna) {
        dna = dna.toLowerCase();
        // double ratio = 0.0;
        int startIndex = 0;
        int cgCount = 0;
        // int gCount = 0;
        while (true) {
            int cIndex =  dna.indexOf("c", startIndex);
            if (cIndex == -1) {
                startIndex = 0;
                break;
            }
            cgCount += 1;
            startIndex = cIndex + 1;
        }
        while (true) {
            int gIndex = dna.indexOf("g", startIndex);
            if (gIndex == -1) {
                startIndex = 0;
                break;
            }
            cgCount += 1;
            startIndex = gIndex + 1;
        }
        return ( (double) cgCount) / dna.length();
  
    }
    public void printGenes(StorageResource sr) {
        int sixtyCharQ = 0;
        int highcgRatioQ = 0;
        double cgRat = (double)0.35;
        int genes = 0;
        
        for (String s : sr.data()) {
            // if (s.length() > 9) {
                // System.out.println("Strings longer than 9 characters are: " + s);
                // genes++;
            // }
            if (s.length() > 60) {
                System.out.println("String longer than 60 characters is: " 
                + s);
                sixtyCharQ++;
            }
            
            if (cgRatio(s) > cgRat ) {
                System.out.println("String with C-G ratio higher than 0.35 is: "
                + s);
                highcgRatioQ++;
            }
            
        }
        System.out.println("9 Character strings: " + genes);
        System.out.println("60 character qty: " + sixtyCharQ);
        System.out.println("C-G ratio higher than 0.35: " + highcgRatioQ);
    }
    public void testStore() {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        // dna.toUpperCase();
        // System.out.println(dna);
        StorageResource genesFound = storeAll(dna);
        System.out.println("Number of genes found: " + genesFound.size());
        printGenes(genesFound);        
    }
}