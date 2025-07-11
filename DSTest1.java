import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.PriorityQueue;
public class DSTest1{
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
        // Using iterators
        System.out.println("Using Iterators");
        for(int i=0; i<5; i++){
            Iterator<String> iterator = ds[i].iterator();
            System.out.print(names[i] + ": ");
            print(iterator);
        }
        System.out.println();
    }
    public static <E> void print(Iterator<E> iterator){
        System.out.print("[ ");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println("]");
    }
}
