/**
 * This class represents a train.
 *
 * @author Or Hasson
 * @version 25/05/20
 */       

public class Train
{
    //----------------------------------------------------------------------
    // Declaration
    //----------------------------------------------------------------------
    private String _destination;
    private Time1 _departure;
    private int _duration;
    private int _passengers;
    private int _seats;
    private int _price;
    private final int MIN_DURATION = 0;
    private final int MIN_PASSENGERS = 0;
    private final int MIN_SEATS = 0;
    private final int MIN_PRICE = 0;
    private final String DESTINATION_MESSAGE = "Train to ";
    private final String DEPARTURE_MESSAGE = " departs at ";
    private final String FULL_MESSAGE = ". Train is full.";
    private final String NOT_FULL_MESSAGE = ". Train is not full.";
    
    //----------------------------------------------------------------------
    // Constructors
    //----------------------------------------------------------------------
    /**
     * Constructor of class Train. Constructs a new train. duration should 
     * be positive, otherwise it should be set to 0. pass should be positive, 
     * otherwise it should be set to 0. pass should be less than seats 
     * otherwise it should be set to seats. seats should be positive, 
     * otherwise it should be set to 0. price should be positive, otherwise
     * it should be set to 0.
     * @param destination the destination of the train
     * @param departureH the hour of departure.
     * @param departureM the minute of departure.
     * @param duration the duration of the travel.
     * @param passengers the number of passeners.
     * @param seats  the number of seats in the train.
     * @param price the price of the travel.
     */
    public Train(String destination, int departureH, int departureM, 
                 int duration, int passengers, int seats, int price){
        _destination = destination; 
        _departure = new Time1(departureH, departureM);
        _duration = duration < MIN_DURATION ? MIN_DURATION : duration;
        
        _seats = seats < MIN_SEATS ? MIN_SEATS : seats;  
        _passengers = passengers < MIN_PASSENGERS ? MIN_PASSENGERS : 
                      passengers;
                      
        if (_passengers > _seats){
            _passengers = _seats;
            } 
        _price = price < MIN_PRICE ? MIN_PRICE : price;
        }
        
    /**
     * Copy constructor for Train. Construct a train with the same instance 
     * variables as another train.
     * @param other The train object from which to construct the new train.
     */
    public Train(Train other){
        this(other._destination, other._departure.getHour(), 
           other._departure.getMinute(),other._duration, other._passengers, 
             other._seats, other._price);
        }
 
        
    //----------------------------------------------------------------------
    // Methods
    //----------------------------------------------------------------------
    /**
     * returns the departure time.
     * @return the departure time.
     */
    public Time1 getDeparture(){
        return (_departure);
        }
     
    /**
     * Return a string representation of the train.
     * @return String representation of the train.  
     */
    public String getDestination(){
        return (_destination);
        }
        
    /**
     * returns the duration of the train.
     * @return the duration of the train.
     */    
    public int getDuration(){
        return (_duration);
        }
        
    /**
     * returns the number of passengers.
     * @return the number of passengers.
     */        
    public int getPassengers(){
        return (_passengers);
        }
        
    /**
     * returns the price of passengers.
     * @return the price of the train.
     */       
    public int getPrice(){
        return (_price);
        }
        
    /**
     * returns the number of seats.
     * @return the number of seats.
     */      
    public int getSeats(){
        return (_seats);
        }
        
    /**
     * updates the departure time of the train. t in not null.   
     * @param t the new departure time of the train.
     */         
    public void setDeparture(Time1 t){
        _departure = new Time1(t);
        }
        
    /**
     * updates the destination of the train. d in not null.
     * @param d the new detination of the train.
     */    
    public void setDestination(String d){
        _destination = new String(d);
        }
        
    /**
     * updates the duration of the train. d should be positive or zero,
     * otherwise duration is unchanged
     * @param d the new duration of the train.
     */    
    public void setDuration(int d){
        if (d >= MIN_DURATION)
            _duration = d;
            }
            
    /**
     * updates the number of passengers. p should be positive or zero, 
     * otherwise passengers is unchanged. p should be less than seats 
     * otherwise it should be set to seats.
     * @param p the new number of passengers.
     */        
    public void setPassengers(int p){
        if (p >= MIN_PASSENGERS){
            _passengers = p > _seats ? _seats : p;
            } 
        }    
         
    /**
     * updates the price. p should be positive or zero, otherwise price
     * is unchanged.
     * @param p the new price.
     */    
    public void setPrice(int p){
        if (p >= MIN_PRICE){
            _price = p;
            }
        }    
        
    /**
     * updates the number of seats. s should be positive or zero, 
     * otherwise seats is unchanged. s should be larger than passengers,
     * otherwise seats is unchanged.
     * @param s the new number of seats.
     */    
    public void setSeats(int s){
        if ((s >= MIN_SEATS) && (s >= _passengers)){
            _seats = s;
            }
        }
    
    /**
     * Check if the received train is equal to this train at the destination,
     * the number of seats and the departure.
     * @param other The train to be compared with this train.
     * @return True if the received train is equal to this train.
     */    
    public boolean equals(Train other){
        return ((_destination == other._destination) && 
                (_seats == other._seats) && (_departure == other._departure));
        }
    
    /**
     * Returns the arrival time.
     * @return the arrival time.
     */    
    public Time1 getArrivalTime(){ 
        return (_departure.addMinutes(_duration));
        }
        
    /**
     * Add num passengers to the train.
     * @param num The number of passengers to add.
     * @return True if the total number of current passengers and num
     * is less or equal to seats.
     */
    public boolean addPassengers(int num){
        boolean additionTest; 
        int passengersAfterAddition = _passengers + num;
        if (passengersAfterAddition > _seats){
            additionTest = false;
            } //  more passengers than seats
        else{
            _passengers = passengersAfterAddition;
            additionTest = true;
            _passengers = passengersAfterAddition;
            } //  less or the same amount of passengers and seats
        return (additionTest);
        }
          
    /**
     * Returns true if train is full.
     * @return true if train is full.
     */
    public boolean isFull(){
        return (_passengers == _seats);
        }
        
    /**
     * Returns true if the price for this train is cheaper than the 
     * other train. other is not null.
     * @param other the other train to compare price with.
     * @return true if the price for this train is cheaper than the 
     * other train.
     */    
    public boolean isCheaper(Train other){
        return (_price < other._price);
        }
        
    /**
     * Returns the total price for all passengers.
     * @return the total price for all passengers.
     */    
    public int totalPrice(){
        return (_price * _passengers);
        }
        
    /**
     * Returns true if the arrival time of this train is earlier than
     * the arrival time of the other train. other is not null.
     * 2param other the other train to compare arrival time with.
     * @return true if the arrival time of this train is earlier than
     * arrival time of the other train.
     */    
    public boolean arrivesEarlier(Train other){
        return (this.getArrivalTime().before(other.getArrivalTime()));
        }
    
    /*this method creates an appropriate message depending on the available
    place in the train (full\ not full)*/
    private String messageForFull(){
        if (this.isFull() == true)
            return (FULL_MESSAGE);
        else 
            return (NOT_FULL_MESSAGE);
        }
    
    /**
     * Return a string representation of the train.
     * @return String representation of the train.
     */    
    public String toString(){
    return (DESTINATION_MESSAGE + this.getDestination() + DEPARTURE_MESSAGE +
           this.getDeparture() + this.messageForFull());                       
        }             
    }  // end of class Train


