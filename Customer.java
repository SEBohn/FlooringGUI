/*
 * I'm Floored flooring application.
 * Sarah Bohn, CIS355A
 */
package imfloored;


/**
 * @author Sarah
 */
public class Customer {
    
    private static final String DEFAULT_NAME = "Not Given";
    
    String firstName;
    String lastName;
    String address;
    
    public Customer()
    {
        this.firstName = DEFAULT_NAME;
        this.lastName = DEFAULT_NAME;
      
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
        public String getFullName() {
        return firstName + " " + lastName;
    }
    @Override
    public String toString() {
        return getFullName();
    }
}
