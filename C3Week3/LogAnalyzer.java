
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for(String s: fr.lines()){
             // WebLogParser.parseEntry(s);
             LogEntry le = WebLogParser.parseEntry(s);
             records.add(le);
         }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     public int countUniqueIPs() {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le: records) {
             String ipAddr = le.getIpAddress();
             if (! uniqueIPs.contains(ipAddr)) {
                 uniqueIPs.add(ipAddr);
             }
         }
         return uniqueIPs.size();
     }
     public int printAllHigherThanNum(int num) {
         ArrayList<LogEntry> logs = new ArrayList<LogEntry>();
         for (LogEntry le: records) {
             int status = le.getStatusCode();
             if (status > num) {
                 logs.add(le); 
             }
         } 
         for (int k = 0; k < logs.size(); k++) {
             // String s = logs.get(k);
             System.out.println(logs.get(k));
         }
         return logs.size();
     }
     public int uniqueIPVisitsOnDay(String someday) {
         ArrayList<String> log = new ArrayList<String>();
         String str ="";
         String date ="";
         for (LogEntry le: records) {
             String addr = le.getIpAddress();
             // System.out.println(addr);
             Date d = le.getAccessTime();
             str = d.toString();
             date = str.substring(4,10);
             if (! log.contains(addr)) {
                 if (date.equals(someday)) {
                     // if (! log.contains(addr)) {
                     log.add(addr);
                 }
             }
         }
         return log.size();
     }
     public int countUniqueIPsInRange(int low, int high) {
         ArrayList<String> logs = new ArrayList<String>();
         for (LogEntry le: records) {
             String addr = le.getIpAddress();
             if (! logs.contains(addr)) {
             int code = le.getStatusCode();
                if (code >= low && code <= high) {
                 logs.add(addr);
                }
             }
         }
         return logs.size();
     }
     public HashMap<String, Integer> countVisitsPerIP() {
         HashMap<String, Integer> counts = new HashMap<String, Integer>();
         for (LogEntry le: records) {
             String ip = le.getIpAddress();
             if (! counts.containsKey(ip)) {
                 counts.put(ip,1);
             } else {
                 int add = counts.get(ip);
                 counts.put(ip,add+1);
             }
         }
         return counts;
     } 
     public int mostNumberVisitsByIP(HashMap<String,Integer>map) {
         int most = 0;
         int num = 0;
         for (String s: map.keySet()) {
             int value = map.get(s);
             // System.out.println(value);
             if (num < value) {
                 most = value;
                 num = most;
             // System.out.println(most);
            }
        }
        return most;
     }
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> map) {
         ArrayList<String> visits = new ArrayList<String>();
         int most = mostNumberVisitsByIP(map);
         for (String s: map.keySet()) {
             int value = map.get(s);
             if (most == value) {
                 visits.add(s);
             }
         }
         return visits;
     }

     public HashMap<String, ArrayList<String>> iPsForDays() {
         HashMap<String, ArrayList<String>> maps = new HashMap<String, ArrayList<String>>();
         // ArrayList<String> list = new ArrayList<String>();
         String str ="";
         String date ="";
         for (LogEntry le: records) {
             Date d = le.getAccessTime();
             str = d.toString();
             date = str.substring(4,10);
             // System.out.println(s);
             String ip = le.getIpAddress();
             ArrayList<String> list = new ArrayList<String>();
             if (! maps.containsKey(date) ) {
                 list.add(ip);
                 // System.out.println(list.size());
                 maps.put(date, list);
             } else {
                 ArrayList<String> temp = maps.get(date);
                 temp.add(ip);
                 // System.out.println(temp.size());
                 maps.put(date,temp);
             }
            
         }
         return maps;
     }
     public String daysWithMostIPVisits(HashMap<String,ArrayList<String>>maps) {
         String day = "";
         int size = 0;
         for (String s: maps.keySet()) {
             int num = maps.get(s).size();
             if (num > size) {
                 size = num;
                 day = s;
             }
         }
         return day;
     }
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> maps, String day) {
         ArrayList<String> list = maps.get(day);
         HashMap<String,Integer> counts = new HashMap<String,Integer>();
         
         for (String s: list) {
             if (! counts.containsKey(s)) {
                 counts.put(s,1);
             }
             else {
                 counts.put(s,counts.get(s)+1);
             }
         }
         ArrayList<String> temp = iPsMostVisits(counts);
         return temp;
         
         
     }
}
