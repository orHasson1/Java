/**
 * Represents time by the minutes from midnight. Values must represent a proper
 * time.
 *
 * @author Or Hasson
 * @version 25/05/20
 */       

public class Time2{
    //----------------------------------------------------------------------
    // Declaration
    //----------------------------------------------------------------------
    private int _minFromMid;
    private final int M_IN_H = 60;
    private final int M_IN_DAY = 1440;
    private final int MIN_M = 0;
    private final int MAX_M = 59;
    private final int MIN_H = 0;
    private final int MAX_H = 23;

    private final int MAX_ONE_DIGIT_NUM = 9;
    private final String ZERO_FORMAT = "0";
    
    
    //----------------------------------------------------------------------
    // Constructors
    //----------------------------------------------------------------------
    /**
     * Constructs a Time2 object. Construct a new time instance with the 
     * specified hour and minute . hour should be between 0-23, otherwise it 
     * should be set to 0. minute should be between 0-59, otherwise it should 
     * be set to 0.
     * @param h the hour of the time
     * @param m the minute of the time
     */
    public Time2(int h, int m){
        int timeAsMinutes = (h * M_IN_H) + m; //  h*60 + m
        if ((timeAsMinutes >= M_IN_DAY) || (timeAsMinutes < MIN_M)){
            _minFromMid = MIN_M; 
            } //  tests if the time is legal (0-1440 minutes) 
        else{ 
            _minFromMid = timeAsMinutes;   
            }
        }
    
    /**
     * Copy constructor for Time2. Construct a time with the same instance 
     * variables as another time. 
     * @param other The time object from which to construct the new time
     */
    public Time2(Time2 other){
        _minFromMid = other._minFromMid;
        }
    
        
    //----------------------------------------------------------------------
    // Methods
    //----------------------------------------------------------------------
    /**
     * Returns the hour of the time.
     * @return The hour of the time
     */
    public int getHour(){
        int hour = (_minFromMid - this.getMinute()) / M_IN_H;
        return (hour);    
        }    
    
    /**
     * Returns the minutes of the time.
     * @return The minutes of the time
     */
    public int getMinute(){
        return (_minFromMid % M_IN_H);                                          
        } //  minutes = reminder of division in 60 minutes (hour)
    

    /**
     * Changes the hour of the time. If an illegal number is received hour 
     * will be unchanged. 
     * @param num The new hour
     */
    public void setHour(int num){
        if ((num <= MAX_H) && (num >= MIN_H))
            _minFromMid = this.getMinute() + (num * M_IN_H);   
        }  
    
    /**
     * Changes the minute of the time. If an illegal number is received minute 
     * will be unchanged.
     * @param num The new minute
     */
    public void setMinute(int num){
        int hOfTimeAsM = this.getHour() * M_IN_H;
        if ((num >= MIN_M) && (num <= MAX_M)){
            _minFromMid = hOfTimeAsM + num;
            } 
        }
    
    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */ 
    public int minFromMidnight(){ 
        return (this.getMinute() + (this.getHour() * M_IN_H));
        }
    
    /**
     * Checks if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return true if the received time is equal to this time
     */
    public boolean equals(Time2 other){
        return (_minFromMid == other._minFromMid);
        }
    
    /**
     * Checks if this time is before a received time.
     * @param other The time to check if this time is before
     * @return true if this time is before other time
     */
    public boolean before(Time2 other){
        return (_minFromMid < other._minFromMid);
        }
    
    /**
     * Checks if this time is after a received time.
     * @param other The time to check if this time is after
     * @return true if this time is after other time
     */
    public boolean after(Time2 other){
        return (other.before(this));
        }
    
    /**
     * Calculates the difference (in minutes) between two times. Assumption: 
     * this time is after other time.
     * @param other The time to check the difference to
     * @return int difference in minutes
     */
    public int difference (Time2 other){
        return (_minFromMid - other._minFromMid);
        }
    
    /**
     * Returns a string representation of this time ("hh:mm").
     * @return String representation of this time ("hh:mm").
     */
    public String toString(){
        int h = this.getHour();
        int m = this.getMinute();
        String hourFormat = (h > MAX_ONE_DIGIT_NUM) ? h + "" : 
                            ZERO_FORMAT + h; //  0h (1 digits h)
                                             //  hh (2 digits h)                   
        String minuteFormat = (m > MAX_ONE_DIGIT_NUM) ? m + "" : 
                              ZERO_FORMAT + m; // 0m (1 digits m)
                                               // mm (2 digits m)
        return (hourFormat + ":" + minuteFormat);
        }   
    
    
    /**
     * Adds num Minutes to time.
     * @param num  The number of minutes to add
     * @return the updated time
     */
    public Time2 addMinutes (int num){        
        int newTimeM = 0;
        int newTimeH = 0;
        int newsMinFromMidnight = 0;
        int minFromMidPlusNum = num + _minFromMid;
        int newTimeAsMins = Math.abs(minFromMidPlusNum) % M_IN_DAY;
        
        if (minFromMidPlusNum < MIN_M) {
            newTimeAsMins =  M_IN_DAY -  newTimeAsMins;  
            } // the new time is at an earlier day
        
        newTimeM = newTimeAsMins % M_IN_H;
        newTimeH = newTimeAsMins / M_IN_H;
        Time2 newTime = new Time2(newTimeH, newTimeM);
        return (newTime);
        }        
    } //  end of class Time2 
