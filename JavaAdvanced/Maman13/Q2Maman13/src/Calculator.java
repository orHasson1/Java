/**
 * Main application class that loads and displays the Calculator  GUI.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application {
	
	@Override
	public void start(Stage stage) throws Exception{ 
		// load Calculator.fxml and configures the CalculatorController
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Calculator.fxml"));
		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setTitle("Calculator");  // displayed in window's title bar
		stage.setScene(scene); // attach scene to stage
		stage.show(); // display the stage
	} 
	
	// application execution start here
	public static void main(String[] args) { 
		launch(args); // create a Calculator object and call its start method
	} 
}