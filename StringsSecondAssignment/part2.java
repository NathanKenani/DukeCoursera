
/**
 * Write a description of class part2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class part2
{
    public int howMany(String stringa, String stringb) {
        int currIndex = stringb.indexOf(stringa);
        int count = 0;
        while (currIndex != -1) {
            int len = stringa.length();
            if (stringb.isEmpty()) {
                break;
            }
           
            count++;
            currIndex = stringb.indexOf(stringa,currIndex+len);
        }
        return count;
    }    
    public void test() {
        String stringa = "A";
        String stringb = "ATGAACGAATTGAATC";
        int num = howMany(stringa,stringb);
        System.out.println(stringa + " is in "
        + stringb + ": " + num + " times");
    }
}
