package model;

public class Student {
    private String email;
    private String firstname;
    private String lastname;
    private String dob;
    private long phoneNumber;

    public Student() {
    }

    public Student(String email, String firstname, String lastname, String dob, long phoneNumber) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{\n" +
                "email='" + email +"\n"+ '\'' +
                ", firstname='" + firstname +"\n"+ '\'' +
                ", lastname='" + lastname +"\n"+ '\'' +
                ", dob='" + dob +"\n"+ '\'' +
                ", phoneNumber=" + phoneNumber +"\n"+
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
