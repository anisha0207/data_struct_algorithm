public class Student extends Person{//extend this subclass from the parent
    private String major;//define the variable which will indicate students major

    public Student(){
        super();//along with major, it will call back variables from the parent class that was aleady predefined
        major = "undeclared";//has not been indicated, placeholder
    }
    public Student(int i, String n, String a, String p, String e, String major){
        super(i, n, a, p, e);//call back the variables defined in the public line above that were already predefined from the parent class
        this.major = major;//defining the new variable major in this portion of the subclass
    }
     /**
     * Constructor with one parameter
     * @param major initial value for the rank major
     */

    /**
     * Accessor for the major
     * @return value of the major
     */
    public String getMajor(){
        return major;//getter method is used to retrieve the major
    }
    @Override //override method is great for a check off point when compiling-- great for practice
    public String toString(){
        return String.format("%sMajor: %s\n", super.toString(), major);//along with the toString method that was called on from the parent class, also including major here
    }
    /**
     * Mutator for the major
     * @param major value of the major
     */
    public void setMajor(String major){
        this.major = major;//setter method to set the variable 
    }
}