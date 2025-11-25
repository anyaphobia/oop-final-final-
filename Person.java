// this is the Person class (a blueprint for account holders in the library system)
public class Person {  //represents a library account holder
    // attributes that store the data for each person
    private int id;
    private String fname;
    private String mname;
    private String lname;
    private String gender;
    private String bday; 
    private long cnumber;
    private String email;
    private int numOfStrikes; // number of violations
    
    private boolean hasBorrowed = false;
    private Material borrowedMaterial = null;

    // SETTERS AND GETTERS
    public boolean isHasBorrowed() {
        return hasBorrowed;
    }

    public void setHasBorrowed(boolean hasBorrowed) {
        this.hasBorrowed = hasBorrowed;
    }

    public Material getBorrowedMaterial() {
        return borrowedMaterial;
    }

    public void setBorrowedMaterial(Material borrowedMaterial) {
        this.borrowedMaterial = borrowedMaterial;
    }

    //method to add strikes
    public void addStrike() {
        this.numOfStrikes += 1;
    }

    //counting strikes
    public void setNumOfStrikes(int newNumOfStrikes) {
    this.numOfStrikes = newNumOfStrikes;
    }

    public int getNumOfStrikes() {
        return this.numOfStrikes;
    }

    // SETTERS AND GETTERS
    public void setID(int newID) {
        this.id = newID;
    }

    public int getID() {
        return this.id;
    }

    public void setFname(String newFname) {
        this.fname = newFname;
    }
    public String getFname() {
        return this.fname;
    }

    public void setMname(String newMname) {
        this.mname = newMname;
    }
    public String getMname() {
        return this.mname;
    }

    public void setLname(String newLname) {
        this.lname = newLname;
    }
    public String getLname() {
        return this.lname;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }
    public String getGender() {
        return this.gender;
    }

    public void setBday(String newBday) {
        this.bday = newBday;
    }
    public String getBday() {
        return this.bday;
    }

    public void setCnumber(long newCnumber) {
        this.cnumber = newCnumber;
    }
    public long getCnumber() {
        return this.cnumber;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public String getEmail() {
        return this.email;
    }
    
    public Person() { //constructor initializes all attributes to default values
        this.id = 0;
        this.fname = "";
        this.mname = "";
        this.lname = "";
        this.gender = "";   
        this.bday = "";
        this.cnumber = 0;
        this.email = "";
        this.numOfStrikes = 0;
    }

    public void displayInfo() { //prints all the information
        System.out.println("ID: " + this.id);
        System.out.println("First Name: " + this.fname);
        System.out.println("Middle Name: " + this.mname);
        System.out.println("Last Name: " + this.lname);
        System.out.println("Gender: " + this.gender);
        System.out.println("Birthday: " + this.bday);
        System.out.println("Contact Number: " + this.cnumber);
        System.out.println("Email: " + this.email);
        System.out.println("Number of Violations: " + this.numOfStrikes);
    }

}

