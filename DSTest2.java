import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.PriorityQueue;
public class DSTest2{
    public static void main(String[] args) {
        Collection<String> [] ds = new Collection[5];
        ds[0] = new ArrayList<>();
        ds[1] = new LinkedList<>();
        ds[2] = new Stack<>();
        ds[3] = new LinkedList<>();
        ds[4] = new PriorityQueue<>();

        String[] fruits = {"Orange","Kiwi","Pomegranate","Melon", "Apple","Banana","Strawberry"};
        String[] names = {"ArrayList","LinkedList","Stack","Queue","PriorityQueue"};

        // Using add() from Interface Collection
        for(int i=0; i<fruits.length; i++) {
            for(int j=0; j<5; j++)
                ds[j].add(fruits[i]);
        }
        // Using toString()
        System.out.println("Using toString()");
        for(int i=0; i<5; i++){
            System.out.println(names[i] + ": " + ds[i]);
        }
    }
}
