import java.io.File;//all of these imports are added here for exception rule besides the scanner object, these are ways to get the file along with highlighting the exceptions
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Airplane{
    private char [][] seatMap;

    public Airplane(){//this is a table which will store a 9x8 table of empty reserved seatings
        seatMap = new char[9][8];
        for (int i =0; i<seatMap.length; i++){
            for (int j =0; j<seatMap.length; j++){
                seatMap[i][j] = '.';
            }
        }
    }
    public Airplane (String filename){//the table is declared here again
        seatMap = new char[9][8];
        readMap(filename);
    }
    public void readMap(String filename){//using the file, the reader will read from the file 
        File file = new File (filename);
        try {
            Scanner readFile = new Scanner (file); //open the file for reading
            for (int i = 0; i<seatMap.length; i++){
                for (int j = 0; j< seatMap[i].length; j++){
                    seatMap[i][j] = readFile.next().charAt(0);//read one character from the file
                }
            }
            readFile.close();//close the file
        }
        catch (FileNotFoundException e){//one exception rule if the file is not found, it will still return the seating chart
            for (int i =0; i<seatMap.length; i++){
                for (int j =0; j<seatMap[i].length; j++){
                    seatMap[i][j] = '.';
                }
            }
        }
    }
    private boolean checkSeatNumber(String seatNumber) throws InvalidSeatException{//the seating chart will match with the letters and the numbers based on the reader's input, if typed otherwise it will be false
        if (seatNumber.matches ("[1-9][A-H]")){
            return true;
        }
        throw new InvalidSeatException ("Invalid Seat Number " + seatNumber + ". Must be [1-9][A-H]");
    }
    public boolean reserveSeat(String seatNumber) throws InvalidSeatException{//to reserve the seat based off of reader's input, it must scan through the chart to be able to locate that arrangement
        if (checkSeatNumber(seatNumber)){
            int row = seatNumber.charAt(0) - '1';//each row corresponds to the numbers from 1-9
            int col = seatNumber.charAt(1) - 'A';//each column corresponds to the letters from A-H
            if (seatMap[row][col] == '.'){
                seatMap[row][col] = 'X';//. turns into X indicating that it is reserved
                return true;//if the input is found or matches
            }else{
                return false;//if not found or invalid type from the input
            }
        }
        return false;
        
    }
    public boolean freeSeat (String seatNumber) throws InvalidSeatException{//free a seat that has already been reserved
        checkSeatNumber(seatNumber);
        int row = seatNumber.charAt(0) - '1';//1-9 row
        int col = seatNumber.charAt(1) - 'A';//A-H column
        if (seatMap[row][col] == 'X'){
            seatMap[row][col] = '.';//the X turns into . indicating that it is now unreserved seating
            return true;
        }
        return false;
        
    }
    public void saveMap (String filename){//allows for edit 
        try{
            PrintWriter writeFile = new PrintWriter (new File (filename));
            for (int i = 0; i<seatMap.length; i++){
                for (int j = 0; j<seatMap[i].length; j++){
                    writeFile.print(seatMap[i][j] + " ");//write to file
                }
            }
            writeFile.close();//close file
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot write to file");
        }
    }
    @Override
    public String toString(){//how th etable is displayed
        StringBuilder out = new StringBuilder (); 
        out.append("\tA\tB\tC\tD\tE\tF\tG\tH\n");//for columns A-H
        for (int i = 0; i< seatMap.length; i++){
            out.append((i+1) + "\t");//for rows 1-9
            for (int j = 0; j < seatMap[i].length; j++){
                out.append(seatMap[i][j]+"\t");
            }
            out.append("\n");
        }
        return out.toString();
    }
}