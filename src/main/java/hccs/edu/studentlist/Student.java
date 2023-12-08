package hccs.edu.studentlist;

public class Student {
    private String name;
    private double gpa;
    private String gender;

    public Student(String name, double gpa, String gender) {
        this.name = name;
        this.gpa = gpa;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", gpa=" + gpa + ", gender=" + gender + "]";
    }
    
}
