import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private HashMap<String,ArrayList<String>> myMap;
    private ArrayList<String> repeated;
    private ArrayList<String> used;
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";
    
    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        repeated = new ArrayList<String>();
        used = new ArrayList<String>();
    }
    public GladLibMap(String source){
        myMap = new HashMap<String,ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
        repeated = new ArrayList<String>();
        used = new ArrayList<String>();
    }

    private void initializeFromSource(String source) {
        // myMap = new HashMap <String, ArrayList<String>>();
        String[] labels = {"country","noun","adjective","color",
            "name","animal","timeframe","verb","fruit"};
        for (String s: labels) {
            ArrayList<String> list = readIt(source+"/"+ s +".txt");
            myMap.put(s, list);
        } 
       
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        used.add(label);
        // System.out.println(myMap.get(used));
        
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        // used.add(label);
        return randomFrom(myMap.get(label));
    }
    
    private String processWord(String w){
        String word = "";
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
         if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub = getSubstitute(w.substring(first+1,last));
      
        while(true) {
            if (!repeated.contains(sub)) {
                repeated.add(sub);
                break;
            }
            sub = getSubstitute(w.substring(first+1,last));
         
        }
        // System.out.println(sub);
        return prefix+sub+suffix;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    private int totalWordsInMap() {
        int total = 0;
        for(String s: myMap.keySet()) {
            ArrayList<String>wor = myMap.get(s);
            total += wor.size();
        }
        return total;
    }
    private int totalWordsConsidered() {
        
        int total = 0;
        // String w = "";
        ArrayList<String> store = new ArrayList<String>();
        for(String s : myMap.keySet()) {
            // System.out.println(s);
            for(String w: used) {
                if (s.contains(w) ){
                    if(! store.contains(w)) {
                        store.add(w);
                    }
                }
            }  
        }
        for(String a: store) {
            System.out.println(a);
            total += myMap.get(a).size();
                // System.out.println(total);
        }
        return total;
        
    }
    public void makeStory(){
        repeated.clear();
        used.clear();
        // myMap.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        System.out.println("\n\nThe total number of words replaced are: " +repeated.size());
        int total = totalWordsInMap();
        System.out.println("\n The total words in myMap are: "+total);
        int newT = totalWordsConsidered();
        System.out.println("\n The total words considered were: "+newT);
    }
    


}
