import java.util.ArrayList;
import java.util.Comparator;
public class Test {
    public static <E> void print (ArrayList<E> list){//print out the list of the fractions through a for each loop
        for (E r : list){
            System.out.println(r);
        }
    }
    public static <E> int search(ArrayList<E> list, E key){//search the array using the helper method below, starting from index 0
            return searchHelp(list, key, 0);
    }
    public static <E> int searchHelp(ArrayList<E> list, E key, int index){//this helper method will detect if the index is greater than the size, it will return -1
        if (index >= list.size()){
            return -1;
        }
        if (list.get(index).equals(key)){//will print index if the index is equal to the key 
            return index;
        }
        return searchHelp(list, key, index + 1);//keep searching 
    }
    public static <E> void sort (ArrayList<E> list, Comparator <E> c){//sort the array list from minimum to maximum
            for(int i=0; i<list.size(); i++){
               int minIndex = i;
               for(int j=i+1; j<list.size(); j++)     
                   if(c.compare(list.get(j), list.get(minIndex)) < 0){
                    minIndex = j;
                   }
               E temp = list.get(i);
               list.set(i,list.get(minIndex));
               list.set(minIndex, temp);
           }
    }
    public static void main(String[] args){
        // Test the class Rational
        System.out.println("\nTest case 1: Arithmetic on Fractions");
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 2);
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 +  " - " + r2 + " = " + r1.sub(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.mult(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.div(r2));

        System.out.println("\nTest case 2: Arithmetic on Fractions");
        r1 = new Rational(2, 3);
        r2 = new Rational(3, 5);
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.sub(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.mult(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.div(r2));

        System.out.println("\nTest case 3: Arithmetic on Fractions");
        r1 = new Rational(1, 4);
        r2 = new Rational(3, 4);
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.sub(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.mult(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.div(r2));

        System.out.println("\nTest case 4: Arithmetic on Fractions");
        r1 = new Rational(4, 8);
        r2 = new Rational(3, 9);
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.sub(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.mult(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.div(r2));

        // Creating a dataset of numbers
        ArrayList<Number> numbers = new ArrayList<>(25);
        for(int i=0; i<5; i++){
            numbers.add(new Rational((int)(Math.random()*10), (int)(Math.random()*9)+1));
        }
        for(int i=0; i<5; i++){
            numbers.add((int)(Math.random()*1000000000));
        }
        for(int i=0; i<5; i++){
            numbers.add((long)(Math.random()*10000000000L));
        }
        for(int i=0; i<5; i++){
            numbers.add(Math.random()*1e20);
        }
        for(int i=0; i<5; i++){
            numbers.add(Math.random()*1e40);
        }
        java.util.Collections.shuffle(numbers);

        // print the list of numbers
        System.out.println("\n\nTest case 5: Generic print method");
        System.out.println("List of Numbers");
        print(numbers);

        // Test Searching for a number
        System.out.println("\n\nTest case 6: Generic Search Method (fail)");
        Number n = new Rational(3,4);
        int index = search(numbers, n);
        if(index == -1){
            System.out.println("Number " + n + " not found.");
        }
        else{
            System.out.println("Number " + n + " found at index " + index);
        }

        System.out.println("\nTest case 7: Generic Search Method (success)");
        n = numbers.get(4);
        index = search(numbers, n);
        if(index == -1){
            System.out.println("Number " + n + " not found.");
        }
        else{
            System.out.println("Number " + n + " found at index " + index);
        }

        System.out.println("\nTest case 8: Generic Search Method (success)");
        n = numbers.get(9);
        index = search(numbers, n);
        if(index == -1){
            System.out.println("Number " + n + " not found.");
        }
        else{
            System.out.println("Number " + n + " found at index " + index);
        }

        System.out.println("\nTest case 9: Generic Search Method (success)");
        n = numbers.get(12);
        index = search(numbers, n);
        if(index == -1){
            System.out.println("Number " + n + " not found.");
        }
        else{
            System.out.println("Number " + n + " found at index " + index);
        }

        System.out.println("\nTest case 10: Generic Search Method (fail)");
        n = 35.75;
        index = search(numbers, n);
        if(index == -1){
            System.out.println("Number " + n + " not found.");
        }
        else{
            System.out.println("Number " + n + " found at index " + index);
        }
        // Test Sorting by double
        System.out.println("\n\nTest case 11: Generic Sort Method with a Comparator");
        sort(numbers, new ComparatorByDouble());
        System.out.println("List of Numbers sorted by their double values");
        print(numbers);
    }         
}
