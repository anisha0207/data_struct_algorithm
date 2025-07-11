public abstract class Shape implements Comparable<Shape>, Cloneable, Scalable{//the main parent class which implements comparable and cloneable which are already inbedded in the java.lang, and also Scalable whcih is created as separate java class
    private String color;//color is created 
    protected Shape(){
        color = "Black";//default color
    }
    protected Shape (String color){
        this.color = color;//it is under protected due to abstract class
    }
    /**
    * Constructor with one parameter
   * @param color initial value of the color
   */
  /** Accessor for the color
   * @return value of the color
  */
    public String getColor(){
        return color;
    }
    /**Mutator for the color
     * @param color value of the color
     */
    public void setColor(String c){
        color = c;
    }
    public String toString(){
        return color;
    }
    public int compareTo(Shape s){//comparing the value of the area 
        if (this.getArea() == s.getArea()){
            return 0;//if it is equal
        }
        else if (this.getArea() > s.getArea()){
            return 1;//greater
        }
        else{
            return -1;//less
        }
    }
    public abstract double getArea();//creates area and perimeter for shapes to create a formula underneath these classes
    public abstract double getPerimeter();
    public abstract Object clone();//calls on cloneable 
    public abstract void scale(double factor);//calls on scaleable
}