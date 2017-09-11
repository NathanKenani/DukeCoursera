
/**
 * Write a description of class part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class part1
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
   
    public void printAllGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene,startIndex)
            + currGene.length();
        }
    }
    public void testPrint() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        System.out.println("Testing print all gene" + dna);
        printAllGenes(dna);
        
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        System.out.println("Testing print all genes: " + dna);
        printAllGenes(dna);
        
        
    }
    
}
