package task;

public class Student {
    private String id;
    private String firstName;
    private String secondName;

    private String country;

    public Student(String id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Student(String id, String firstName, String secondName, String country) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
    }

    public Student(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        String line = id + "\t" + firstName + " " + secondName;
        if (country != null) {
            line = line + " \t " + country;
        }
        return line;
    }
}
