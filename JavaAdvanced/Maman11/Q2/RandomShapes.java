/**
 * // Main application class that loads and displays the RandomShapes GUI.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomShapes extends Application {
	
	@Override
	public void start(Stage stage) throws Exception{ 
		// load DrawLines.fxml and configures the RandomShapesControlle
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("RandomShapes.fxml"));
		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setTitle("Random Shapes");  // displayed in window's title bar
		stage.setScene(scene); // attach scene to stage
		stage.show(); // display the stage
	} 
	
	// application execution start here
	public static void main(String[] args) { 
		launch(args); // create a RandomShapes object and call its start method
	} 
}

