package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.DirectoryChooser;

public class MediaControler implements Initializable{
	
	ImageFactory imageFactory;
	Mp3Factory mp3Factory;
	Mp4Factory mp4Factory;
	SingleSelectionModel<Tab> selectionModel;
	

	@FXML 
	private Button imageBtn, musicBtn, videoBtn;
	@FXML 
	private TabPane tp;  
	@FXML
	private Tab musicTab, videoTab, imageTab;
	@FXML
	private TilePane tilePane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Initialize components 
		imageFactory = new ImageFactory();
		mp3Factory = new Mp3Factory();
		mp4Factory = new Mp4Factory();
		
		selectionModel = tp.getSelectionModel();
		try {
			gatherImages();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Change tab view on click
	public void musicTabSelect(){
		selectionModel.select(musicTab);
	}
	public void videoTabSelect(){
		selectionModel.select(videoTab);
	}
	public void imageTabSelect(){
		selectionModel.select(imageTab);
	}
	
	
	public void gatherImages() throws FileNotFoundException{
		
		//Populate Image view Carousel
		DirectoryChooser directoryChooser = new DirectoryChooser();
		
		directoryChooser.setTitle("Choose a directory with images");
		File dir = directoryChooser.showDialog(null);
		
		List<Image> images = new ArrayList<>();
		int fileCount = 0;
		
		for(File file : dir.listFiles()) {
		      if(file.isFile()) {
		        images.add(new Image(new FileInputStream(file)));
		        GridDisplay(new Image(new FileInputStream(file)));
		        if(fileCount++ > 50) {
		          break;
		        }
		 }
		}
	}
	
	public void GridDisplay(Image im) {
		tilePane.setHgap(8);
		tilePane.setPrefColumns(4);
	    for (int i = 0; i < 20; i++) {
	    	tilePane.getChildren().add(new ImageView(im));
	    }
    }
	
	
	
	
	
	
	
	
	
	
}
