/**
 * Main application class that loads and displays the PhoneBook GUI.
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhoneBookApp extends Application {
	
	@Override
	public void start(Stage stage) throws Exception { 
		// load PhoneBook.fxml and configures the PhoneBookController
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("PhoneBook.fxml"));
		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setTitle("Phone Book");  // displayed in window's title bar
		stage.setScene(scene); // attach scene to stage
		stage.show(); // display the stage
	} 
	
	// application execution start here
	public static void main(String[] args) { 
		launch(args); // create a PhoneBook object and call its start method
	} 
}
	