
/** Project: Lab 3
 * Purpose Details: Customer CRUD
 * Course: IST 242
 * Author: Matthew Sulpizio
 * Date Developed: 2/20/26
 * Last Date Changed: 3/1/26
 * Rev:

 */

/**
 * Represents a retail store customer.
 * Stores identity and contact information along with membership level.
 */
public class Customer {
    /** The unique customer id. */
    private int id;
    /** The customer's first name. */
    private String firstName;
    /** The customer's last name. */
    private String lastName;
    /** The customer's age. */
    private int age;
    /** The customer's email. */
    private String email;
    /** The customer's phone number. */
    private String phone;
    /** The customer's street address. */
    private String address;
    /** The customer's membership level */
    private String membership;

    /**
     * Default constructor.
     */
    public Customer() {}

    /**
     * Constructs a Customer with all fields set.
     *
     * @param id The unique customer id.
     * @param firstName The customer's first name.
     * @param lastName The customer's last name.
     * @param age The customer's age.
     * @param email The customer's email.
     * @param phone The customer's phone number.
     * @param address The customer's street address.
     * @param membership The customer's membership level.
     */
    public Customer(int id, String firstName, String lastName, int age,
                    String email, String phone, String address, String membership) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.membership = membership;
    }

    /**
     * Returns the customer id.
     * @return The customer id.
     */
    public int getId() { return id; }
    /**
     * Sets the customer id.
     * @param id The customer id to set.
     */
    public void setId(int id) { this.id = id; }

    /**
     * Gets the customer's first name.
     * @return the first name
     */
    public String getFirstName() { return firstName; }
    /**
     * Sets the customer's first name.
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Gets the customer's last name.
     * @return the last name
     */

    public String getLastName() { return lastName; }
    /**
     * Sets the customer's last name.
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Gets the customer's age.
     * @return the age
     */
    public int getAge() { return age; }
    /**
     * Sets the customer's age.
     * @param age the age to set
     */
    public void setAge(int age) { this.age = age; }

    /**
     * Gets the customer's email.
     * @return the email
     */
    public String getEmail() { return email; }
    /**
     * Sets the customer's email.
     * @param email the email to set
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Gets the customer's phone number.
     * @return the phone number
     */
    public String getPhone() { return phone; }
    /**
     * Sets the customer's phone number.
     * @param phone the phone number to set
     */
    public void setPhone(String phone) { this.phone = phone; }

    /**
     * Gets the customer's street address.
     * @return the address
     */
    public String getAddress() { return address; }
    /**
     * Sets the customer's street address.
     * @param address the address to set
     */
    public void setAddress(String address) { this.address = address; }

    /**
     * Gets the customer's membership level.
     * @return the membership
     */
    public String getMembership() { return membership; }
    /**
     * Sets the customer's membership level.
     * @param membership the membership to set
     */
    public void setMembership(String membership) { this.membership = membership; }

    /**
     * Returns a formatted String representation of the Customer.
     * @return A String representation of the customer.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", membership='" + membership + '\'' +
                '}';
    }
}