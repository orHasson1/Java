/***********************************************************************
 * Ball.java           Author: Or Hasson               Date: 14/4/20 
 * 
 * This program gets from the use the radius of a ball. It calculates
 * the ball's surface aera and volume by given formulas and print them.
 ***********************************************************************/
 
import java.util.Scanner;
public class Ball
{
    public static void main (String args[])
    {
        //---------------------------------------------------------------- 
        // Declaration of contant.
        //----------------------------------------------------------------
        final double PI = Math.PI;
        final int MULTIPLIER = 4;
        final int DIVISOR_VOLUME = 3;
        final int RADIUS_POWER_SURFACE_AERA = 2;
        final int RADIUS_POWER_VOLUME = 3;
        final int MAX = 100;
        
        //----------------------------------------------------------------
        // Gets radius size of a ball from the user.
        //----------------------------------------------------------------
        System.out.println ("Please enter the Ball's radius:");
        
        Scanner scan = new Scanner (System.in);
        int radiusSize = scan.nextInt();
        
        //----------------------------------------------------------------
        // Calculates the surface aera of the ball (A = 4·π·R²)
        // and the volume (V = (4·π·R³) ∕ 3).
        //----------------------------------------------------------------
        double surfaceAeraBeforeRound = MULTIPLIER * PI * 
        Math.pow(radiusSize,RADIUS_POWER_SURFACE_AERA);
        double volumeBeforeRound = MULTIPLIER * PI * Math.pow(radiusSize,
        RADIUS_POWER_VOLUME) / DIVISOR_VOLUME;
        
        //----------------------------------------------------------------
        // Rounds the surface aera and the volume for two digits after the
        // point.
        //----------------------------------------------------------------
        double surfaceAeraAfterRound = Math.round(surfaceAeraBeforeRound * 
        MAX)/(MAX * 1.0);
        double volumeAfterRound = Math.round(volumeBeforeRound * 
        MAX)/(MAX * 1.0);
     
        System.out.println ("The Ball's surface aera is:");
        System.out.println (surfaceAeraAfterRound);
        System.out.println ("The volium of the Ball is:");
        System.out.println (volumeAfterRound);
          
    } //end of method main
} // end of class Ball   