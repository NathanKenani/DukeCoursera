
/**
 * Write a description of class part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
// import java.io.*;
public class part3
{
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon,startIndex+3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                // System.out.println(currIndex);
                return currIndex; 
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }

    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("atg", where);
        if (startIndex == -1) {
            return "";      
        }
        int taaIndex = findStopCodon(dna,startIndex,"taa");
        int tagIndex = findStopCodon(dna,startIndex,"tag");
        int tgaIndex = findStopCodon(dna,startIndex,"tga");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        // if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            // minIndex = tgaIndex;
        // }
        // else {
            // minIndex = taaIndex;
        // }
        // if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            // minIndex = tagIndex;
        // }
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(startIndex,minIndex + 3);
    }

    public StorageResource getAllGenes(String dna) {
        StorageResource getGenes = new StorageResource();
        int startIndex = 0;

        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            getGenes.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        // System.out.println(getGenes);
        return getGenes;   
    }
    public double cgRatio(String dna) {
        StorageResource rat = getAllGenes(dna);
        // double ratio;
        int cgCount = 0;
  
        for (String g : rat.data()) {
            int cIndex = g.indexOf("c");
         
            while (cIndex != -1) {
                cgCount++;
                cIndex = g.indexOf("c", cIndex+1);
            }
            int gIndex = g.indexOf("g");
           
            while (gIndex != -1) {
                cgCount++;
                gIndex = g.indexOf("g", gIndex+1);
            }
            
          
        }
        return ( (double) cgCount) / dna.length();
    }
    public int ctgCount (String dna) {
        dna = dna.toLowerCase();
        StorageResource ctg = getAllGenes(dna);
        int ctgCount = 0;
        // int num = 0;
        
        for (String s: ctg.data()) {
            int ctgIndex = s.indexOf("ctg");
            int diff = ctgIndex - 0;
            while (ctgIndex != -1 && diff % 3 == 0) {
                ctgCount++;
                ctgIndex = s.indexOf("ctg", ctgIndex+1);
            }
            
        }
        // System.out.println(ctgCount);
        return ctgCount;
    }
    public int largest(String dna) {
           StorageResource max = getAllGenes(dna);
           int count = 0;
           for (String d: max.data()) {
               if (d.length() > 60) {
                   count = d.length();
               }
           }
           return count;
            
    }
    // This method processes all strings in sr to find info
    public void processGenes(StorageResource sr) {
        // FileResource fr = new FileResource("brca1line.fa");
        // String dna = fr.asString();
        // dna.toUpperCase();
        // sr = getAllGenes(dna);
     
        int sixtyChar = 0;
        double cgRat = (double) 0.35;
        int nineChar = 0;
        int highCG = 0;
        int max = 0;
        int ctg = 0;
        
        
     
        // print all strings in sr longer than 9 chars
        for (String g : sr.data()) {
            int len = g.length();
            if (len > 9)  {
              // if (g.length() > 9) { 
                // System.out.println(g);
           
                nineChar += 1;
            }
            if (len > 60) {
                sixtyChar++;
            }
            if (cgRatio(g) > cgRat) {
                highCG++;
            }
            if (len > 60) {
                max = len;
            }
            if (ctgCount(g) > 0) {
                ctg = ctgCount(g);
            }
            // System.out.println(g);
        } 
        
    // print num of strings longer than 9 chars
        System.out.println(nineChar + " String(s) have more than 9 characters");
        System.out.println(sixtyChar + " String(s) have more than 60 characters");
        System.out.println(highCG + " Strings have more than 0.35 ratio" );
        // System.out.println(ctg + " String have a ctg ");
        System.out.println(max + " is the length of the largest dna");
    }
    public void testProcessGenes() {
       FileResource fr = new FileResource();
       String dna = fr.asString();
       dna = dna.toLowerCase();
       // String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
       StorageResource gen = getAllGenes(dna);
       System.out.println("There are: " + gen.size() + " genes");
       processGenes(gen);
       System.out.println(ctgCount(dna));
       
       // System.out.println(largest(dna) + " Is the length of the largest dna");
      
       // String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
       // StorageResource gen = getAllGenes(dna);
       // for(String g : gen.data()) {
           // System.out.println(g);
       // }
       
    }  
    
    
    
}
