public class Triple<E1, E2, E3>{
    private E1 first;
    private E2 second;
    private E3 third;

    /**
 * @param <E1> the type of the first element
 * @param <E2> the type of the second element
 * @param <E3> the type of the third element
 */
    public Triple (E1 f, E2 s, E3 t){
        first = f;
        second = s;
        third = t;
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
    /**
     * @return third
     */
    public E3 getThird () { return third;}
    
    /**
     * @param third
     */
    public void setThird (E3 t) {third = t;}
//return the string of the triple here
    @Override
    public String toString(){
        return "(" + first.toString() + ", " + second.toString() + ", " + third.toString() + ")";
    }
}
