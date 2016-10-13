package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MediaControler implements Initializable{
	
	ImageFactory imageFactory;
	Mp3Factory mp3Factory;
	Mp4Factory mp4Factory;
	
	private Button button; 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Initialize components 
		imageFactory = new ImageFactory();
		mp3Factory = new Mp3Factory();
		mp4Factory = new Mp4Factory();
	}
	
}
