public class Rectangle extends Shape{
    private double width, length;

    public Rectangle(){
        super();
        width = length = 0.0;
    }
    public Rectangle(String c, double l, double w){
        super(c);
        width = w; length = l;
    }
    /**Constructor with two parameters
     * @param length inital value for the length of the rectangle
     * @param width inital value for the width of the rectangle 
     */
    /**Accessor for the length and the width
     * @return value of the length and width
     */
    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
/**Mutator for the length and width
 * @param length value of the length
 * @param width value of the width
 */
    public void setWidth(double w){
        width = w;
    }
    public void setLength(double l){
        length = l;
    }

    public String toString(){
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f", "Rectangle", super.toString(), length, width, getArea(), getPerimeter());
    }

    public double getPerimeter(){//calls onto the getPerimeter method from shapes to create a formula
        return (width *2) + (length*2);
    }

    public double getArea(){//calls onto the getArea method from shapes to create a formula
        return length * width;
    }
    public void scale(double f){//scalable java class of the circle 
        width *= f;
        length *= f;
    }
    public Object clone(){//cloneable object from the interface
        return new Rectangle (getColor(), length, width);
    }
}