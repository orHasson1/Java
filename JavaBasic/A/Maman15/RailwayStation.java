/**
 * Represents a rail station.
 *
 * @author Or Hasson
 * @version 17/06/2020
 */
public class RailwayStation{
    //----------------------------------------------------------------------
    // Declarations
    //----------------------------------------------------------------------
    private Train[] _station;
    private int _noOfTrs;
    private final int TRAINS_MAX = 100;
    private final int TRAINS_MIN = 0;
    private final int INDEX_MIN = 0;    
    
    //----------------------------------------------------------------------
    // Constructor
    //----------------------------------------------------------------------
    /**
     * Constructor of class RailwayStation. Constructs a new train station. 
     */
    public RailwayStation(){
        _station = new Train[TRAINS_MAX];
        _noOfTrs = TRAINS_MIN;
    }
    
    
    //----------------------------------------------------------------------
    // Methods
    //----------------------------------------------------------------------
    // Receives a train and and return true if it's in the station,
    // otherwise false.
    private boolean isTrnInStation(Train f){
        for (int i=0; i< _noOfTrs; i++){
            if (_station[i].equals(f)){
                return true;
            }
        }
        return false;
        }
        
        
    // Receives a train and if it's in the station returns it's index.
    private int trainIndex(Train f){
        int index = 0;
        for (int i=1; i< _noOfTrs; i++){
            if (_station[i].equals(f)){
                index = i;
            } 
        }
        return index;
    }
    
    
    /**
     * Receives a train. If there is no available place in the station or the 
     * train is already in the station, it returns false. Otherwise it adds 
     * the train to the station and returns true.
     * @param  f  The train to add.
     * @return true if the train was added and false if it wasn't.
     */
    public boolean addTrain(Train f){
        if ((_noOfTrs == TRAINS_MAX) || (this.isTrnInStation(f) == true)){ 
            return false;
        } // the station is full or the train is already in the station.
        _station[_noOfTrs] = new Train(f);
        _noOfTrs++;
        return true;
    }
        
    
    /**
     * Receives a train. If the train is in the station, removes the train 
     * and returns true, otherwise returns false.
     * @param f The train to remove.
     * @return if the train was removed true and otherwise false.
     */
    public boolean removeTrain(Train f){
        if (isTrnInStation(f) == false){
            return false;
        } // the given train isn't in the station
        _noOfTrs--;
        _station[this.trainIndex(f)] = new Train(_station[_noOfTrs]);
        _station[_noOfTrs] = null;
        return true; 
    }
        
    
    /**
     * Receives a destinaion and if there is\ are journeys to this 
     * destination, it returns the earliest departure of a train from the 
     * station to the destination.
     * @param place The city that is the destination of the journey.
     * @return null if there isn't a train to the destination and otherwise
     * the earlist departure to the destination.
     */
    public Time1 firstDepartureToDestination (String place){
        // array of the departure times of the station's trains to place.
        Time1[] departuresToPlace = new Time1[TRAINS_MAX];
        int trnsToDest = 0;
        
        for (int i=0; i<_noOfTrs; i++){
            if (_station[i].getDestination().equals(place)){ 
                departuresToPlace[trnsToDest] = 
                new Time1(_station[i].getDeparture());
                trnsToDest++;
            } 
        }
        
        if (trnsToDest == 0){
            return null;
        } // there are no trains to place.
        
        Time1 earliestDeparture = departuresToPlace[INDEX_MIN];
        for (int i=1; i<trnsToDest;i++){
            if (earliestDeparture.after(departuresToPlace[i])){
                earliestDeparture = departuresToPlace[i];
            }
        } // finds the earliest departure to place.
        return new Time1 (earliestDeparture);    
    }
        
    
    /**
     * Checks how many of the trains at the day are full.
     * @return The number of full trains at the day.
     */    
    public int howManyFullTrains(){
        int fullTrains = 0;
        for (int i=0; i<_noOfTrs; i++){
            if(_station[i].isFull()){
                fullTrains++;
            }
        }
        return fullTrains;
    }
    
    
    // Returns true if there aren't trains in the station, otherwise false.
    private boolean stationIsEmpty(){
        if(_noOfTrs == TRAINS_MIN){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    /**
     * Returns the most popular city at the day (the city which 
     * is the destination of the biggest amount of trains)
     * @return The most popular destination and null if the station is 
     * empty.
     */
    public String mostPopularDestination(){
        if (this.stationIsEmpty() == true){
            return null;
        } // there are no trains in the station.  
        int rateMostPopDest = 0; 
        int rateOfDestI;
        String mostPopDest = "";
        for (int i=0; i<_noOfTrs;i++){
            rateOfDestI = 0;
            for (int j=i;j<_noOfTrs;j++){
                if (_station[i].getDestination().equals
                   (_station[j].getDestination())){
                    rateOfDestI++; 
                }
            } // finds the popularity rate of a train's destination
              // (without considering the trains that came before it in 
              // the array).
 
            if (rateOfDestI > rateMostPopDest){
                rateMostPopDest = rateOfDestI;
                mostPopDest = _station[i].getDestination();
            } // finds the most popular destination.
        }
        return new String(mostPopDest);
    }
    
    
    /**
     * Returns the train with the most expensive ticket. 
     * @return The train with the most expensive ticket in the station or 
     * null if the station is empty.
     */
    public Train mostExpensiveTicket(){
        if (this.stationIsEmpty() == true){
            return null;
        } // there are no trains in the station.
        
        int priceMostExpTrn = _station[0].getPrice();
        Train mostExpTrn = new Train(_station[0]);
        for (int i=1; i<_noOfTrs; i++){
            if (_station[i].getPrice() > priceMostExpTrn){
                priceMostExpTrn = _station[i].getPrice();
                mostExpTrn = _station[i];
            }
        }
        return new Train (mostExpTrn);
    }
    
    
    /**
     * Return the train that it's journey is the longest.
     * @return The train with the longest journey or null if the station
     * is empty.
     */
    public Train longestTrain(){
        if (this.stationIsEmpty() == true){
            return null;
        } // there are no trains in the station.
        
        int longestDuration = _station[0].getDuration();
        Train trnLongestDuration = new Train(_station[0]);
        for (int i=1; i<_noOfTrs; i++){
            if (_station[i].getDuration() > longestDuration){
                longestDuration = _station[i].getDuration();
                trnLongestDuration = _station[i];
            }
        }
        return new Train(trnLongestDuration);
    }


    /**
     * Returns a string representation of the trains of the station, 
     * or relevant message if the station is empty.
     * @return a string representation of the trains of the station,
     * or relevant message if the station is empty.
     */
    public String toString(){
        if (this.stationIsEmpty() == true){
            return new String ("There are no trains today.");
        }
        String trainsStrings = "The trains today are:\n";
        for (int i=0; i<_noOfTrs; i++){
            trainsStrings += _station[i].toString() + "\n";
        }
        return new String(trainsStrings);
    }
} // end of class RailwayStation.