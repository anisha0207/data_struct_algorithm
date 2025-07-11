public class Pentagon extends Shape{
    private double side;

    public Pentagon(){
        super();
        side = 0.0;
    }
    public Pentagon(String c, double s){
        super(c);
        side = s;
    }
    /**Constructor with one parameter
     * @param side inital value for the side of the pentagon
     */
    /**Accessor for the side
     * @return value of the side
     */
    public double getSide(){
        return side;
    }
    /**Mutator for the side
     * @param side holds the value of the side
     */
    public void setSide(double s){
        side = s;
    }

    public String toString(){
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f", "Pentagon", super.toString(), side, getArea(), getPerimeter());
    }

    public double getPerimeter(){//calls onto the getPerimeter method from shapes to create a formula
        return (side * 5);
    }

    public double getArea(){//calls onto the getArea method from shapes to create a formula
        return (Math.sqrt(5 * (5 + 2 * (Math.sqrt(5))) * side * side)) / 4;
    }
    public void scale(double f){//scalable java class of the circle 
        side *= f;
    }
    public Object clone(){//cloneable object from the interface
        return new Pentagon (getColor(), side);
    }
}