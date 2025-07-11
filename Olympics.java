import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.util.Scanner;
import java.util.Comparator;
import java.io.FileNotFoundException;
import java.util.Collections;
//define the arraylist for country and athlete
public class Olympics {
    private ArrayList<String> countries;
    private ArrayList<Athlete> athletes;

//O(n^2)
//reads the file from country and athlete -- lists them out based on the medals if there is for the athlete
    public void read(ArrayList<Athlete> athletes, String filename){
        File file = new File(filename);
        try {
            Scanner read = new Scanner(file);
            if (read.hasNextLine()){
                read.nextLine();
            } // Skip the header line

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] input = line.split(",");

                int id = Integer.parseInt(input[0]);//saprates each line of list in categories 
                String name = input[1];
                String country = input[2];
                int year = Integer.parseInt(input[3].trim());
                String medalType = (input[4]);
                //int type = Integer.parseInt(input[4]);
                int type = -1;
                if(input[4].equals("Gold")){
                    type = 0;
                }else if(input[4].equals("Silver")){
                    type = 1;
                }else if (input[4].equals("Bronze")){
                    type = 2;
                }
                
                Athlete a = find(new Athlete(id, name, country));
                if (a == null){
                    a = new Athlete(id, name, country);
                    add(a);
                }
                if (type != -1){
                    a.addMedal(year, type);
                }
                
            }
            read.close();
        } catch (Exception e){//witin try and catch rule
            System.out.println("Cannnot find Athletes File ");
        }

    }
//this is the main methid using helper method from athlete file and adding the coutnry file in this method
    public Olympics(String athleteFilename, String countryFilename){
        countries = new ArrayList<>(100000);
        athletes = new ArrayList<>(100000);

        read(athletes, athleteFilename);

        File file2 = new File(countryFilename);
        try {
            Scanner read = new Scanner(file2);
            while (read.hasNextLine()) {
                countries.add(read.nextLine().trim());
            }
            read.close();
        }
        catch (FileNotFoundException e){
            System.out.println("file not found: ");
        }
        
    }

//use add methof to add athletes that match 
    public void add (Athlete a){
        athletes.add(a);
    }
    //use equal methof to find athletes that match 
    public Athlete find (Athlete a){
        for (Athlete f : athletes){
            if (f.equals(a)){
                return f;
            }
        }
        return null;
    }
    //use remove methof to remove athletes that match 
    public Athlete remove (Athlete a){
        for (Athlete f : athletes){
            if (f.equals(a)){
                Athlete a1 = f;
                athletes.remove(a);
                return f;
            }
        }
        return null;
    }
    //number of counts is the size of the athletes array 
    public int getAthleteCount(){
        return athletes.size();
    }
    //number of counts is the size of the countries array 
    public int getCountryCount(){
        return countries.size();
    }
    //O(nlogn)
    //sorting by creting a comparator method that compares the gettotal medals of two thigns within athlete type 
    public void viewTopTenAthletes(int year){
        class AthleteComparator implements Comparator<Athlete>{
            public int compare(Athlete p1, Athlete p2){
                return p2.getTotalMedals(year)-p1.getTotalMedals(year);
            }
        }
        //make short list
        ArrayList<Athlete> sortedA = new ArrayList<>();
        Iterator <Athlete> iteration = athletes.iterator();
        //sort them
        while(iteration.hasNext()){
            Athlete a = iteration.next();
            if (a.getTotalMedals(year) > 0){
                sortedA.add(a);
            }
            //create a pair with a and total, add the pair to sortedA
        }
        //create class comparatorbysecond for athlete integer--compare
        //print the last step
        sortedA.sort(new AthleteComparator());
        for (int i = sortedA.size() -1; i>= sortedA.size()-10; i--){
            System.out.printf("%-10d\t%-50s\t%-5s\t%-10d\n", sortedA.get(i).getID(), sortedA.get(i).getName(), sortedA.get(i).getCountry(), sortedA.get(i).getTotalMedals());
        }
    }
    //O(nlogn)
    public void viewTopTenAthletes(){
        //make short list, printing out athletes by running through the size of atheletes
        athletes.sort(null);
        for (int i = athletes.size() - 1; i >= athletes.size() - 10; i--){
            System.out.printf("%-10d\t%-50s\t%-5s\t%-10d\n", athletes.get(i).getID(), athletes.get(i).getName(), athletes.get(i).getCountry(), athletes.get(i).getTotalMedals());
        }
    }
    //O(cn + clogc)
    public void viewTopTenCountries(int year){
        //sorting by creting a comparator method that compares the gettotal medals of two thigns within country type  in string
        //make short list
        ArrayList<Pair<String, Integer>> c = new ArrayList<>();

        
        for (Athlete a : athletes) {
            String country = a.getCountry();
            int medals = a.getTotalMedals(year);

        //crete a boolean statement to compare the country from first and second method
            boolean found = false;
            for (Pair<String, Integer> entry : c) {
                if (entry.getFirst().equals(country)) {
                    entry.setSecond(entry.getSecond() + medals);
                    found = true;
                    break;
                }
            }
            if (!found) {
                c.add(new Pair<>(country, medals));
            }
        }

        // Sorts the countries by total medals in descending order 
        Collections.sort(c, new Comparator<Pair<String, Integer>>() {
            @Override//for the collection method where it is necesary when comparing two thigns from the string type of Coutnry
            public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2) {
                return Integer.compare(p2.getSecond(), p1.getSecond());
            }
        });

        System.out.println("Top Ten Medaled Countries in the Olympics " + year);
        for (int i = 0; i < Math.min(10, c.size()); i++) {
            Pair<String, Integer> find = c.get(i);
            System.out.println(find.getFirst() + " " + find.getSecond());
        }
        //look at the last ten
    }
    //O(cn + clogc)
    public void viewTopTenCountries(){
        ArrayList<Pair<String, Integer>> c = new ArrayList<>();

        // Accumulate total medals for each country on all years 
        for (Athlete athlete : athletes) {
            String country = athlete.getCountry();
            int medals = athlete.getTotalMedals();

            //find or add the country 
            boolean found = false;
            for (Pair<String, Integer> find : c) {
                if (find.getFirst().equals(country)) {
                    find.setSecond(find.getSecond() + medals);
                    found = true;
                    break;
                }
            }
            if (!found) {
                c.add(new Pair<>(country, medals));
            }
        }

        // Sorts the countries by total medals descend 
        Collections.sort(c, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2) {
                return Integer.compare(p2.getSecond(), p1.getSecond());
            }
        });

        System.out.println("Top Ten Medaled Countries in Olympic history");
        for (int i = 0; i < Math.min(10, c.size()); i++) {
            Pair<String, Integer> find = c.get(i);
            System.out.println(find.getFirst() + " " + find.getSecond());
        }
       
    }
} 


