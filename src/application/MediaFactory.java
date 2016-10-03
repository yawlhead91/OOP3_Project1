package application;

import java.io.File;
import javax.swing.JFileChooser;

public abstract class MediaFactory implements Factory {
	
	private File importFile;
	final JFileChooser fc = new JFileChooser();
	
	public void importFile(){
		importFile = openFile();
		if(importFile != null){
			saveFile(importFile);
		}else{
			System.out.println("No file found");
		}
	};
	
	//Open File to import to our repository using a file chooser
	public abstract File openFile();
	//Save the file
	public abstract void saveFile(File file);
	//Path where images get saved
	public abstract void defaultSavePath();
	//Path load
	public abstract void loaddefaultSavePath();
	
	
	
}
