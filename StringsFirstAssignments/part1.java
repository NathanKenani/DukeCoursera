
/**
 * Write a description of class part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class part1
{
    public String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        while (stopIndex != -1) {
    
            int diff = (stopIndex - startIndex) % 3;
            if (diff == 0) {
                return dna.substring(startIndex, stopIndex+3);
            }
            else {
                stopIndex = dna.indexOf("TAA", startIndex+1);
            }
        }
        return "";
            
    }
    public void testFindGeneSimple() {
        //             v  v  v  v  v
        String dna = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //       v  v  v  v  v  v  v  v
        dna = "CGATGGTTGATAAGCCTAAGCTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //       v  v  v  v  v  v  v  v
        dna = "CGATGGTTGATAAGCCTAAGCTAAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }
    
}
