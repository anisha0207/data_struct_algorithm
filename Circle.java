public class Circle extends Shape{
    private double radius;

    public Circle(){
        super();
        radius = 0.0;
    }
    public Circle(String c, double r){
        super(c);
        radius = r;
    }
    /**Constructor with one parameter
     * @param radius initial value of the radius
     */
    /** Accessor for the radius
     * @return value for the radius
     */
    public double getRadius(){
        return radius;
    }
    public void setRadius(double r){
        radius = r;
    }
    /**Mutator for the radius
     * @param radius value of the radius
     */

    public String toString(){
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f", "Circle", super.toString(), radius, getArea(), getPerimeter());
    }


    public double getPerimeter(){//calls onto the getPerimeter method from shapes to create a formula
        return Math.PI *2*radius;
    }

    public double getArea(){//calls onto the getArea method from shapes to create a formula
        return Math.PI * radius * radius;
    }
    public void scale(double f){//scalable java class of the circle 
        radius *= f;
    }
    public Object clone(){//cloneable object from the interface 
        return new Circle (getColor(), radius);
    }
}