public class Faculty extends Employee{//extend this subclass from the parent
    private String rank;//define the variable which will indicate students major

    public Faculty(){
        super();//along with new variables, it will call back variables from the parent class that was aleady predefined
        rank = "undeclared";//has not been indicated, placeholder
    }
    public Faculty(int i, String n, String a, String p, String e, String po, double s, String rank){
        super(i, n, a, p, e, po, s);//call back the variables defined in the public line above that were already predefined from the parent class
        this.rank = rank;//defining the new variable major in this portion of the subclass
    }
    /**
     * Constructor with one parameter
     * @param rank initial value for the rank
     */

    /**
     * Accessor for the position
     * @return value of the position
     */
    public String getRank(){
        return rank;//getter method for rank
    }
    @Override
    public String toString(){
        return String.format("%sRank: %s\n", super.toString(), rank);//along with the toString method that was called on from the parent class, also including new variable here
    }
    /**
     * Mutator for the rank
     * @param rank value of the rank
     */
    public void setRank(String rank){
        this.rank = rank;//setter method for rank
    }
}