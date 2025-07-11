import java.util.Comparator;
public class ComparatorByDouble implements Comparator<Number>{//implementing interface Comparator for type Number
    @Override
    public int compare(Number obj1, Number obj2){//defines compare method to comapre obj1 and obj2 of the type Number
        double num1 = obj1.doubleValue();//stores obj1 as the double value
        double num2 = obj2.doubleValue();//stores obj2 as the double value
        return Double.compare(num1, num2);//uses the compare() method to compare values above
    }
    
}
