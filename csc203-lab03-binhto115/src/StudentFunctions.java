public class StudentFunctions {
    public static String getStudentInfo(Student student) {
        return student.getName() + " " + student.getAge() + " " + student.getGPA();
    }

    public static String getLetterGrade(Student student) {
        return student.getLetterGrade(student.getGPA());
    }
}