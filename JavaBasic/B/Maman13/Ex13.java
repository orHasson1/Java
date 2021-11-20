/**
 * Ex13 contains the answers of maman 13.
 *
 * @author Or Hasson
 * @version 29/11/20
 */
public class Ex13{
    /** 
     *  The method receives two positive integers and returns the difference between 
     *  the number of digits of them.
     *  @param a A positive integer.
     *  @param b Another positive integer.
     *  @return The the difference between the number of digits of a and b.
     */ 
    public static int digitDiffer (int a, int b){
        if((a == 0) && (b == 0)){
            return 0;
        } // If a and b have the same length.
        else if((a == 0) || (b == 0)){
            int longerNum = a == 0 ? b : a;  // The longer number between a and b.
            return 1 + digitDiffer(longerNum/10, 0);
        } // If a and b haven't the same length.
        return digitDiffer(a/10,b/10); 
    }

    /** 
     *  The method receives a number of stages in a ladder, and returns the number 
     *  of posible ways to climb to the top, in one or two steps each time. 
     *  @param n The number of stages in the ladder (non negative).
     *  @return The number of posible ways to climb to the top, in one or two steps
     *  each time.
     */ 
    public static int numWaysToClimb(int n){
        if(n == 0){
            return 0;
        } // If the ladder has no stages the method return 0.
        return numWaysToClimb(n, 0); // Overloading function.
    }    
    
    // Assists numWaysToClimb(int n) in all the cases that n is positive.
    private static int numWaysToClimb(int n, int counter){
        if(n == 1 || n == 2){
            counter += n;
        } // If there is only one way or two ways.
        else{
            counter = numWaysToClimb(n-1, counter) + numWaysToClimb(n-2 , counter);
        } // If there are more than two ways.
        return counter; // The total number of ways.
    }
    
    /** 
     * The method receives a positive integer num and return the number of solutions 
     * to the equation x1+x2+x3 = num, when x1, x2 and x3 are positive integers 
     * between 1 to 10. In addition, the method prints all the posible solutions.
     * @param num A positive integer.
     * @return the number of solutions to the equation x1+x2+x3 = num.
     */ 
    public static int solutions(int num){
        return solutions(num, 1, 1, num-2); // Overloading function.
    }
    
    // Assists solutions(int num) if there are legal solution for the equetion
    // x1+x2+x3 = num.
    private static int solutions(int num, int x1, int x2, int x3){
        if(x1 > 10 || x1 == num){
            return 0;
        } // If the x1 is too big for a legal equation.
        
        if(x2 > 10 || x3 < 1){
            return solutions(num, x1+1, 1, num-x1-2);
        } // If x2 is too big or x3 is too small for a legal equation.
        
        if(x3 > 10){
            return solutions(num, x1, x2+1, x3-1);
        } // // If x3 is too big for a legal equation.
        System.out.println(x1 + " + " + x2 + " + " + x3);
        return 1 + solutions(num, x1, x2+1, x3-1);
    } 
}