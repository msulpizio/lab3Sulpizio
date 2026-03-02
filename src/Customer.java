
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

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMembership() { return membership; }
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