import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.PriorityQueue;
public class DSTest3{
    public static void main(String[] args) {
        Collection<String> [] ds = new Collection[5];
        ds[0] = new ArrayList<>();
        ds[1] = new LinkedList<>();
        ds[2] = new Stack<>();
        ds[3] = new LinkedList<>();
        ds[4] = new PriorityQueue<>();

        String[] fruits = {"Orange","Kiwi","Pomegranate","Melon","Apple","Banana","Strawberry" };
        String[] names = {"ArrayList","LinkedList","Stack","Queue","PriorityQueue"};
        // Using data structure specific methods
        for(int i=0; i<fruits.length; i++) {
            ds[0].add(fruits[i]);
            ((LinkedList)ds[1]).addFirst(fruits[i]);
            ((Stack)ds[2]).push(fruits[i]);
            ((LinkedList)ds[3]).offer(fruits[i]);
            ((PriorityQueue)ds[4]).offer(fruits[i]);
        }
        System.out.println("\nUsing DS specific interface");
        System.out.print("\nArray List: [");
        for(int i=0; i<fruits.length; i++) {
            System.out.print(((ArrayList)ds[0]).get(i) + " ");
        }
        System.out.println("]");
        System.out.print("\nLinked List: [");
        while(((LinkedList)ds[1]).size() != 0) {
            System.out.print(((LinkedList)ds[1]).getLast() + " ");
            ((LinkedList)ds[1]).removeLast();
        }
        System.out.println("]");
        System.out.print("\nStack: [");
        while(!ds[2].isEmpty())
            System.out.print(((Stack)ds[2]).pop() + " ");
        System.out.println("]");

        System.out.print("\nQueue: [");
        while(!ds[3].isEmpty())
            System.out.print(((LinkedList)ds[3]).poll() + " ");
        System.out.println("]");

        System.out.print("\nPriority Queue: [");
        while(!ds[4].isEmpty())
            System.out.print(((PriorityQueue)ds[4]).poll()+ " ");
        System.out.println("]\n");
    }
}