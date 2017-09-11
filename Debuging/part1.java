
/**
 * Write a description of class part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class part1
{
    public void findAbc(String input)  {
        int index = input.indexOf("abc");
        while (true) {
            int len = input.length();
            if (index == -1 || index >= len - 3) 
            {
                break;
            }
            String found = input.substring(index+1, 
            index+4);
            System.out.println(found);
            // System.out.println((index+1));
            // System.out.println((index+4));
            index = input.indexOf("abc", index+4);            
        }
    }
    public void test() {
       // findAbc("abcd");
        findAbc("abcdabc");       
    }
}
