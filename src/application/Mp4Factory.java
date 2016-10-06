package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Mp4Factory extends MediaFactory{
	
	 protected static final String MNG = "mng";
	 protected static final String WMV = "wmv";
	 protected static final String AVI = "avi";
	 protected static final String MP4 = "mp4";
	 
	FileOutputStream output = null;

	@Override
	public File openFile() {
		//Add image filter to file chooser
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Videos", MNG, WMV, AVI, MP4));
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
		Path sourcePath = file.toPath();

	    String fileName = file.getName();
	    Path targetPath = Paths.get("H:\\TestFolder", fileName);

	    try {
			Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
