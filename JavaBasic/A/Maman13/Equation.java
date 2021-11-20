/******************************************************************************
* Equation.java                 Author: Or Hasson                Date: 06/05/20                  
*
* The program recieves from the user 3 couples of numbers that each one of them
* represents a decimal number a, b, c . It checks how many solution the 
* equation a*x*x + b*x + c = 0 has (one, two, no solutions or infinite 
* solutions), and print a relevant message. If the equation has one solution, 
* the program prints it. 
*******************************************************************************/     

import java.util.Scanner;

public class Equation{
    public static void main (String args[]){
        //----------------------------------------------------------------------
        // Declaration of contants and variables.
        //----------------------------------------------------------------------
        final Rational MULTIPLIER_IN_DELTA = new Rational(4, 1);
        final Rational MULTIPLIER_IN_QUADRATIC = new Rational(-1, 2);
        final Rational ZERO_VARIABLE = new Rational(0, 1);
        final int ZERO_COMPERATOR = 0;
        final Rational ZERO_SOLUTION = new Rational(0, 1);
        final Rational NEGATIVE_SOLUTION_MULTIPLIER = new Rational (1, -1);
        final String ONE_SOLUTION_MESSAGE = "There is one solution and it is ";
        final String TWO_SOLUTIONS_MESSAGE = "There are two solution";
        final String NO_SOLUTION_MESSAGE = "There is no solution";
        final String INFINITE_SOLUTION_MESSAGE = "There are infinite solutions";
        Rational solution = new Rational();
        String message = "";
        
        System.out.println ("Please enter 3 couples of numbers (each couple " +
                        "represents a fraction):");
                        
        Scanner scan = new Scanner (System.in); 
        
        int numerA = scan.nextInt();
        int denomA = scan.nextInt();
        int numerB = scan.nextInt();
        int denomB = scan.nextInt();
        int numerC = scan.nextInt();
        int denomC = scan.nextInt();
        
        //----------------------------------------------------------------------
        // Uses a constractor of the class Rational to represent the numbers 
        // that was given by the user as the rational numbers a, b and c.
        //----------------------------------------------------------------------
        Rational a = new Rational(numerA, denomA);
        Rational b = new Rational(numerB, denomB);
        Rational c = new Rational(numerC, denomC);    
        
        //----------------------------------------------------------------------
        // Calculates delta (delta = b*b - 4*a*c).
        //----------------------------------------------------------------------    
        Rational rationalDelta = new Rational(b.multiply(b).subtract
                                 (MULTIPLIER_IN_DELTA.multiply(a.multiply(c))));  
        
        //----------------------------------------------------------------------
        // Uses the getter methods of Fraction to represent delta as a double.
        //----------------------------------------------------------------------                    
        double doubleDelta = (double) rationalDelta.getNum() / 
                             rationalDelta.getDen();
        
        //----------------------------------------------------------------------
        // Checks if the quadratic equation of a,b,c has one, two, no 
        // solution, or infinite solutions, calculates the solution if there is
        // only one, and creates a relevant message.
        //----------------------------------------------------------------------
        if (!a.equals(ZERO_VARIABLE)){
            if (doubleDelta < ZERO_COMPERATOR){ 
                message = NO_SOLUTION_MESSAGE;
                }  // no solutions - delta < 0
            else if (doubleDelta == ZERO_COMPERATOR){
                solution = new Rational(MULTIPLIER_IN_QUADRATIC.multiply
                (b.divide(a)));
                message = ONE_SOLUTION_MESSAGE + (solution.toString()); 
                }  // 1 solution - delta = 0 (solution = -b / (2*a))
            else{  
                message = TWO_SOLUTIONS_MESSAGE;     
                }  // 2 solutions - delta > 0 
            }  // when a is not 0    
        else{
            if (!b.equals(ZERO_VARIABLE) && !c.equals(ZERO_VARIABLE)){ 
                solution = new Rational((c.divide(b)).multiply
                (NEGATIVE_SOLUTION_MULTIPLIER));
                message = ONE_SOLUTION_MESSAGE + (solution.toString());
                }  //  1 solution - solution = -c/b
            else if (b.equals(ZERO_VARIABLE) && !c.equals(ZERO_VARIABLE)){
                message = NO_SOLUTION_MESSAGE;
                }  //  no solution
            else if (!b.equals(ZERO_VARIABLE) && c.equals(ZERO_VARIABLE)){
                solution = new Rational(ZERO_SOLUTION);
                message = ONE_SOLUTION_MESSAGE + (solution.toString()); 
                }  //  1 solution - solution = 0
            else{
                message = INFINITE_SOLUTION_MESSAGE;
                }  //  infinate solutions
            }  // when a = 0 solutions
        
        System.out.println(message);

        } //  end of main 
    } //  end of class Equation