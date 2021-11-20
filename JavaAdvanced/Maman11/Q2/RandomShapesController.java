/**
 * Drawing 10 random shapes on the canvas as a react for a button press.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.Random;
import javafx.scene.paint.Color;

public class RandomShapesController {

	Random rand = new Random();
	
	@FXML
	private Canvas canvas;  // used to get the GraphicsContext
	
	@FXML
	private GraphicsContext gc; // will get the GraphicsContext, which is used to draw on the Canvas
	
	@FXML
	
	// initializes gc
	public void initialize() {	
		gc = canvas.getGraphicsContext2D();
	}
	
	// when user presses Draw Shapes button, draw 10 random shapes
	@FXML
	void drawShapesButtonPressed(ActionEvent event) {
		// clears the canvas after a press
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		int typeInd; // a shape option (0: Oval, 1: Square, 2: Line)
		int x, y, width, height; // valuse for a random shape
		
		// the shapes should be inside the canvas (at least part of them)
		final int MAX_X = (int) canvas.getHeight();
		final int MAX_Y= (int) canvas.getWidth();
		
		// the shapese's sizes should be less than quarter of the canvase's size
		final int MAX_WIDTH = MAX_X / 4;
		final int MAX_HEIGHT = MAX_Y/ 4;
		
		// creates 10 random shapes
		for (int i = 0; i < 10; i++) {
			// determine random attributes for the current shape
			typeInd = rand.nextInt(3); 
			gc.setFill(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 1));
			gc.setStroke(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(),1));
			x =  rand.nextInt(MAX_X);
			y = rand.nextInt(MAX_Y);
			width = Math.max(1,rand.nextInt( MAX_WIDTH));
			height = Math.max(1,rand.nextInt( MAX_HEIGHT));
			
			// draw a random shape
			switch (typeInd) {
				case 0: // oval
					gc.fillOval(x, y, width, height);
					break;
				case 1: // square
					width = width < height ? width : height;
					gc.fillRect(x, y, width, width);
					break;
				case 2: // line
					gc.strokeLine(x, y,  width + x,  height + y);	
					break;
			}
		}
	}
}
