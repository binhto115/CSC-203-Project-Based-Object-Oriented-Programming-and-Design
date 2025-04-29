public class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(int age) {
        this.age = age;
    }

    public double getGPA() {
        return this.gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public String getStudentInfo(){
        return this.name + " " + this.age + " " + this.gpa;
    }

    public String getLetterGrade(double gpa) {
        if (gpa >= 4.0) {
            return "A";
        }
        else if (gpa >= 3.0) {
            return "B";
        }
        else if (gpa >= 2.0) {
            return "C";
        }
        else if (gpa >= 1.0) {
            return "D";
        }
        else {
            return "F";
        }
    }
}