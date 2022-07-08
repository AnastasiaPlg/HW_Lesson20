package task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsBase {
    private String host;
    private String port;
    private String base;
    private String user;
    private String pass;
    private String url;

    public StudentsBase(String host, String port, String base) {
        this.host = host;
        this.port = port;
        this.base = base;
        url = "jdbc:postgresql://" + host + ":" + port + "/" + base;
    }

    public Statement createConnection(String user, String pass) throws SQLException {
        this.user = user;
        this.pass = pass;
        ResultSet resultSet = null;
        Connection connection = DriverManager.getConnection(url, user, pass);
        assert connection != null : "connection is null";
        return connection.createStatement();
    }

    public List<Student> getAllStudents(Statement statement) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            Student student = new Student(id, firstName, lastName);
            students.add(student);
        }
        return students;
    }

    public List<Student> getAllStudentsWithCountries(Statement statement) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students JOIN countries ON students.id = countries.id";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String country = resultSet.getString("country");
            Student student = new Student(id, firstName, lastName, country);
            students.add(student);
        }
        return students;
    }

    public void addStudent(Statement statement, Student student) throws SQLException {
        String sql = "INSERT INTO students(firstName, lastName) VALUES ('" + student.getFirstName() + "', '" + student.getSecondName() + "')";
        statement.execute(sql);
        System.out.println("Student " + student.getFirstName() + " " + student.getSecondName() + " was added.");
    }

    public void addCountry(Statement statement, String country) throws SQLException {
        String sql = "INSERT INTO countries (country) VALUES ('" + country + "')";
        statement.execute(sql);
        System.out.println("Country " + country + " was added.");
    }

    public void deleteElement(Statement statement, String baseName, String id) throws SQLException {
        String sql = "DELETE FROM " + baseName + " WHERE id = " + id;
        statement.execute(sql);
        System.out.println("Element with id = " + id + " was deleted from table " + baseName);
    }
}


