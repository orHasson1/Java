
/**************************************************************************
 * Petrol.java           Author: Or Hasson               Date: 14/4/20
 * 
 * This program gets from the input the petrol consumption of a car by 
 * miles it can drive for one  gallon, and print the petrol consumption 
 * by the number of litres that the car need to drive for 100 km.
 **************************************************************************/
 
import java.util.Scanner;
public class Petrol
{
    public static void main (String args[])
    {
        //----------------------------------------------------------------
        // Declaration of contants.
        //----------------------------------------------------------------
        final int MAX = 100;
        final double MILE_IN_KM = 1.609;
        final double GALLON_IN_LITRES = 3.785;
        final int ONE_HUNDRED_KM = 100;
        
        //---------------------------------------------------------------- 
        // Gets petrol consumption by miles/ gallons from the user.
        //----------------------------------------------------------------
        System.out.println ("Please enter the car's petrol consumption " +
                         "measured in miles/gallons:");
             
        Scanner scan = new Scanner (System.in);
        double milesPerGallon = scan.nextDouble();
        
        
        System.out.println ("The car's petrol consumption converted to " +
                         "litres/100km is:");
                         
        //----------------------------------------------------------------                    
        // Converts the miles/gallon consumption to litres/100km.
        // (100 * 3.785) / (miles/gallon * 1.609) = litres/100km
        //----------------------------------------------------------------
        double beforeRound = (ONE_HUNDRED_KM * GALLON_IN_LITRES) / 
        (milesPerGallon * MILE_IN_KM);
        
        //----------------------------------------------------------------                     
        // Rounds the consumption for two digits after the point.
        //----------------------------------------------------------------
        double afterRound = Math.round(beforeRound * MAX)/(MAX * 1.0);
        System.out.println (afterRound);
     
    } //end of method main
} // end of class Petrol