package application;

import java.nio.file.Paths;

public class MediaPlayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageFactory imageFactory = new ImageFactory();
		Mp3Factory mp3Factory = new Mp3Factory();
		
		mp3Factory.importFile();
		//imageFactory.defaultSavePath();
	}

}
