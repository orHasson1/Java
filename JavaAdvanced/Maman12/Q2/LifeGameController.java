/**
 *   Controller for Life Game application.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class LifeGameController {
	private LifeMatrix lifeMatrix; 
	private boolean[][] matrix; 
	
	@FXML
	private Canvas canvas; // used to get the GraphicsContext 
	
	@FXML
	private GraphicsContext gc;  // will get the GraphicsContext, which is used to draw on the Canvas
	
	// initializes gc, lifeMatrix and matrix
	@FXML
	public void initialize() { 
		gc = canvas.getGraphicsContext2D();
		lifeMatrix = new LifeMatrix(); 
		matrix = lifeMatrix.getMatrix(); 
	}
	
	// when user press Next Generation button, draw the next generation of the life game (random
	// generation if it's the first press).
	@FXML
	void newGenerationButtonPressed(ActionEvent event) { 
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // clear the canvas after a press
		final double SIZE = canvas.getHeight() /  matrix.length; // the size of a site square
		
		// draw the current generation
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				gc.strokeRect(i * SIZE, j * SIZE, SIZE, SIZE);
			
				if(matrix[i][j]){ // if the current cell is true (living site) it will be black, else will be white
					gc.fillRect(i * SIZE, j * SIZE, SIZE, SIZE);
				} 
			}	
		}
		
		lifeMatrix.nextGeneration(); // update for a new generation
		matrix = lifeMatrix.getMatrix(); // update matrix for the new generation
	}
}


