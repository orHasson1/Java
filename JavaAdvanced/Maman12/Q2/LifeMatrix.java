/**
 * The class represents a life game.
 */

import java.util.Random;

public class LifeMatrix {
	private boolean[][] matrix; // if the site [i][j] is leaving matrix[i][j] is true, else matrix[i][j] is false
	Random rand = new Random();
	final static int SIZE = 10; // matrix will be SIZE X SIZE
	
	public LifeMatrix(){ // constructor
		matrix = new boolean[SIZE][SIZE];
		// create a random first generation
		for(int i = 0; i < SIZE; i++){
			for (int j = 0 ; j < SIZE; j++){
				matrix[i][j] = rand.nextBoolean();
			}
		}
	}
	
	// return matrix
	public boolean[][] getMatrix(){
		return matrix;
	}
	
	// create a new generation based on the rules of the life game and update matrix to the new generation
	public void nextGeneration(){
		boolean[][] nextGenMatrix = new boolean[getMatrix().length][getMatrix().length];
		int livingNeighbors; // the number of living neighbors of the current site
		
		for(int i = 0; i < SIZE; i++){
			for (int j = 0 ; j < SIZE; j++){
				livingNeighbors = countLivingNeighblors(i, j);
				// if the current site is living and has 2 or 3 living neighbors it will stay alive in the 
				// next generation, else it will die
				if(matrix[i][j]){
					nextGenMatrix[i][j] = livingNeighbors == 2 || livingNeighbors == 3;				
				}
				// if the current site is died it iff it has exactly 3 living neighbors
				else{
					nextGenMatrix[i][j] = livingNeighbors == 3;
				}
			} 
		}
		// update matrix for the new generation
		matrix = nextGenMatrix;
	}
	
	// return the number of living neighbors of matrix[row][column]
	private int countLivingNeighblors(int row, int column){
		return siteLifeValue(row , column - 1) + siteLifeValue(row - 1, column - 1) +
			  siteLifeValue(row + 1, column - 1) +  siteLifeValue(row , column + 1) +
			  siteLifeValue(row - 1, column + 1) + siteLifeValue(row - 1 , column) +
			  siteLifeValue(row + 1 , column) + siteLifeValue(row + 1 , column + 1); 
	}
	
	// return 1 if matrix[row][column] is a valid and true cell in matrix (living site), else return 0
	private int siteLifeValue(int row, int column){
		if(column >= 0 && column < SIZE && row >= 0 && row < SIZE && matrix[row][column]){
			return 1;
		}
		return 0;
	}
}
