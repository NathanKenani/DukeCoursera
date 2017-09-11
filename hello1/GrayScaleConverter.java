import edu.duke.*;
import java.io.*;
/**
 * Write a description of class GrayScaleConverter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GrayScaleConverter
{
    public ImageResource makeGray(ImageResource inImage) {
        // blank image of same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pix: outImage.pixels() ) {
            
        //look at corresp pixel in image
            Pixel inPixel = inImage.getPixel(pix.getX(), pix.getY());
        
        //find average of pixels
            int avg = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
        //set red pixel to avg
            pix.setRed(avg);
        //set green pixel to avg
            pix.setGreen(avg);
        //set blue pixel to avg
            pix.setBlue(avg);
            
        }
        return outImage;
         
        
    }
    public void testGray() {
        
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
        
    }
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            ImageResource inFile = new ImageResource(f);
            ImageResource gray = makeGray(inFile);
            gray.draw();    
        }   
    }
    
}
