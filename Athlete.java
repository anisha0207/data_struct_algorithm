import java.util.LinkedList;
//O(1)
public class Athlete implements Comparable<Athlete>{
    private int id;
    private String name;
    private String country;
    private LinkedList<Pair<Integer, Triple<Integer,Integer,Integer>>> medals;

    /**
     * @param id      the unique identifier of the athlete
     * @param name    the name of the athlete
     * @param country the country represented by the athlete
     */

    //O(1)
    public Athlete(int id, String name, String country){
        this.id = id;
        this.name = name;
        this.country = country;
        this.medals = new LinkedList<>();
    }
    //O(1)
    /**
     * Returns the athlete's ID.
     *
     * @return the athlete's unique ID
     */
    public int getID(){
        return id;
    }
    //O(1)
    /**
     * Returns the athlete's name.
     *
     * @return name
     */
    public String getName(){
        return name;
    }
    //O(1)
    /**
     * Returns the athlete's country.
     *
     * @return country
     */
    public String getCountry(){
        return country;
    }
//O(1)
/**
     * Sets the athlete's ID.
     *
     * @param id
     */
    public void setID(int id){
        this.id = id;
    }
    //O(1)
    /* * Sets the athlete's name.
     *
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }
    //O(1)
    /**
     * Sets the athlete's country.
     *
     * @param country
     */

    public void setCountry(String country){
        this.country = country;
    }

    /*
     * This returns total number of medals fromthe athletewithint he specified year
     */
    //O(m)
    public int getTotalMedals(int year){
        for (Pair<Integer, Triple<Integer,Integer,Integer>> pair : medals){
            if (pair.getFirst() == year){
                Triple<Integer, Integer, Integer> counts = pair.getSecond();
                return counts.getFirst() + counts.getSecond() + counts.getThird();
            }
        }
        return 0;
    }

    /*
     * Method returns the total number of medals won by the athlete in all years
     */
    //O(m)
    public int getTotalMedals(){
        int total = 0;
        for (Pair<Integer, Triple<Integer,Integer,Integer>> pair : medals){
            Triple<Integer, Integer, Integer> counts = pair.getSecond();
            total += counts.getFirst() + counts.getSecond() + counts.getThird();
        }
        return total;
    }
//O(m)
    public void addMedal(int year, int type){
        boolean found = false;//adds the medals using the boolean statement whether it is in the array list--
        //type of medal (0: gold, 1: silver, 2: bronze)
        for(Pair<Integer, Triple<Integer,Integer,Integer>> medal : medals){
            if (medal.getFirst().equals(year)){
                Triple<Integer,Integer,Integer> m = medal.getSecond();
                if (type == 0){
                    m.setFirst(m.getFirst() + 1);
                } else if (type == 1){
                    m.setSecond(m.getSecond() + 1); 
                } else if (type == 2){
                    m.setThird(m.getThird() + 1);
                }
                found = true;
                break;
            }
        }
        if (!found){
            Triple<Integer,Integer,Integer> count = new Triple<>(0,0,0);
            if (type == 0){
                count.setFirst(1);
            } else if (type == 1) {
                count.setSecond(1);
            } else if (type == 2) {
                count.setThird(1);
            }
            medals.add(new Pair<>(year, count));
            }
    }
//O(1)
    public String toString(){//prints
        return String.format("%-10d\t%-10s\t\t%-10s\t%-10d", id, name, country, getTotalMedals());
    }
//O(m)
    public int compareTo(Athlete a){//compares this athlete with another
        return getTotalMedals() - a.getTotalMedals();
    }
//O(1)
    public boolean equals(Object o){//comapres object to ID otherwise false
        if (o instanceof Athlete){
            Athlete a = (Athlete) o;
            return a.id == this.id;
        }
        return false;
    }
}
