public class InvalidSeatException extends Exception{//creates an exception class that will be used in other class objects
    public InvalidSeatException(){
        super("Invalid Seat Number");
    }
    public InvalidSeatException (String message){
        super(message);
    }
    
}