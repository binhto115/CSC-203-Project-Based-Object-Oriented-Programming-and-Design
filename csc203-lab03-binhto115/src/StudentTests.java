import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {
    @Test
    public void testGetStudentInfo1() {
        Student studentInfo = new Student("Binh", 18, 4.0);
        String studentInfoTestCase = "Binh 18 4.0";
        assertEquals(studentInfoTestCase, StudentFunctions.getStudentInfo(studentInfo));
    }

    @Test
    public void testGetStudentInfo2() {
        Student studentInfo2 = new Student("Tommy", 20, 2.0);
        String studentInfoTestCase2 = "Tommy 20 2.0";
        assertEquals(studentInfoTestCase2, StudentFunctions.getStudentInfo(studentInfo2));

    }

    @Test
    public void testGetStudentGrade1() {
        Student studentInfo3 = new Student( "Jeremy", 19, 3.8);
        String studentInfoTestCase3 = "B";
        assertEquals(studentInfoTestCase3, StudentFunctions.getLetterGrade(studentInfo3));
    }

    @Test
    public void testGetStudentGrade2() {
        Student studentInfo4 = new Student("Luisa", 23, 3.6);
        String studentInfoTestCase4 = "B";
        assertEquals(studentInfoTestCase4, StudentFunctions.getLetterGrade(studentInfo4));
    }

    @Test
    public void getStudentInfoTest1() {
        Student StudentInfo4 = new Student("Sellas", 18, 4.5);
        String StudentInfoTestCase5 = "Sellas 18 4.5";
        assertEquals(StudentInfoTestCase5, StudentInfo4.getStudentInfo());
    }

    @Test
    public void getStudentInfoTest2() {
        Student StudentInfo5 = new Student("TinyRosemary", 18, 0.5);
        String StudentInfoTestCase6 = "TinyRosemary 18 0.5";
        assertEquals(StudentInfoTestCase6, StudentInfo5.getStudentInfo());
    }

    @Test
    public void getLetterGPATest1() {
        Student StudentInfo6 = new Student("Sellas", 18, 4.5);
        String StudentInfoTestCase7 = "A";
        assertEquals(StudentInfoTestCase7, StudentInfo6.getLetterGrade(StudentInfo6.getGPA()));
    }
    @Test
    public void getLetterGPATest2() {
        Student StudentInfo7 = new Student("TinyRosemary", 18, 0.5);
        String StudentInfoTestCase8 = "F";
        assertEquals(StudentInfoTestCase8, StudentInfo7.getLetterGrade(StudentInfo7.getGPA()));
    }

}