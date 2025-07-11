/**
 * Abstract class Person to model the entity Person
 */
public abstract class Person{//this is the parent class that subclasses will inherit later on
    // Data members 
    protected int id;//these variables are protected to ensure these variables will be used throughout all subclasses 
    protected String name, address, phone, email;
    /**
     * Default constructor
     */
    protected Person(){//protected is used here to restrict the visibility of class, method and variable 
        this(0, "none", "none", "none", "none");//placeholder defaults for these defined variables; it is also protected 
    }
    /**
     * Constructor with five parameters
     * @param id initial value for the id
     * @param name initial value for the name
     * @param address initial value for the address
     * @param phone initial value for the phone number
     * @param email initial value for the email address
     */
    protected Person(int id, String name, String address, String phone, String email){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    /**
     * Accessor for the id
     * @return value of the id
     */
    public int getID(){//getter method for ID
         return id;
    }
    /**
     * Accessor for the name
     * @return value of the name
     */
    public String getName(){//getter method for name
        return name;
    }
    /**
     * Accessor for the address
     * @return value of the address
     */
    public String getAddress(){//getter method for address
        return address;
    }
    /**
     * Accessor for the phone
     * @return value of the phone
     */
    public String getPhone(){//getter method for phone
        return phone;
    }
    /**
     * Accessor for the email address
     * @return value of the email address
     */
    public String getEmail(){//getter method for email
        return email;
    }
    /**
     * Accessor for the Person attributes
     * @return formatted string with the object attributes
     */
    @Override //override method is great for a check off point when compiling-- great for practice
    public String toString(){
        String str = String.format("ID: %d\nName: %s\nAddress: %s\nPhone: %s\nEmail: %s\n", 
                                        id, name, address, phone, email);
        return str;
    }
    /**
     * Mutator for the id
     * @param id value of the id
     */
    public void setID(int id){
        this.id = id;
    }
    /**
     * Mutator for the name
     * @param name value of the name
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Mutator for the address
     * @param address value of the address
     */
    public void setAdress(String address){
        this.address = address;
    }
    /**
     * Mutator for the phone number
     * @param phone value of the phone number
     */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /**
     * Mutator for the email address
     * @param email value of the email address
     */
    public void setEmail(String email){
        this.email = email;
    }
}