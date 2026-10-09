package ua.opnu;

public class Student extends Person {
    private String group;
    private String studentCardNumber;

    public Student(String lastName, String firstName, int age, String group, String studentCardNumber) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentCardNumber = studentCardNumber;
    }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public String getStudentCardNumber() { return studentCardNumber; }
    public void setStudentCardNumber(String studentCardNumber) { this.studentCardNumber = studentCardNumber; }

    @Override
    public String toString() {
        return "Студент групи " + group + ", " + getLastName() + " " + getFirstName() +
                ", вік: " + getAge() + ". Номер студентського квитка: " + studentCardNumber;
    }
}