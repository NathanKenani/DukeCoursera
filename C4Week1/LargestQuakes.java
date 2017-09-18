
/**
 * Write a description of class LargestQuakes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class LargestQuakes
{
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("# quakes read: "+list.size());
        // for (QuakeEntry qe : list) {
            // System.out.println(qe);
        // }
        // int index = indexOfLargest(list);
        // System.out.println(index + " has largest magnitude ");
        // System.out.println(list.get(index));
        ArrayList<QuakeEntry> quake = getLargest(list, 5);
        for (QuakeEntry qe : quake) {
            System.out.println(qe);
        }
    }
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int index = 0;
        double largest = 0.0;
        for (QuakeEntry qe : data) {
            double mag = qe.getMagnitude();
            if (mag > largest) {
                largest = mag;
                
            }
            if (mag == largest) {
                // System.out.println(qe);
                index = data.indexOf(qe);
                
                
            }
        }
        // System.out.println(data.get(index));
        return index;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        int index = 0;
        for (int k = 0; k < howMany; k++) {
            index = indexOfLargest(copy);
            ret.add(copy.get(index));
            copy.remove(index);
        }
        return ret;
    }
}
