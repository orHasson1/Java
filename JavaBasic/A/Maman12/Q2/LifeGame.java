/**
 * // Main application class that loads and displays the LifeGame GUI.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LifeGame extends Application {
	
	@Override
	public void start(Stage stage) throws Exception{ 
		// load LifeGame.fxml and configures the LifeGameController
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("LifeGame.fxml"));
		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setTitle("Life Game");  // displayed in window's title bar
		stage.setScene(scene); // attach scene to stage
		stage.show(); // display the stage
	} 
	
	// application execution start here
	public static void main(String[] args) { 
		launch(args); // create a LifeGame object and call its start method
	} 
}
