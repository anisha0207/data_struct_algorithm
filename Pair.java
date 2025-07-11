public class Pair <E1,E2>{
    private E1 first;
    private E2 second;
/** * @param <E1> the type of the first element
 * @param <E2> the type of the second element
 */ 

    public Pair (E1 f, E2 s){
        first = f;
        second = s;
    }

    /**
     * @return first
     */
    public E1 getFirst () { return first;}
    /**
     * @return second
     */
    public E2 getSecond() {return second;}

    /**
     * @param f
     */
    public void setFirst (E1 f) {first = f;}
    /**
     * @param s
     */
    public void setSecond (E2 s) {second = s;}
//rerpesetn the pair
    @Override
    public String toString(){
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
    //true if object is pair and both elements are equal, otherwise false
    @Override
    public boolean equals (Object o){//after creating the instanceof command to specificy the object o as pair, the equals will return true if both data fields are equal
        if (o instanceof Pair){
            Pair<E1,E2> p = (Pair) o;
            return this.getFirst().equals(p.getFirst())&& this.getSecond().equals(p.getSecond());
        }
        return false;
}
}
