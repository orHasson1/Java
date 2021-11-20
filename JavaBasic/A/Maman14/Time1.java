/**
 * Represents time - hours:minutes.
 *
 * @author Or Hasson
 * @version 25/05/20
 */       

public class Time1{  
    
    
    //----------------------------------------------------------------------
    // Declaration
    //----------------------------------------------------------------------
    private int _hour;
    private int _minute;
    private final int MIN_H = 0;
    private final int MAX_H = 23;
    private final int MIN_M = 0;
    private final int MAX_M = 59;
    private final int M_IN_H = 60;
    private final int M_IN_DAY = 1440;
    private final int MAX_ONE_DIGIT_NUM = 9;
    private final String ZERO_FORMAT = "0";
    
    
    //----------------------------------------------------------------------
    // Constructors
    //----------------------------------------------------------------------
    /**
     * Constructs a Time1 object. Construct a new time instance with the 
     * specified hour and minute . hour should be between 0-23, otherwise it 
     * should be set to 0. minute should be between 0-59, otherwise it should 
     * be set to 0.
     * @param h the hour of the time
     * @param m the minute of the time
     */
    public Time1 (int h, int m){
        if ((h < MIN_H) || (h > MAX_H))
            _hour = MIN_H;
        else
            _hour = h;
        if ((m < MIN_M) || (m > MAX_M))
            _minute = MIN_M;
        else 
            _minute = m;
        }       
    
    /**
     * Copy constructor for Time1. Construct a time with the same instance 
     * variables as another time. 
     * @param t The time object from which to construct the new time
     */
    public Time1 (Time1 t){
        this(t._hour, t._minute);
        }
    
        
    //----------------------------------------------------------------------
    // Methods
    //----------------------------------------------------------------------
    /**
     * Returns the hour of the time.
     * @return The hour of the time
     */
    public int getHour (){
        return (_hour);
        }
    
    /**
     * Returns the minutes of the time.
     * @return The minutes of the time
     */
    public int getMinute (){
        return (_minute);
        }
    
    /**
     * Changes the hour of the time. If an illegal number is received hour 
     * will be unchanged. 
     * @param num The new hour
     */
    public void setHour (int num){
        if ((num >= MIN_H) && (num <= MAX_H))
           _hour = num; // set hour if the new hour is legal (0-23) 
        }
        
    /**
     * Changes the minute of the time. If an illegal number is received minute 
     * will be unchanged.
     * @param num The new minute
     */
    public void setMinute (int num){
        if ((num >= MIN_M) && (num <= MAX_M))
            _minute = num; // set minutes if the new minutes are legal (0-59)
        }
   
    /**
     * Returns a string representation of this time ("hh:mm").
     * @return String representation of this time ("hh:mm").
     */
    public String toString (){
        String hourFormat = (_hour > MAX_ONE_DIGIT_NUM) ? _hour + "" : 
                            ZERO_FORMAT + _hour; // 0h (1 digits h)
                                             // hh (2 digits h)
        String minuteFormat = (_minute > MAX_ONE_DIGIT_NUM) ? _minute + "" : 
                              ZERO_FORMAT + _minute; // 0m (1 digits m)
                                               // mm (2 digits m)
        return (hourFormat + ":" + minuteFormat);
        }   
    
    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */ 
    public int minFromMidnight (){
         return (_hour * M_IN_H) + _minute;
        }
    
    /**
     * Checks if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return true if the received time is equal to this time
     */
    public boolean equals (Time1 other){
         return (_hour == other._hour) && (_minute == other._minute);
        } 
    
    /**
     * Checks if this time is before a received time.
     * @param other The time to check if this time is before
     * @return true if this time is before other time
     */
    public boolean before (Time1 other){
         return (_hour < other._hour) || (_hour == other._hour &&
         _minute < other._minute);
        }
    
    /**
     * Check if this time is after a received time.
     * @param The time to check if this time is after
     * @return True if this time is after other time
     */
    public boolean after (Time1 other){
         return other.before(this);
        }
    
    /**
     * Calculates the difference (in minutes) between two times. Assumption: 
     * this time is after other time.
     * @param other The time to check the difference to
     * @return int difference in minutes
     */
    public int difference (Time1 other){
        return (this.minFromMidnight() - other.minFromMidnight());
        }
    
    /**
     * Adds num Minutes to time.
     * @param num  The number of minutes to add
     * @return the updated time
     */
    public Time1 addMinutes (int num){
        int newTimeH = 0;
        int newTimeM = 0;
        int minFromMidPlusNum = num + this.minFromMidnight();
        int newTimeAsMins = (Math.abs(minFromMidPlusNum)) % M_IN_DAY;
        
        if (minFromMidPlusNum < MIN_M) {
            newTimeAsMins =  M_IN_DAY -  newTimeAsMins;  
            } // the new time is at an earlier day
        
        newTimeM = newTimeAsMins % M_IN_H;
        newTimeH = newTimeAsMins / M_IN_H;
        Time1 newTime = new Time1(newTimeH, newTimeM);
        return (newTime);
        }    
    } // end of class Time1 