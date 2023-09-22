package Source;


public class employee {
    private String firstName;
    private String phoneNumber;

    public employee() {
        setFirstName("Name");
        setPhoneNumber("N/A");
    }

    public employee(String s, String p) {
        setFirstName(s);
        setPhoneNumber(p);
    }

    public void setFirstName(String s) {
        firstName = s;
    }

    public void setPhoneNumber(String p) {
        phoneNumber = p;
    }

    public void printDetails() {
        System.out.println("Name: " + firstName);
        System.out.println("Phone #: " + phoneNumber);
    }

    public String getName() {
        return firstName;
    }
}
