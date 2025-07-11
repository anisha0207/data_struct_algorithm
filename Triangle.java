public class Triangle extends Shape{
    private double side1, side2, side3;

    public Triangle(){
        super();
        side1 = side2 = side3 = 1.0;
    }
    public Triangle(String c, double s1, double s2, double s3){
        super(c);
        side1 = s1; side2 = s2; side3 = s3;
    }
    /**Constructor with three parameters
     * @param side1 holds value of side1 of triangle
     * @param side2 holds value of side2 of triangle
     * @param side3 holds value of side3 of triangle
     */
    /**Accessor for side1, side2, side3
     * @return value for side1, side2, side3
     */
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }
    /**Mutator for side1, side2, side3 
     * @param side1 holds value of side1 of triangle
     * @param side2 holds value of side2 of triangle
     * @param side3 holds value of side3 of triangle 
    */
    public void setSide1(double s){
        side1 = s;
    }
    public void setSide2(double s){
        side2 = s;
    }
    public void setSide3(double s){
        side3 = s;
    }

    public String toString(){
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f", "Triangle", super.toString(), side1, side2, side3, getArea(), getPerimeter());
    }

    public double getPerimeter(){//calls onto the getPerimeter method from shapes to create a formula
        return side1+side2+side3;
    }

    public double getArea(){//calls onto the getArea method from shapes to create a formula
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p-side1) * (p-side2) * (p-side3));
    }
    public void scale(double f){//scalable java class of the circle 
        side1 *= f;
        side2 *= f;
        side3 *= f;
    }
    public Object clone(){//cloneable object from the interface
        return new Triangle (getColor(), side1, side2, side3);
    }
}