
/**
 * Ex14 is a class of the answers for maman 14.
 *
 * @author Or Hasson
 * @version 23/12/20
 */
public class Ex14{    
    /**
     * The method receives a size of an array and an integer and and return the number
     * of options to fill the array with numbers from range 1 to the given integer,
     * so that they are arranged in order that doesn't go down.
     * @param n The size of the array.
     * @param max The maximal number in a legal arrangement of the array.
     * @return The number of legal arrangements.
     */
    public static int howManySorted(int n, int max){
        if(n == 0 || max <= 0){
            return 0;
        } // If max isn't positive or n is empty there aren't possible arrangments.
        
        if(n == 1){
            return max;
        } // If the array's length is one the every number in the range 1-max is 
          // possible.
        
        return howManySorted(n-1,max) + howManySorted(n, max-1);
    }
    
    /**
     * The method receives a full two-dimensional array of boolean values, in size 
     * x * x, and return the number of areas in it. An area is the greatest 
     * collection of cells that are neighbors. A couple of cells are neighbors if 
     * they are in a sequance in the same row or in the same column 
     * @param mat Two-dimentional array. the number of rows in the array is equal 
     * to the number of columns.
     * @return The number of "areas" in mat.
     */
    public static int cntTrueReg (boolean[][] mat){
        return cntTrueReg (mat, 0, 0, 0);
    }
    
    // Assists cntTrueReg (boolean[][] mat). i represents an index of a row in 
    // the matrix mat, and j represents an index of a column in the matrix mat.
    private static int cntTrueReg(boolean[][] mat, int i, int j, int counter){
        if(i == mat.length){
            return counter;
        } // If the whole matrix has already been scanned.
        
        if(j == mat.length){
            return cntTrueReg(mat, i+1, 0, counter);
        } // If all the row i in the matrix has already been scanned.
        
        if(mat[i][j]){
            counter++;
            // Assists to "neutralize" the area which mat[i][j] belongs to.
            eraseErea(mat, i, j); 
        } // If mat[i][j] is a part of an area.
        
        return cntTrueReg(mat, i, j+1, counter);    
    }
    
    // Switches the erea of mat[i][j] to be false.
    private static void eraseErea(boolean[][] mat, int i, int j){
        if(!legalInd(mat, i, j) || !mat[i][j]){
            return;
        } // If [i][j] isn't an index in mat or already false.
        
        mat[i][j] = false;
        eraseErea(mat, i+1, j);
        eraseErea(mat, i-1, j);
        eraseErea(mat, i, j+1);
        eraseErea(mat, i, j-1);
    }
    
    // Returns true if the index [i][j] is an index in the metrix mat, otherwise 
    // returns false.
    private static boolean legalInd(boolean[][] mat, int i, int j){
        return (i >= 0 && i < mat.length && j >= 0 && j < mat.length);
    }
}