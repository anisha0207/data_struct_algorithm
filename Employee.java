public class Employee extends Person{//extend this subclass from the parent
    private String position;//define the variable which will indicate students major
    private double salary;

    public Employee(){
        super();//along with new variables, it will call back variables from the parent class that was aleady predefined
        position = "undeclared";//has not been indicated, placeholder
        salary = 0.0;
    }
    public Employee(int i, String n, String a, String p, String e, String position, double salary){
        super(i, n, a, p, e);//call back the variables defined in the public line above that were already predefined from the parent class
        this.position = position;//defining the new variable major in this portion of the subclass
        this.salary = salary;
    }
    /**
     * Constructor with two parameters
     * @param position initial value for the position
     * @param salary initial value for the salary
     */

    /**
     * Accessor for the position
     * @return value of the position
     */
    public String getPosition(){
        return position;//getter method for position
    }
    /**
     * Accessor for the salary
     * @return value of the salary
     */
    public double getSalary(){
        return salary;//getter method for salary
    }
    @Override
    public String toString(){//along with the toString method that was called on from the parent class, also including new variable here
        return String.format("%sPosition: %s\nAnnual Salary: $%.2f\n", super.toString(), position, salary);
    }
    /**
     * Mutator for the position
     * @param position value of the position
     */
    public void setPosition(String position){
        this.position = position;//setter method for position
    }
    /**
     * Mutator for the salary
     * @param salary value of the salary
     */
    public void setSalary(double salary){
        this.salary = salary;//setter method for salary
    }
}