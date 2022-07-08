package task;

import java.sql.SQLException;
import java.sql.Statement;

public class MainClass {
    public static void main(String[] args) {
        StudentsBase studentsBase = new StudentsBase("127.0.0.1", "5432", "postgres");
        String user = "postgres";
        String pass = "root";
        try {
            Statement statement = studentsBase.createConnection(user, pass);
            //studentsBase.getAllStudents(statement).forEach(System.out::println);
            studentsBase.addStudent(statement, new Student("Elisey", "Zhdanov"));
            // studentsBase.deleteElement(statement, "students", "12");
            studentsBase.addCountry(statement, "Ethiopia");
            studentsBase.getAllStudentsWithCountries(statement).forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
