
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
import edu.duke.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("weblog1_log");
        la.printAll();
        System.out.println();
     
        // int count = la.countUniqueIPs();
        // System.out.println("There are "+count+" unique IPs ");
        // System.out.println();
        
        // int num = 400;
        // int ips = la.printAllHigherThanNum(num);
        // System.out.println("logs with status higher than "+num+" are: "+ips);
        // System.out.println();
        
        // String day = "Sep 27";
        // int size = la.uniqueIPVisitsOnDay(day);
        // System.out.println(size + " Are unique ips on "+day);
        // System.out.println();
        
        // int low = 200;
        // int high = 299;
        // int uni = la.countUniqueIPsInRange(low,high);
        // System.out.println(uni + " IPs are unique and btw low and high");
        // System.out.println();
        
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
        
        // int num = la.mostNumberVisitsByIP(counts);
        // System.out.println(num);
        // ArrayList<String> visits = la.iPsMostVisits(counts);
        // System.out.println(visits);
        
        HashMap<String, ArrayList<String>> maps = la.iPsForDays();
        // System.out.println(maps);
        
        String days = la.daysWithMostIPVisits(maps);
        System.out.println(days);
        
        ArrayList<String> list = la.iPsWithMostVisitsOnDay(maps,"Mar 17");
        System.out.println(list);
        
        
        
    }
}
