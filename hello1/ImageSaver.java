import edu.duke.*;
import java.io.*;
/**
 * Write a description of class ImageSaver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImageSaver
{
    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            ImageResource img = new ImageResource(f);
            String fname = img.getFileName();
            String newname = "copy-" + fname;
            img.setFileName(newname);
            img.draw();
            img.save();
            
            
        }    
    }
}
