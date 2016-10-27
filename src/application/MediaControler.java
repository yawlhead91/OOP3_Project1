package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

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
		
		//Populate Image view Carouse
		String path = "E:" + File.separator + "Pictures";
		File folder = new File(path);

		File[] listOfFiles = folder.listFiles();

		for (final File file : listOfFiles) {
			ImageView imageView;
			imageView = createImageView(file);
			tilePane.getChildren().addAll(imageView);
		}
	}

	private ImageView createImageView(final File imageFile) {
		// DEFAULT_THUMBNAIL_WIDTH is a constant you need to define
		// The last two arguments are: preserveRatio, and use smooth (slower)
		// resizing

		ImageView imageView = null;
		try {
			final Image image = new Image(new FileInputStream(imageFile), 200, 0, true,
					true);
			imageView = new ImageView(image);
			imageView.setFitWidth(200);

			imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
							System.out.println("here");
							try {
								BorderPane borderPane = new BorderPane();
								ImageView imageView2 = new ImageView();
								Image imagee = new Image(new FileInputStream(imageFile));
								imageView2.setImage(imagee);
								imageView2.setStyle("-fx-background-color: BLACK");
								imageView2.setFitHeight(739 -10);
								imageView2.setPreserveRatio(true);
								imageView2.setSmooth(true);
								imageView2.setCache(true);
								borderPane.setCenter(imageView2);
								borderPane.setStyle("-fx-background-color: BLACK");
								Stage newStage = new Stage();
								newStage.setWidth(1095);
								newStage.setHeight(739);
								newStage.setTitle(imageFile.getName());
								Scene scene = new Scene(borderPane, Color.BLACK);
								newStage.setScene(scene);
								newStage.show();
							} catch (FileNotFoundException ex) {
								ex.printStackTrace();
							}
			});
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		return imageView;
	}

	
	
	
	
	
	
	
	
	
}
