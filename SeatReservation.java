import java.util.Scanner;
import java.util.InputMismatchException;
public class SeatReservation{
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);
        int operation = 0;
        Airplane plane = new Airplane("seatmap.txt");//the file name
    do{    //creating a choice that will loop around based on reader's input, once it types 3, it will exti out of this loop

        System.out.println(plane);

        System.out.println("Please select an operation:");//creating a menu
        System.out.println("1: Reserve a seat\n2: Free a seat\n3: Quit");
        try{
            operation = scan.nextInt();
            String seatNumber;
            switch(operation){
                case 1: //reserve seat, calling back from Airplane
                    System.out.println("Enter a seat number:");
                    seatNumber = scan.next();
                    if (plane.reserveSeat(seatNumber)){
                        System.out.println(seatNumber + " successfully reserved.");
                    }else{// already reserved
                        System.out.println(seatNumber + " already reserved.");
                    }
                    break;
                case 2: //free seat, calling back from Airplane
                    System.out.println("Enter a seat number:");
                    seatNumber = scan.next();
                    if (plane.freeSeat(seatNumber)){
                        System.out.println(seatNumber + " successfully freed.");
                    }else{// already reserved
                        System.out.println(seatNumber + " already freed.");
                    }
                    break;
                case 3: //quit
                    plane.saveMap("seatmap.txt");
                    break;
                default:
                    System.out.println("Invalid operation (1 to 3).");
            }
        }
        catch (InvalidSeatException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Invalid input operation");
            scan.next();
        }
    }while (operation != 3);
    } 
}