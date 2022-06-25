  /**
 * Main application class that loads and displays the QuizGame GUI.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizGame extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		// load QuizGame.fxml and configures the QuizGame
		Parent root = FXMLLoader.load(getClass().getResource("QuizGame.fxml"));
		stage.setTitle("Quiz Game");  // displayed in window's title bar
		Scene scene = new Scene(root); // attach scene graph to scene
		stage.setScene(scene);  // attach scene to stage
		stage.show(); // display the stage
	}

	// application execution start here
	public static void main(String[] args) {
		launch(args);
	}
}
