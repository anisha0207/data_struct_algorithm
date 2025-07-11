public class Test{
    public static void main(String[]args){
        Person[] people = new Person [3];//create array of people with the size 3
        people[0] = new Student (123456789, "Paul Leister", "972 4th Street, Allentown", "610-331-7177", "pleister@gmail.com", "CSE");
        people[1] = new Employee (334422110, "Beth Down", "234 Main Street, Philadelphia", "484-222-4433", "bdown@gmail.com", "System Administrator", 75000.00);
        people[2] = new Faculty (222222222, "Mark Jones", "21 Orchid Street, Bethlehem", "610-333-2211", "mjones@gmail.com", "Faculty", 100000.00, "Associate Professor");

        //each row of array is defined, calling onto the subclass while creating Person as the array type

        System.out.println("Original List: ");
        printArray(people);//print the original array 

        System.out.println("\nList sorted by name: ");
        sortArray(people, true); //sort by name, true indicates name sort
        printArray(people);//print the sorted array

        System.out.println("\nList sorted by id: ");
        sortArray(people, false); //sort by id, false indicates id sort
        printArray(people);//print the sorted array
        
    }
    public static void printArray(Person[] people){//printing the array through the for loop 
        for (int i = 0; i<people.length; i++){
            System.out.println(people[i]);
        }
    }
    public static void sortArray(Person[] people, boolean sort) {//sorting the array through selection sort
        for (int i = 0; i < people.length - 1; i++) {//the boolean indicates true for sorting name (string) adn false for id (int)
            int index = i;
            for (int j = i + 1; j < people.length; j++) {//through each iteration of the array, it is sorted by calling onto the getName or getID method from the subclass
                if (sort){
                    if (people[j].getName().compareTo(people[index].getName()) < 0) {
                        index = j; //this selection sort is done through strings
                    }
                }
                else{    
          	        if(people[j].getID() < people[index].getID()){
             		    index=j;//this selection sort is done through int
                    }
                }
            }
            Person temp = people[i];//the swapping starts here 
      		people[i] = people[index];
      		people[index] = temp;
        
        }
    }

}