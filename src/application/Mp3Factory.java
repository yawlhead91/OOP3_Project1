package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


import javafx.scene.media.Media;

public class Mp3Factory extends MediaFactory{
	
	private File folder = null;
	private File file= null;
	private Media m = null;
	
	FileOutputStream output = null;

	@Override
	public File openFile() {
		//Add image filter to file chooser
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Mp3 Files", "mp3"));
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

	@Override
	public void saveFile(File file) {
		String fileName = file.getName();
		folder = new File("H:\\TestFolder\\"); //output file path
		
		if (!folder.exists()) {
	        try {
	            folder.createNewFile();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
		
		try{
			String folder_location = folder.toString() + "\\";
            file = new File(folder_location + fileName.toString());
            output = new FileOutputStream(file);
            
            if (!file.exists()) {
                file.createNewFile();
            }
            
            byte[] buffer = new byte[4096];
            
            output.write(buffer);
            output.flush();
            output.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		f.mkdirs();
//		try {
//			InputStream is = new FileInputStream(f);
//			OutputStream outstream = new FileOutputStream(new File("H:\\TestFolder2\\blabla.mp3"));
//			byte[] buffer = new byte[4096];
//			int len;
//			try {
//				while ((len = is.read(buffer)) > 0) {
//				    outstream.write(buffer, 0, len);
//				    outstream.close();
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void defaultSavePath() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loaddefaultSavePath() {
		// TODO Auto-generated method stub
		
	}

}
