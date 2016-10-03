package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageFactory extends MediaFactory {

 //Accepted file extensions 
 protected static final String PNG = "png";
 protected static final String JPG = "jpg";
 protected static final String TIF = "tif";

 private File f = null;
 private BufferedImage bufferedImage = null;
 private int width = 963; //width of the image
 private int height = 640; //height of the image
 

 //Open file using file chooser 
 @Override
 public File openFile() {

  //Add image filter to file chooser to only allow image files to be selected
  fc.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", JPG, PNG, TIF));
  fc.setAcceptAllFileFilterUsed(false);

  //Show the file chooser dialog 
  int returnVal = fc.showOpenDialog(null);

  //If the user chose a file then return it 
  if (returnVal == JFileChooser.APPROVE_OPTION) {
   return fc.getSelectedFile();
  } else {
   System.out.println("Open command cancelled by user.");
   return null;
  }
 }

 //Save file to path
 @Override
 public void saveFile(File file) {
  //Get image path
  String imagePath = file.getAbsolutePath();
  String imageName = file.getName();
  System.out.println(imagePath);

  //Read image
  try {
   bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
   bufferedImage = ImageIO.read(new File(imagePath));
   System.out.println("Reading complete.");
  } catch (IOException e) {
   System.out.println("Error: " + e);
  }

  //write image
  try {
   f = new File("H:\\TestFolder\\images\\" + imageName); //output file path
   ImageIO.write(bufferedImage, "jpg", f);
   System.out.println("Writing complete.");
  } catch (IOException e) {
   System.out.println("Error: " + e);
  }
 }

 @Override
 public void defaultSavePath() {
	 
 }

@Override
public void loaddefaultSavePath() {
	
};
 
 
 
 

}