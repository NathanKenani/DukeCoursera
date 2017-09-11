
/**
 * Write a description of class part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class part2
{
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex);
            if (diff % 3 == 0) {
                return currIndex; 
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }

    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";      
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex,minIndex+3);
    }

    public StorageResource getAllGenes(String dna) {
        StorageResource getGenes = new StorageResource();

        int startIndex = 0;

        while (true) {
            String currGene = findGene(dna,startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            getGenes.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return getGenes;   
    }

    public double cgRatio(String dna) {
        StorageResource rat= getAllGenes(dna);
        double ratio = 0;
        for (String g : rat.data()) {
            int cIndex = g.indexOf("C");
            int cCount = 0;
            while (cIndex != -1) {
                cCount++;
                cIndex = g.indexOf("C", cIndex+1);
            }
            int gIndex = g.indexOf("G");
            int gCount = 0;
            while (gIndex != -1) {
                gCount++;
                gIndex = g.indexOf("G", gIndex+1);
            }
            ratio = cCount + gCount;
        }
        return ratio;
    }

    public void testRatio() {
        String dna = "ATGCTGATAAGCAGATAA";       
        double ratio = cgRatio(dna);
        double len = dna.length();
        System.out.println("The cgRatio of the String " + 
            dna + " is: " + ratio/len);

    }

    public int countCTG (String dna) {
        StorageResource rat = getAllGenes(dna);
        int count = 0;
        for (String g : rat.data()) {
            String str = "ctg";
            int startIndex = dna.indexOf(str);
            // int count = 0;
            while (startIndex != -1) {
                count++;
                startIndex = dna.indexOf(str, startIndex+1);

            }
 

        }
        // System.out.println(count);
        return count;
    }

    public void testCountCTG() {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.toLowerCase();
        // int ctg = countCTG(dna);
       // String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        StorageResource gen = getAllGenes(dna);
        
       for (String s: gen.data()) {
            int count = countCTG(s);
            System.out.println("CTG is in the String " + count);
            // String dna = "ATGTTGCTGGAAGTACTGCAGCTGTAG";
            // int count = countCTG(dna);
            // System.out.println("CTG is in the String " +
                // dna + "\n" + count + " times");
        }
    }
}
